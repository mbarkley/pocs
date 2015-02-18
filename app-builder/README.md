# What is it?

This is a simple prototype to demonstrate our dynamic application builder use case:
A GWT application (App A) that builds/scaffolds another application (App B), then triggers compilation of 
App B on the server and dynamically loads/injects the compiled JavaScript into the current page.

App B will further access data already present on the page (provided by App A) and render itself as 
part of an Errai UI template also defined by App A.

# How does it work?

On request (click compile and load application), App A will send an HTTP request to the server that will 
trigger compilation of App B which was previously scaffolded on the server (not part of this prototype).
When the compilation process finishes and App B is ready, the server will send a CDI event carrying the 
URL of the generated script to connected clients which can then inject the script using its URL.

The data to be displayed and the target DOM element id for App B are provided by App A and stored in a
map (registry) on the page. All relevant code for this can be found in [AppLoader.java](https://github.com/csadilek/pocs/blob/master/app-builder/src/main/java/org/jboss/errai/demo/client/local/AppLoader.java)

# How can I run it?

- Make sure Maven is installed and the M2_HOME environment variable is set (to verify run `echo $M2_HOME`
in a terminal which should output your Maven Home directory)
- From the root directory of this project run: `mvn clean gwt:run`
