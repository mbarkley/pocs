/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.mpbarkley.apt;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 *
 * @author Max Barkley <mbarkley@redhat.com>
 */
@SupportedAnnotationTypes({ AProcessor.A_FQCN })
public class AProcessor extends AbstractProcessor {

  static final String A_FQCN = "ca.mpbarkley.apt.A";

  @Override
  public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
    System.out.println("---------------------------------");
    final List<? extends Element> elements = annotations.stream().flatMap(anno -> roundEnv.getElementsAnnotatedWith(anno).stream()).collect(Collectors.toList());
    System.out.println("AProcessor called.");
    System.out.println("Number of elements: " + elements.size());
    System.out.println("Elements: " + elements);
    System.out.println("Processing over: " + roundEnv.processingOver());

    // Generate something with @B
    for (final TypeElement anno : annotations) {
      for (final Element elem : roundEnv.getElementsAnnotatedWith(anno)) {
        final String derivedFqcn = ((TypeElement) elem).getQualifiedName().toString() + "B";
        final String derivedSimpleName = elem.getSimpleName().toString() + "B";
        try {
          final JavaFileObject src = processingEnv.getFiler().createSourceFile(derivedFqcn, elem);
          final Writer writer = src.openWriter();
          writer.write(String.format(
                  "package ca.mpbarkley.apt;\n"
                          + "\n"
                          + "import ca.mpbarkley.apt.B;\n"
                          + "\n"
                          + "@B\n"
                          + "public class %s {\n"
                          + "\n"
                          + "}\n"
                          + "\n",
                          derivedSimpleName));
          writer.close();
        } catch (final IOException e) {
          System.out.println("Unexpected error processing " + elem);
          e.printStackTrace();
        }
      }
    }

    // Generating something that would cause an error if processed to verify that we really aren't processing any more output
    if (roundEnv.processingOver()) {
      try {
        final JavaFileObject src = processingEnv.getFiler().createSourceFile("ca.mpbarkley.apt.Bomb");
        final Writer writer = src.openWriter();
        writer.write(
                "package ca.mpbarkley.apt;\n"
                + "\n"
                + "import ca.mpbarkley.apt.Unused;\n"
                + "\n"
                + "@Unused\n"
                + "public class Bomb {\n"
                + "\n"
                + "}\n"
                + "\n");
      } catch (final IOException e) {
        System.out.println("Error creating bomb.");
        e.printStackTrace();
      }
    }

    return false;
  }

}
