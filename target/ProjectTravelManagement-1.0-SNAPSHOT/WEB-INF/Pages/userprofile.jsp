<%-- 
    Document   : userprofile
    Created on : Apr 5, 2022, 8:11:00 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container align-items-center d-flex flex-column" style="padding: 20px">  
    <c:if test="${msg != null}">
        <div class="alert" style="background-color: green">
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${msg}
        </div>
    </c:if>

    <h1 class="text-center">PROFILE</h1>
    <img src="${user.img}"  class="rounded-circle" width="150" height="200" alt = "avatar" style="float:left; margin-right: 10px">
    <h4><b>${user.username}</b></h4>
    <p>Full name: ${user.fullName}</p>

    <c:url value = "/users/${user.username}/edit" var="editAction" />
    <a href="${editAction}" class="btn btn-primary">Edit</a>
</div>

<div class="container">
    <h2><b>Booking History</b></h2>
    <c:forEach items='${bookinglist}' var='bl'>
        <div class="row">
            <div class="col-md-7">
                <p><b>${bl[0]}</b></p>
                <p>${bl[1]} adults
                    <span>
                        <c:if test="${bl[2]>0}" >
                            , ${bl[2]} children
                        </c:if> 
                    </span>
                </p>
                <p>Total: <fmt:formatNumber value = "${bl[3]}" maxFractionDigits = "2" />$</p>
            </div>
            <div class="col-md-3">
                <p>
                    Book Date:<br>
                    <fmt:formatDate type = "both" 
                                    dateStyle = "long" timeStyle = "medium" 
                                    value = "${bl[4]}" />
                </p>
            </div>
        </div>
    </c:forEach>
</div>

