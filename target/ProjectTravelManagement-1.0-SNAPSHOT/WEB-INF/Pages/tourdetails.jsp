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
    <c:if test="${msg != null}">
            <div class="alert" style="background-color: green">
                <span class="closebtnalert" 
                      onclick="this.parentElement.style.display = 'none';">&times;
                </span> 
                ${msg}
            </div>
        </c:if>
    <div class="row">  
        <img src="${tour.img}"  width="700" height="300" alt="tour img" style="float:left; margin-right: 10px">
        <div class="col-md-4">
            <h4><b>${tour.title} (${tour.day} days ${tour.night} nights)</b></h4>
            <p>Price: ${tour.price}$</p>
            <p>Departure Point: ${tour.departurePoint}</p>
            <p>
                Departure Time: 
                <fmt:formatDate type = "both" 
                                dateStyle = "long" timeStyle = "medium" 
                                value = "${tour.departureTime}" />
            </p>
            <c:url value = "/tours/${tour.id}/book" var="bookAction" />
            <a href="${bookAction}">Book</a>
        </div>

        <div class="col-md-4">
            <c:if test="${pageContext.request.userPrincipal.name != null
                          && pageContext.request.userPrincipal.authorities != '[Customer]'}">
                <c:url value = "/tours/${tour.id}/edit" var="editAction" />
                <a href="${editAction}" class="btn btn-primary">Edit</a>

                <c:if test="${pageContext.request.userPrincipal.authorities == '[Admin]'}">
                    <c:url value = "/tours/${tour.id}/delete" var="deleteAction" />
                    <form:form action ="${deleteAction}">
                        <button id="delsubmit" type="submit" name="delbtn">Delete</button>
                    </form:form>
                </c:if>
            </c:if> 
        </div>
    </div>
</div>

<div class="container">
    <h2><b>Overview</b></h2>
    <p>${tour.overview}</p>
</div>

<hr>

<div class="container">
    <h2><b>Highlights</b></h2>
    <c:forEach items='${highlights}' var='highlight'>
        <p>- ${highlight.highlight}</p>
    </c:forEach>
</div>

<hr>

<div class="container">
    <h2><b>Itinerary</b></h2>
    <c:forEach items='${itinerary}' var='itinerary'>
        <h3><b>${itinerary.name}</b></h3>
        <p>${itinerary.description}</p>
    </c:forEach>
</div>

<hr>
<!-- Review -->
<div class="container">
    <h2><b>Reviews</b></h2>
    <c:url value="/tours/${tour.id}/review" var = "review" />
    <form:form action="${review}" method="post" modelAttribute="review">
        <div class="rating"> 
            <input type="radio" name="rating" value="5" id="5star"><label for="5star">☆</label> 
            <input type="radio" name="rating" value="4" id="4star"><label for="4star">☆</label> 
            <input type="radio" name="rating" value="3" id="3star"><label for="3star">☆</label> 
            <input type="radio" name="rating" value="2" id="2star"><label for="2star">☆</label> 
            <input type="radio" name="rating" value="1" id="1star"><label for="1star">☆</label> 
        </div>
        <form:textarea placeholder="Review Here..." path="comment" name="comment" style="width: 100%; height: 25%" />
        <form:errors path="comment" cssClass="text-danger" />

        <button id="submitbtn" type="submit" name="submitbtn">Submit</button>
    </form:form>

    <br>

    <c:forEach items="${reviews}" var = "reviews">
        <div class="row">
            <div class="col-md-7">
                <img src="${reviews[2]}" class="rounded-circle" width="40" style="float:left" />
                <p><b>${reviews[1]} - ${reviews[3]}/5</b></p>
                <p>${reviews[4]}</p>
            </div>
            <div class="col-md-3">
                <p>
                    <fmt:formatDate type = "both" 
                                    dateStyle = "long" timeStyle = "medium" 
                                    value = "${reviews[5]}" />
                </p>
            </div>
        </div>
    </c:forEach>
</div>