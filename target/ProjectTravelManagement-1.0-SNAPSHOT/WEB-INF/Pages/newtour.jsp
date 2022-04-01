<%-- 
    Document   : newtour
<<<<<<< HEAD
    Created on : Apr 1, 2022, 3:32:00 PM
    Author     : Admin
=======
    Created on : Apr 1, 2022, 7:26:46 AM
    Author     : PHUC
>>>>>>> 262353658113d3120e61a1bd2c3978d62d5a7469
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<<<<<<< HEAD
<c:url value="/tours/add" var="addtour" />
<form:form action="${addtour}" method="post" modelAttribute="tour">
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
=======
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
>>>>>>> 262353658113d3120e61a1bd2c3978d62d5a7469
        
        <c:if test="${msg!=null}">
            <div class="alert">
                <span class="closebtnalert" 
<<<<<<< HEAD
                      onclick="this.parentElement.style.display = 'none';">&times;
=======
                      onclick="this.parentElement.style.display='none';">&times;
>>>>>>> 262353658113d3120e61a1bd2c3978d62d5a7469
                </span> 
                ${msg}
            </div>
        </c:if>
<<<<<<< HEAD

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
              img.setAttribute("src", '');
              imgdiv.removeChild(btn);
            });
            imgdiv.appendChild(btn);
        }
    }
</script>
=======
        
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
>>>>>>> 262353658113d3120e61a1bd2c3978d62d5a7469
