<%-- 
    Document   : userprofile
    Created on : Apr 5, 2022, 8:11:00 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container align-items-center d-flex flex-column">  
    <c:if test="${msg != null}">
        <div class="alert" style="background-color: green">
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${msg}
        </div>
    </c:if>
    
    <h1 class="text-center">PROFILE</h1>
    <img src="${user.img}"  class="rounded-circle" width="150" height="200" alt = "avatar" style="float:left; margin-right: 10px">
    <h4><b>${user.username}</b></h4>
    <p>Full name: ${user.fullName}</p>

    <c:url value = "/users/${user.username}/edit" var="editAction" />
    <a href="${editAction}" class="btn btn-primary">Edit</a>
</div>
