<%-- 
    Document   : userprofile
    Created on : Apr 5, 2022, 8:11:00 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<div class="container">  
    <h1 class="text-center">PROFILE</h1>
    <img src="${user.img}"  class="rounded-circle" width="150" height="200" style="float:left; margin-right: 10px">
    <h4><b>${user.username}</b></h4>
    <p>Full name: ${user.fullName}</p>

    <c:url value = "/user/${user.username}/edit" var="editAction" />
    <a href="${editAction}">Edit</a>
</div>
