<%-- 
    Document   : tourdetails
    Created on : Apr 3, 2022, 4:05:37 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<div class="container">  
    <img src="${tour.img}"  width="300" height="300" alt="tour img" style="float:left; margin-right: 10px">
    <h4><b>${tour.title}</b></h4>
    <p>Price: ${tour.price} - ${tour.day} days ${tour.night} nights</p>
    <p>Departure Point: ${tour.departurePoint}</p>
    <p>
        Departure Time: 
        <fmt:formatDate type = "both" 
                        dateStyle = "long" timeStyle = "medium" 
                        value = "${tour.departureTime}" />
    </p>

    <c:if test="${pageContext.request.userPrincipal.name != null
                  && pageContext.request.userPrincipal.authorities != '[Customer]'}">
        <c:url value = "/tours/${tour.id}/edit" var="editAction" />
        <a href="${editAction}">Edit</a>

        <c:if test="${pageContext.request.userPrincipal.authorities == '[Admin]'}">
            <c:url value = "/tours/${tour.id}/delete" var="deleteAction" />
            <form:form action ="${deleteAction}">
                <button id="delsubmit" type="submit" name="delbtn">Delete</button>
            </form:form>
        </c:if>
    </c:if>
</div>