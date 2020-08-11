<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladgeneral
  Date: 11.08.2020
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration form</title>

    <style>
        .error {color: red}
    </style>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name (*): <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Free passes: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br><br>
    <input type="submit">
</form:form>

</body>
</html>
