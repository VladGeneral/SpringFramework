<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vladgeneral
  Date: 28.08.2020
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom login page</title>
    <style>
        .failed{
            color: red;
        }
    </style>
</head>
<body>
<h3>My custom login page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
           method="post">
    <c:if test="${param.error != null}">
        <i class="failed">Sorry! invalid username/password</i>
    </c:if>
    <p>
        User name: <input type="text" name="username"/>
    </p>

    <p>
        Password: <input type="password" name="password"/>
    </p>
    <input type="submit"/>

</form:form>

</body>
</html>
