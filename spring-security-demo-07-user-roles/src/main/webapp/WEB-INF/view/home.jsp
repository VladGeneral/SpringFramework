<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: vladgeneral
  Date: 28.08.2020
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>luv2code Home page</h2>
Welcome to the luv2code company home page
<p>
    User: <security:authentication property="username"/>
    <br>
    <br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

<p>
    <form:form action="${pageContext.request.contextPath}/logout"
    method="post">
        <input type="submit" value="Logout"/>
    </form:form>
</p>
</body>
</html>
