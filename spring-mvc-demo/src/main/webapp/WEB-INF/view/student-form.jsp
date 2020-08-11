<%--
  Created by IntelliJ IDEA.
  User: vladgeneral
  Date: 11.08.2020
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
    <%--<form:select path="country">

                 <form:option value="Brazil" label="Brazil"/>
                 <form:option value="France" label="France"/>
                 <form:option value="Germany" label="Germany"/>
                 <form:option value="India" label="India"/>

    </form:select>--%>

    <form:select path="country">

        <form:options items="${student.countryOptions}"/>

    </form:select>

    <br><br>
    <input type="submit">

</form:form>
</body>
</html>
