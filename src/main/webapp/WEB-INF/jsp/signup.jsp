<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Cepkeliu Robocop Byngo</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>

    Meetings!!!
    <form:form action="/start" method="POST">
        <c:if test="${not empty meetings }">
            <c:forEach var="meeting" items="${meetings}">
                <form:option value="${meeting.id }">${meeting.name}</form:option>
            </c:forEach>
        </c:if>
    </form:form>

</body>
</html>