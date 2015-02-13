package org.jboss.errai.demo.client.local;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.demo.client.shared.AppBuilderEndpoint;
import org.jboss.errai.demo.client.shared.AppError;
import org.jboss.errai.demo.client.shared.AppReady;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;

@Dependent
public class AppLoader {

  @Inject
  private Caller<AppBuilderEndpoint> endpoint;
  
  private List<String> pendingApps = new ArrayList<String>();

  @PostConstruct
  private void onInit() {
    RestClient.setApplicationRoot("/app-builder/api");  
  }

  public void loadApp(String appId, String domElementId, String dataKey) {
    prepareData(dataKey);
    prepareDom(appId, domElementId);
    pendingApps.add(appId);
    
    endpoint.call(new ResponseCallback() {
      @Override
      public void callback(Response response) {
        if (response.getStatusCode() == Response.SC_OK) {
          showSpinner();
        }
        else {
          Window.alert("Oops something went wrong! Server returned:" + response.getStatusCode());
        }
      }
    }).compileApp(appId);
  }
  
  private void onAppReady(@Observes final AppReady appReady) {
    if (!pendingApps.remove(appReady.getAppId())) return;
    
    hideSpinner();
    ScriptInjector.fromUrl(appReady.getUrl() + "?nocache=" + System.currentTimeMillis())
      .setCallback(new Callback<Void, Exception>() {
        @Override
        public void onSuccess(Void result) {
          Element e = DOM.getElementById(getDomElement(appReady.getAppId()));
          e.appendChild(new HTML("<h1>Here's your application:</h1>").getElement());
          disableButton();
        }
        
        @Override
        public void onFailure(Exception reason) {
          Window.alert("Problem injecting script:" + reason.getMessage());      
        }
    })
    .setWindow(ScriptInjector.TOP_WINDOW)
    .inject();
  }
  
  private void onAppError(@Observes AppError appError) {
    hideSpinner();
    Window.alert("Problem loading application:" + appError.getMessage());
  }
  
  private native void showSpinner() /*-{
    var target = $doc.getElementById('loading');
    target.style.display = 'block';
    $wnd.spinner.spin(target);
    
    var placeholder = $doc.getElementById('placeholder');
    placeholder.style.display = 'none';
  }-*/;
  
  private native void hideSpinner() /*-{
    var target = $doc.getElementById('loading');
    target.style.display = 'none';
    $wnd.spinner.stop();
  }-*/;
  
  private native void disableButton() /*-{
    var target = $doc.getElementById('loadApp');
    target.disabled = true;
  }-*/;
  
  private native void prepareData(String dataKey) /*-{
    $wnd.app_data[dataKey] = [
      { "firstName" : "Christian", "lastName" : "Sadilek", "email": "csadilek@redhat.com" },
      { "firstName" : "Mark", "lastName" : "Proctor", "email": "mproctor@redhat.com" },
      { "firstName" : "Alex", "lastName" : "Porcelli", "email": "abakos@redhat.com" },
      { "firstName" : "Eder", "lastName" : "Ignatowicz", "email": "ignatowicz@gmail.com" },
      { "firstName" : "Michael", "lastName" : "Anstis", "email": "manstis@redhat.com" },
      { "firstName" : "many more...", "lastName" : "", "email": "" },
    ];
  }-*/;
  
  private native void prepareDom(String appId, String domElementId) /*-{
    $wnd.app_roots[appId] = domElementId;
  }-*/;
  
  private native String getDomElement(String appId) /*-{
    return $wnd.app_roots[appId];
  }-*/;
}
