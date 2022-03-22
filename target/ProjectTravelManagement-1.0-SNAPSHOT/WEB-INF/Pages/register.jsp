<%-- 
    Document   : register
    Created on : Mar 18, 2022, 9:46:59 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            <%@include file="/resources/style.css"%>
        </style>
    </head>
    
    <body>
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
    </body>
    
</html>
