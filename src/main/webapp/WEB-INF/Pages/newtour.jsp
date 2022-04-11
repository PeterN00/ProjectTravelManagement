<%-- 
    Document   : newtour
    Created on : Apr 1, 2022, 3:32:00 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/tours/add" var="addtour" />
<form:form action="${addtour}" method="post" modelAttribute="tour"
           enctype="multipart/form-data">
    <h1 class="text-center">NEW TOUR</h1>

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

        <label for="price"><b>Price:</b></label>
        <form:input placeholder="Enter Price" path="price" name="price" />
        <form:errors path="price" cssClass="text-danger" />

        <label for="day"><b>Number of Day:</b></label>
        <form:input placeholder="Day..." path="day" name="day" style="width:10%" />
        <form:errors path="day" cssClass="text-danger" />

        <label for="night"><b>Number of Night:</b></label>
        <form:input placeholder="Night..." path="night" name="night" style="width:10%" />
        <form:errors path="night" cssClass="text-danger" />

        <label for="deppoint"><b>Departure Point:</b></label>
        <form:input placeholder="Enter Departure Point" path="departurePoint" name="deppoint" />
        <form:errors path="departurePoint" cssClass="text-danger" />

        <label for="deptime"><b>Departure Time:</b></label>
        <form:input type="datetime-local" path="departureTime" id="deptime" name="deptime" />

        <label for="overview"><b>Description Overview:</b></label>
        <form:textarea placeholder="Enter Overview for Description" path="overview" name="overview" style="width: 100%; height: 25%" />
        <form:errors path="overview" cssClass="text-danger" />
        
        <!-- Highlight -->
        <label style="margin-top: 10px"><b>-HIGHLIGHTS-</b></label>

        <div id ="highlightdiv" class="d-flex flex-column">
            <input name="highlight[]" placeholder="Highlight..." style="margin-bottom: 1rem">
        </div>
        <button type="button" onclick="addHighlightInput()" style="width:auto">+</button>
        <button type="button" onclick="removeLastHighlight()" style="width:auto">-</button>
        
        <!-- Itinerary -->
        <label style="margin-top: 10px"><b>-ITINERARY-</b></label>

        <div id ="itinerarydiv" class="d-flex flex-column">
            <div style="display: flex; flex-direction: column; margin-bottom: 2rem;">
                <input name="itineraryname[]" placeholder="Day (?): Doing?...">
                <textarea rows ="3" cols ="70" name="itinerarydescription[]" placeholder="Itinerary Description..."></textarea>
            </div>
        </div>
        <button type="button" onclick="addItineraryInput()" style="width:auto">+</button>
        <button type="button" onclick="removeLastItinerary()" style="width:auto">-</button>
        
        <!-- Image -->
        <label for="img"><b>Select Image:</b></label>
        <form:input type="file" path="imgFile" id="img" name="img" accept="image/*" onchange="displayImage(this)" />
        <img id="showimg" width="700" height="300" />

        <div id='removebtndiv'>

        </div>

        <button id="submitbtn" type="submit" name="submitbtn">Submit</button>
    </div>
</form:form>

<script>
    var imgfile = document.getElementById("img");
    var img = document.getElementById("showimg");
    if (imgfile.value == '') {
        img.src = 'https://res.cloudinary.com/petern/image/upload/v1649223641/travelmanagementproject_tourimg/Empty_k2jyq6.jpg';
    }
</script>