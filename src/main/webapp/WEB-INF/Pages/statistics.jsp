<%-- 
    Document   : statistics
    Created on : Apr 8, 2022, 3:13:03 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container justify-content-center text-center" style="margin-bottom: 20px">
    <h2 class="text-center"><b>STATISTICS</b></h2>
    <a class="btn btn-primary" href="<c:url value="/statistics/bookingcount" />">
        Booking Count Statistic
    </a>
    <a class="btn btn-primary" href="<c:url value="/statistics/bookingrevenue" />">
        Booking Revenue Statistic
    </a>
</div>