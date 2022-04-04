<%-- 
    Document   : index
    Created on : Mar 14, 2022, 12:56:47 PM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <br>

    <c:if test="${msg!=null}">
        <div class="alert" style="background-color: green">
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${msg}
        </div>
    </c:if>

    <div>
        <c:url value="/tours" var="tourSearch" />
        <form action="${tourSearch}">
            <div class="form-group">
                <div>
                    <input class="form-control text-center" id="toursearch" placeholder="Search by titles..." name="search">
                </div>
                <div>
                    <button type="submit" class="btn btn-success">Search</button>
                </div>
            </div>
        </form>
    </div>
</div>