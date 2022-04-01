<%-- 
    Document   : newtour
    Created on : Apr 1, 2022, 7:26:46 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form:form action="/ProjectTravelManagement/tours/new" method="post" modelAttribute="tour">
    <h1 class="text-center">NEW TOUR</h1>
    <div class="container">
        <label for="title"><b>Title</b></label>
        <form:input placeholder="Enter Username" path="title" name="title" />
        <form:errors path="title" cssClass="text-danger" />
        
        <%-- <form>
            <div class="form-row">
              <div class="col">
                <label for="day"><b>Number of day</b></label>
                <form:input placeholder="Enter Number of Day" path="day" name="day" />
                <form:errors path="day" cssClass="text-danger" />
              </div>
              <div class="col">
                <label for="night"><b>Number of night</b></label>
                <form:input placeholder="Enter Number of Night" path="night" name="night" />
                <form:errors path="night" cssClass="text-danger" />
              </div>
            </div>
        </form> --%>
        
        <label for="price"><b>Price</b></label>
        <form:input placeholder="Enter Price" path="price" name="price" />
        <form:errors path="price" cssClass="text-danger" />
        
        <label for="deppoint"><b>Departure Point</b></label>
        <form:input placeholder="Enter Departure Point" path="departurePoint" name="deppoint" />
        <form:errors path="departurePoint" cssClass="text-danger" />
        
        <label for="deptime"><b>Departure Time</b></label>
        <form:input placeholder="Departure Time" path="departureTime" name="deptime" />
        <form:errors path="departureTime" cssClass="text-danger" />
        
        <label for="overview"><b>Description Overview</b></label>
        <form:textarea placeholder="Description Overview" path="overview" name="overview" style="width: 100%; height:25%" />
        <form:errors path="overview" cssClass="text-danger" />
        
        <form>
            <label for="img"><b>Select Image<b></label>
            <input type="file" id="img" name="img" accept="image/*">
        </form>
        
        <c:if test="${msg!=null}">
            <div class="alert">
                <span class="closebtnalert" 
                      onclick="this.parentElement.style.display='none';">&times;
                </span> 
                ${msg}
            </div>
        </c:if>
        
        <c:if test="${statusmsg!=null}">
            <div class="alert" style="background-color: green">
                <span class="closebtnalert"
                      onclick="this.parentElement.style.display='none';">&times;
                </span> 
                ${statusmsg}
            </div>
        </c:if>
        
        <button type="submit" name="submitbtn">SUBMIT</button>
    </div>
</form:form>