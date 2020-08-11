<jsp:useBean id="student" scope="request" type="com.springdemo.mvc.Student"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladgeneral
  Date: 11.08.2020
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation page</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
</body>
</html>
