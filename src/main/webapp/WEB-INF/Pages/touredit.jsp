<%-- 
    Document   : touredit
    Created on : Apr 4, 2022, 5:42:36 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
        <form:input path="title" name="title" />
        <form:errors path="title" cssClass="text-danger" />

        <label for="price"><b>Price:</b></label>
        <form:input path="price" name="price" />
        <form:errors path="price" cssClass="text-danger" />

        <label for="day"><b>Number of Day:</b></label>
        <form:input path="day" name="day" style="width:10%" />
        <form:errors path="day" cssClass="text-danger" />

        <label for="night"><b>Number of Night:</b></label>
        <form:input path="night" name="night" style="width:10%" />
        <form:errors path="night" cssClass="text-danger" />

        <label for="deppoint"><b>Departure Point:</b></label>
        <form:input path="departurePoint" name="deppoint" />
        <form:errors path="departurePoint" cssClass="text-danger" />

        <label for="deptime"><b>Departure Time:</b></label>
        <form:input type="datetime-local" path="departureTime" id="deptime" name="deptime" />

        <label for="overview"><b>Description Overview:</b></label>
        <form:textarea path="overview" name="overview" 
                       style="width: 100%; height: 25%" />
        <form:errors path="overview" cssClass="text-danger" />

        <!-- Highlight -->
        <label style="margin-top: 10px"><b>-HIGHLIGHTS-</b></label>

        <div id ="highlightdiv" class="d-flex flex-column">

        </div>
        <button type="button" onclick="addHighlightInput()" style="width:auto">+</button>
        <button type="button" onclick="removeLastHighlight()" style="width:auto">-</button>

        <!-- Itinerary -->
        <label style="margin-top: 10px"><b>-ITINERARY-</b></label>

        <div id ="itinerarydiv" class="d-flex flex-column">

        </div>
        <button type="button" onclick="addItineraryInput()" style="width:auto">+</button>
        <button type="button" onclick="removeLastItinerary()" style="width:auto">-</button>

        <!-- Image -->
        <label for="img" style="margin-top: 30px"><b>SELECT IMAGE:</b></label>
        <form:input type="file" path="imgFile" id="img" name="img" accept="image/*" onchange="displayImage(this)" />
        <input type="hidden" id="currentimg" name="currentimg" value="${tour.img}" />
        <img id="showimg" src="${tour.img}" width="700" height="300" />

        <div id='removebtndiv'>

        </div>
        <button id="submitbtn" type="submit" name="submitbtn">Save</button>
    </div>
</form:form>

<script>
    window.onload = () => {
    <c:forEach items='${highlights}' var='highlight'>
        var input = document.createElement("input");
        input.style.cssText = 'margin-bottom: 1rem';
        input.id = 'highlight[]';
        input.name = 'highlight[]';
        input.value = '${highlight.highlight}';
        document.getElementById("highlightdiv").appendChild(input);
    </c:forEach>
    <c:forEach items='${itinerary}' var='itinerary'>
        var div = document.createElement("div");
        div.style.cssText = 'display: flex; flex-direction: column; margin-bottom: 2rem;';
        var inputName = document.createElement("input");
        inputName.id = 'itineraryname[]';
        inputName.name = 'itineraryname[]';
        inputName.value = '${fn:replace(itinerary.name, '\'', "")}';

        var inputDescription = document.createElement("textarea");
        inputDescription.id = 'itinerarydescription[]';
        inputDescription.name = 'itinerarydescription[]';
        inputDescription.value = '${itinerary.description}';
        inputDescription.rows = 3;
        inputDescription.cols = 70;

        div.appendChild(inputName);
        div.appendChild(inputDescription);

        document.getElementById("itinerarydiv").appendChild(div);
    </c:forEach>
    };
</script>