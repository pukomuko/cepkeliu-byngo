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

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <link href="css/byngo.css" rel="stylesheet">
    
    <link rel="shortcut icon" href="img/favicon.png">
    
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    
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
          <a class="navbar-brand" href="#">Čepkelių Byngo</a>
        </div>
      </div>
    </div>
    
    <div class="container">
	    <div class="panel panel-danger">
	      <div class="panel-heading">
	        <h3 class="panel-title">Registracija</h3>
	      </div>
	      <div class="panel-body">
	     
	      <form:form method="POST" commandName="signUp" role="form">
	         
	         	<form:errors path="playerName" cssClass="alert alert-danger" element="div"/>
	         	
				<div class="input-group input-group-lg">
				  <span class="input-group-addon">@</span>
				  <form:input path="playerName" cssClass="form-control input-lg" placeholder="Vardas"/>
				</div>
				
				<br/>
 
 
             <c:forEach var="meeting" items="${meetings}">
				<div class="radio">
				  <label>
				    <form:radiobutton path="meetingId" title="${meeting.name}" value="${meeting.id}"/>
				    ${meeting.name}
				  </label>
				</div>
            </c:forEach>
 
			
			<form:errors path="meetingName" cssClass="alert alert-danger" element="div"/>
			
			<div class="radio">
			  <label>
			    <form:radiobutton path="meetingId" value="new"/>
			    <form:input path="meetingName" cssClass="form-control" placeholder="Naujas meetingas"/>
			  </label>
			 </div>

			<input type="submit" class="btn btn-primary btn-lg pull-right" value="Pirmyn!"/>
			
						 
        </form:form>
	        
	        
	        </div> <!-- panel body -->
	        
	    </div>
    </div>

    
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>