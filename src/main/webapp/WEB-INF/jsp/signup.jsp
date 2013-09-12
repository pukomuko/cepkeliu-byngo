<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Čepkeliu Robocop Byngo</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>

    ${signUp}

    Meetings!!!
    <form:form method="POST" commandName="signUp">
        <form:input path="playerName"/>
        <form:errors path="playerName"/>
            <c:forEach var="meeting" items="${meetings}">
                <form:radiobutton path="meetingId" title="${meeting.name}" value="${meeting.id}"></form:radiobutton>
            </c:forEach>
            <form:radiobutton path="meetingId" value="new"/>
            <form:input path="meetingName"/>
            <form:errors path="meetingName"/>
        <input type="submit" />
    </form:form>
</body>
</html>