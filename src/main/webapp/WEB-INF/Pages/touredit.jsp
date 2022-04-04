<%-- 
    Document   : touredit
    Created on : Apr 4, 2022, 5:42:36 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/tours/${tour.id}/edit" var="savetour" />
<form:form action="${savetour}" method="post" modelAttribute="tour"
           enctype="multipart/form-data">
    
    <h1 class="text-center">EDIT TOUR</h1>

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
        <form:input path="title" name="title" value="${tour.title}" />
        <form:errors path="title" cssClass="text-danger" />

        <label for="price"><b>Price:</b></label>
        <form:input path="price" name="price" value="${tour.price}" />
        <form:errors path="price" cssClass="text-danger" />

        <label for="day"><b>Number of Day:</b></label>
        <form:input path="day" name="day" style="width:10%" value="${tour.day}" />
        <form:errors path="day" cssClass="text-danger" />

        <label for="night"><b>Number of Night:</b></label>
        <form:input path="night" name="night" style="width:10%" value="${tour.night}" />
        <form:errors path="night" cssClass="text-danger" />

        <label for="deppoint"><b>Departure Point:</b></label>
        <form:input path="departurePoint" name="deppoint" value="${tour.departurePoint}" />
        <form:errors path="departurePoint" cssClass="text-danger" />

        <label for="deptime"><b>Departure Time:</b></label>
        <form:input type="datetime-local" path="departureTime" id="deptime" name="deptime" value="${tour.departureTime}" />

        <label for="overview"><b>Description Overview:</b></label>
        <form:textarea path="overview" name="overview" 
                       value="${tour.overview}"
                       style="width: 100%; height: 25%" />
        <form:errors path="overview" cssClass="text-danger" />

        <label for="img"><b>Select Image:</b></label>
        <form:input type="file" path="imgFile" id="img" name="img" accept="image/*" onchange="displayImage(this)" />
        <img id="showimg" src="${tour.img}"/>

        <div id='removebtndiv'>

        </div>

        <button id="submitbtn" type="submit" name="submitbtn">Save</button>
    </div>
</form:form>
