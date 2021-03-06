<%-- 
    Document   : tourbook
    Created on : Apr 6, 2022, 3:50:06 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/tours/${tour.id}/book" var="tourbooking" />
<form:form method="post" modelAttribute="booking" action="${tourbooking}">
    <h2 class="text-center"><b>TOUR BOOKING</b></h2>
    <c:if test="${msg != null}">
        <div class="alert" style="background-color: green">
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${msg}
        </div>
    </c:if>

    <div class="container align-items-center d-flex flex-column"> 
        <img src="${tour.img}"  width="700" height="300" alt="tour img" style="float:left; margin-right: 10px">
        <h4><b>${tour.title}</b></h4>
        <p>
            Departure Time: 
            <fmt:formatDate type = "both" 
                            dateStyle = "long" timeStyle = "medium" 
                            value = "${tour.departureTime}" />
        </p>
        <p>Departure Point: ${tour.departurePoint}</p>
        <p>Duration: ${tour.day} days ${tour.night} nights</p>
    </div>

    <hr>

    <<h3 class="text-center"><b>User Information</b></h3>

    <div class="container align-items-center d-flex flex-column text-center">
        <div>
            <label for="adultticket">Adult Ticket</label>
            <input type="number" id="adultticket" id= "adultticket" name="adultticket" 
                   placeholder="1" min="1" value="1"
                   onchange="calculatePrice('${tour.price}', '${ticketType.discount}')" />
        </div>

        <div>
            <label for="childrenticket">Children Ticket (Discount: <span id="childrendiscount">${ticketType.discount}%</span>)
            </label>
            <input type="number" id="childrenticket" id="childrenticket" name="childrenticket" 
                   placeholder="0" min="0" value="0"
                   onchange="calculatePrice('${tour.price}', '${ticketType.discount}')" />
        </div>

        <br>

        <div>
            <p><b>Price: <span id="price">${tour.price}$</span></b></p>
        </div>
        <form:input type="hidden" path="bookDate" id="currentDate" />
        <button id="submitbtn" type="submit" name="submitbtn">Book Now</button>
    </div>
</form:form>

<script>
    document.getElementById('currentDate').onload = getCurrentDateTime();
</script>