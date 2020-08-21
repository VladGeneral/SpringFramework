<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladgeneral
  Date: 19.08.2020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List customers</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM-Customer Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <%--        pu add customer button--%>
        <input type="button" value="Add customer"
               onclick="window.location.href='showFormForAdd'; return false"
               class="add-button"/>

            <form:form action="search" method="get">
                Search customer: <input type="text" name="theSearchName"/>
                <input type="submit" value="Search" class="add-button"/>
            </form:form>
        <%--    add our html table here--%>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <%--            loop over and print our customers--%>
            <c:forEach var="tempCustomer" items="${customers}">
<%--                construct an update link with customer id--%>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <%--                construct an delete link with customer id--%>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>

                    <td><a href="${updateLink}">Update</a> |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
