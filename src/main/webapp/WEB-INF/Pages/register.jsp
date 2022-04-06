<%-- 
    Document   : register
    Created on : Mar 18, 2022, 9:46:59 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/users/register" var="register" />
<form:form action="${register}" method="post" modelAttribute="user" enctype="multipart/form-data">
    <h1 class="text-center">REGISTRATION FORM</h1>
    <div class="container">
        <label for="usrname"><b>Username</b></label>
        <form:input placeholder="Enter Username" path="username" name="usrname" />
        <form:errors path="username" cssClass="text-danger" />

        <label for="fullname"><b>Full Name</b></label>
        <form:input placeholder="Enter Full Name" path="fullName" name="fullname" />
        <form:errors path="fullName" cssClass="text-danger" />

        <label for="psw"><b>Password</b></label>
        <form:password placeholder="Enter Password" path="password" name="psw" />
        <form:errors path="password" cssClass="text-danger" />

        <label for="repsw"><b>Retype Password</b></label>
        <form:password placeholder="Retyped Password" path="retypePassword" name="repsw" />

        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null
                            && pageContext.request.userPrincipal.authorities == '[Admin]'}">
                    <label for="role"><b>Role:</b></label>
                    <form:select name="role" path="role" id="role">
                        <option value="Admin">Admin</option>
                        <option value="Employee">Employee</option>
                        <option value="Customer">Customer</option>
                    </form:select>
            </c:when>

            <c:otherwise>
                <form:input type="hidden" path="role" value="Customer" />
            </c:otherwise>
        </c:choose>

        <label for="img"><b>Select Image:</b></label>
        <form:input type="file" path="imgFile" id="img" name="img" accept="image/*" onchange="displayImage(this)" />
        <img id="showimg" class="rounded-circle" width="150" height="200" />

        <div id='removebtndiv'>

        </div> 

        <c:if test="${msg!=null}">
            <div class="alert">
                <span class="closebtnalert" 
                      onclick="this.parentElement.style.display = 'none';">&times;
                </span> 
                ${msg}
            </div>
        </c:if>

        <c:if test="${statusmsg!=null}">
            <div class="alert" style="background-color: green">
                <span class="closebtnalert"
                      onclick="this.parentElement.style.display = 'none';">&times;
                </span> 
                ${statusmsg}
            </div>
        </c:if>

        <button type="submit" name="regbtn">Register</button>
    </div>
</form:form>
    
<script>
    var imgfile = document.getElementById("img");
    var img = document.getElementById("showimg");
    if (imgfile.value == '') {
        img.src = 'https://res.cloudinary.com/petern/image/upload/v1649223665/travelmanagementproject_userimg/Empty_oqkskc.jpg';
    }
</script>
    
