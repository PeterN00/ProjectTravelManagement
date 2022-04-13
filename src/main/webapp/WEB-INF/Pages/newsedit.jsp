<%-- 
    Document   : newsedit
    Created on : Apr 5, 2022, 8:48:50 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/news/${news.id}/edit" var="savenews" />
<form:form action="${savenews}" method="post" modelAttribute="news">

    <h1 class="text-center">EDIT NEWS</h1>

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
        <form:input path="title" name="title" />
        <form:errors path="title" cssClass="text-danger" />

        <label for="overview"><b>Description:</b></label>
        <form:textarea path="description" name="description" 
                       style="width: 100%; height: 25%" />
        <form:errors path="description" cssClass="text-danger" />

        <button id="submitbtn" type="submit" name="submitbtn">Save</button>
    </div>
</form:form>