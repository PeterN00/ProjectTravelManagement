<%-- 
    Document   : newsdetails
    Created on : Apr 5, 2022, 7:04:50 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<div>
    <div class="container">     
        <h4><b>${news.title}</b></h4>
        <p>
            Last Modified: 
            <fmt:formatDate type = "both" 
                            dateStyle = "long" timeStyle = "medium" 
                            value = "${news.date}" />
        </p>
        <p>${news.description}</p>

        <c:url value = "/news/${news.id}/delete" var="deleteAction" />
        <form:form action ="${deleteAction}">
            <button id="delsubmit" type="submit" name="delbtn">Delete</button>
        </form:form>

        <c:url value = "/news/${news.id}/edit" var="editAction" />
        <a href="${editAction}">Edit</a>
    </div>
</div>