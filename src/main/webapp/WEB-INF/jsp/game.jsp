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
<body>


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
		
	<table class="table table-bordered byngo">
		<tr align="center">
			<td valign="middle">Pasitempikim</td>
			<td>Reikia pasistengti</td>
			<td>Įgyvendinom planą</td>
			<td>Ambicingi planai</td>
		</tr>
		<tr align="center">
			<td>Klientų pasitenkinimas</td>
			<td>Dideli įkainiai</td>
			<td>Nepaisant</td>
			<td>Fiksuotos kainos projektai</td>
		</tr>
		<tr align="center">
			<td>Daugiau negu prašo</td>
			<td class="warning">Panaceja</td>
			<td>Sausainis prie kavos</td>
			<td>Kokybiškai</td>
		</tr>
		<tr align="center">
			<td>Mobillios aplikacijos</td>
			<td class="warning">Laiku</td>
			<td>Naujas ofisas</td>
			<td>Ne taip gerai kaip tikėjomės</td>
		</tr>

	</table>
	
	
	</div>

	${meeting}

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>


</body>
</html>
