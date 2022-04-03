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
<div class="row">
    
    <div class="container">     
        <img src="${tour.img}"  width="300" height="300" style="float:left; margin-right: 10px">
        <h4><b>${tour.title}</b></h4>
        <p>Price: ${tour.price} - ${tour.day} days ${tour.night} nights</p>
        <p>Departure Point: ${tour.departurePoint}</p>
        <p>
            Departure Time: 
            <fmt:formatDate type = "both" 
                        dateStyle = "long" timeStyle = "medium" 
                        value = "${tour.departureTime}" />
        </p>
        
        <c:url value = "/tours/${tour.id}/delete" var="delAction" />
        <form:form action ="${delAction}">
            <button id="delsubmit" type="submit" name="delbtn">Delete</button>
        </form:form>
    </div>
</div>