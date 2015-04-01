Errai CRUD template
=====================

This simple project will serve as a CRUD application template.....

Start development mode
----------------------

Using GWT's Super Dev Mode, it is possible to instantly view changes to client-side code by simply refreshing the browser window. You should be able to start the demo in development mode with this single command:

    % mvn clean gwt:run

When the GWT Dev Mode window opens, press "Launch Default Browser" to start the app. You can now debug client-side code directly in the browser using source maps (make sure source maps are enabled in your browser). Alternatively, you can also configure a debug environment for Eclipse by installing

- the Google Plugin for Eclipse: https://developers.google.com/eclipse/docs/download
- the SDBG plugin: http://sdbg.github.io/

To debug server-side code, set up a remote debugger on port 8001.
Then:
* Run `mvn clean gwt:debug`
* Start your server remote debugger
* Start your client remote debugger
* Press "Launch Default Browser"