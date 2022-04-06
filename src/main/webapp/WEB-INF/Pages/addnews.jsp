<%-- 
    Document   : addnews
    Created on : Apr 5, 2022, 7:56:27 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/news/add" var="addnews" />
<form:form action="${addnews}" method="post" modelAttribute="news">
    <h1 class="text-center">ADD NEWS</h1>

    <c:if test="${msg!=null}">
        <div class="alert" style="background-color: green">
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${msg}
        </div>
    </c:if>

    <div class="container">
        <label for="title"><b>Title:</b></label>
        <form:input placeholder="Enter Title" path="title" name="title" />
        <form:errors path="title" cssClass="text-danger" />

        <label for="description"><b>Description:</b></label>
        <form:textarea placeholder="Enter Description" path="description" name="description" style="width: 100%; height: 25%" />
        <form:errors path="description" cssClass="text-danger" />
        
        <button id="submitbtn" type="submit" name="submitbtn">Submit</button>
    </div>
</form:form>