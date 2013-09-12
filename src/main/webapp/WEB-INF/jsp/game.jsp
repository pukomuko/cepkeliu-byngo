<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Čepkelių Byngo</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.css" rel="stylesheet">
    <link href="/css/byngo.css" rel="stylesheet">
    
    <link rel="shortcut icon" href="/img/favicon.png">

	<meta name="apple-mobile-web-app-status-bar-style" content="default" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    
</head>
<body class='use-fastclick'>


    <!-- Static navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Čepkelių Byngo</a>
        </div>
      </div>
    </div>

	<div class="container">

	<h4>${meeting.name}</h4>
	<div class="pull-right">Susitikimo kaina: <span id="price">0</span> Lt</div>
		
	<table id="card" class="table table-bordered byngo">
		<tr align="center">
			<td id="cell11">${phrases.next()}</td>
			<td id="cell12">${phrases.next()}</td>
			<td id="cell13">${phrases.next()}</td>
			<td id="cell14">${phrases.next()}</td>
		</tr>
		<tr align="center">
			<td id="cell21">${phrases.next()}</td>
			<td id="cell22">${phrases.next()}</td>
			<td id="cell23">${phrases.next()}</td>
			<td id="cell24">${phrases.next()}</td>
		</tr>
		<tr align="center">
			<td id="cell31">${phrases.next()}</td>
			<td id="cell32">${phrases.next()}</td>
			<td id="cell33">${phrases.next()}</td>
			<td id="cell34">${phrases.next()}</td>
		</tr>
		<tr align="center">
			<td id="cell41">${phrases.next()}</td>
			<td id="cell42">${phrases.next()}</td>
			<td id="cell43">${phrases.next()}</td>
			<td id="cell44">${phrases.next()}</td>
		</tr>
	</table>
	
	<h4>Dalyvauja</h4>
	<ul id="players" class="list-group">
		
	</ul>
	
	</div>
	
	
	
<div id="success" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Išgerk - tu laimėjai!</h4>
      </div>
      <div class="modal-body" align="center">
        <p>
        <img src="/img/cepkeliu-butelis.png">
        </p>
        <a href="/">Pradėti iš naujo</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div id="fail" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Laimėjo <span id="winner"></span>!</h4>
      </div>
      <div class="modal-body"  align="center">
        <p>
        <img src="/img/sad-panda.jpg">
        </p>
        <a href="/">Pradėti iš naujo</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
	<script src="/js/byngo.js"></script>
	<script src="/js/fastbutton.js"></script>
	<script>
		var meetingId = ${meeting.id};
	</script>

</body>
</html>
