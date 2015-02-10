<!DOCTYPE html>
<%
   String contextPath = getServletContext().getContextPath();
%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Errai - Tutorial</title>
<meta name="description" content="">
<meta name="author" content="">

<link href="<%=contextPath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=contextPath%>/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="<%=contextPath%>/css/application.css" rel="stylesheet">

<link href='http://fonts.googleapis.com/css?family=Gudea:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Inconsolata' rel='stylesheet' type='text/css'>

<link rel="shortcut icon" href="<%=contextPath%>/favicon.ico">
<link rel="apple-touch-icon" href="<%=contextPath%>/favicon.ico">

<link rel="apple-touch-icon" sizes="72x72" href="<%=contextPath%>/images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=contextPath%>/images/apple-touch-icon-114x114.png">

<script type="text/javascript" language="javascript" src="<%=contextPath%>/app/app.nocache.js"></script>
</head>

<body>
  <div id="rootPanel"></div>

  <iframe src="javascript:''" id="__gwt_historyFrame" style="width: 0; height: 0; border: 0"></iframe>

  <script src="<%=contextPath%>/bootstrap/js/bootstrap.min.js"></script>
  <script src="bootstrap/js/spin.min.js"></script>
  <script type="text/javascript">
    var spinner_opts = {
		  lines: 17, // The number of lines to draw
		  length: 20, // The length of each line
		  width: 10, // The line thickness
		  radius: 30, // The radius of the inner circle
		  corners: 1, // Corner roundness (0..1)
		  rotate: 0, // The rotation offset
		  direction: 1, // 1: clockwise, -1: counterclockwise
		  color: '#000', // #rgb or #rrggbb or array of colors
		  speed: 1, // Rounds per second
		  trail: 60, // Afterglow percentage
		  shadow: false, // Whether to render a shadow
		  hwaccel: false, // Whether to use hardware acceleration
		  className: 'spinner', // The CSS class to assign to the spinner
		  zIndex: 2e9, // The z-index (defaults to 2000000000)
		  top: '60%', // Top position relative to parent
		  left: '45%' // Left position relative to parent
		};
    var spinner = new Spinner(spinner_opts);
  </script>
</body>
</html>
