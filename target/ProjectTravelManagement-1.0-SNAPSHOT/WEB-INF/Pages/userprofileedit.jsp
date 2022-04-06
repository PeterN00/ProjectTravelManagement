<%-- 
    Document   : userprofileedit
    Created on : Apr 6, 2022, 11:56:13 AM
    Author     : Admin
--%>

<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/users/${pageContext.request.userPrincipal.name}/edit" var="editprofile" />
<form:form action="${editprofile}" method="post" modelAttribute="user"
           enctype="multipart/form-data">
    
    <h1 class="text-center">PROFILE EDIT</h1>

    <c:if test="${msg!=null}">
        <div class="alert" style="background-color: green">
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${msg}
        </div>
    </c:if>

    <c:if test="${errmsg!=null}">
        <div class="alert" >
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${errmsg}
        </div>
    </c:if>
    
    <div class="container">
        <label for="fullname"><b>Full Name:</b></label>
        <form:input placeholder="Enter Full Name" path="fullName" name="fullname" />
        <form:errors path="fullName" cssClass="text-danger" />

        <label for="psw"><b>New Password:</b></label>
        <form:password placeholder="Enter New Password" path="password" name="psw" />
        <form:errors path="password" cssClass="text-danger" />

        <label for="repsw"><b>Retype New Password:</b></label>
        <form:password placeholder="Retype New Password" path="retypePassword" name="repsw" />
        
        <label for="img"><b>Select Image:</b></label>
        <form:input type="file" path="imgFile" id="img" name="img" accept="image/*" onchange="displayImage(this)" />
        <img id="showimg" src="${user.img}" class="rounded-circle" width="150" height="200" />
        
        <form:input type="hidden" path="role" value="${user.role}" />
        
        <div id='removebtndiv'>

        </div> 

        <button id="submitbtn" type="submit" name="submitbtn">Save</button>
    </div>
</form:form>