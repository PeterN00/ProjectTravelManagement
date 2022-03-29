<%-- 
    Document   : register
    Created on : Mar 18, 2022, 9:46:59 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form:form action="/ProjectTravelManagement/register" method="post" modelAttribute="user">
    <h1 class="text-center">CUSTOMER REGISTRATION FORM</h1>
    <div class="container">
        <label for="usrname"><b>Username</b></label>
        <form:input placeholder="Enter Username" path="username" name="usrname" />

        <label for="psw"><b>Password</b></label>
        <form:password placeholder="Enter Password" path="password" name="psw" />

        <label for="fullname"><b>Full Name</b></label>
        <form:input placeholder="Enter Full Name" path="fullName" name="fullname" />

        <button type="submit" name="regbtn">Register</button>
        <button type="button" onclick="history.back()" class="cancelbtn">Back</button>
    </div>
</form:form>
<c:forEach items="${users}" var="user">
    <p class="text-center">
        ${user.id}, ${user.username}, ${user.password}, ${user.fullName}</p>
</c:forEach>