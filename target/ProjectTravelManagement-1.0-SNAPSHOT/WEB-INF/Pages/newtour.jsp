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

        <div id='imgdiv'>
            <label for="img"><b>Select Image:</b></label>
            <form:input type="file" path="imgFile" id="img" name="img" accept="image/*" onchange="readURL(this)" />
            <img id="showimg" />
        </div>
        
        <c:if test="${msg!=null}">
            <div class="alert" style="background-color: green">
                <span class="closebtnalert" 
                      onclick="this.parentElement.style.display = 'none';">&times;
                </span> 
                ${msg}
            </div>
        </c:if>

        <button type="submit" name="submitbtn">Submit</button>
    </div>
</form:form>

<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#showimg').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
            
            var btn = document.createElement("button");
            var text = document.createTextNode(" Remove Image");
            var icon = document.createElement("i");
            icon.className = "fa fa-close";
            var imgdiv = document.getElementById("imgdiv");
            btn.appendChild(icon);
            btn.appendChild(text);
            btn.style.backgroundColor = "Red";
            
            btn.addEventListener("click", function () {
              var img = document.getElementById("showimg");
              img.src = '';
              imgdiv.removeChild(btn);
            });
            imgdiv.appendChild(btn);
        }
    }
</script>
