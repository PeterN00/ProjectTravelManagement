<%-- 
    Document   : tours
    Created on : Apr 4, 2022, 7:53:14 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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

    <form>
        <div class="form-group">
            <div>
                <input class="form-control text-center" id="toursearch" placeholder="Search by titles..." name="search">
            </div>
            <br>
            <div class="row justify-content-center">
                <p><b>-Price Range-</b></p>
                <input type="range" min="1" max="${highestprice}" value="${highestprice/2}" class="slider" 
                       id="pricerange" name="pricerange"
                       onchange="displayMaxPriceRangeValue()"
                       style="width: 50%; margin-left: 10px; margin-right: 10px">
                <p><b>Max: <span id="maxvalue"></span></b>$</p>
            </div>
            <div class="row justify-content-center align-items-center text-center">
                <div class="col-md-6">
                    <label for="fromdate" style="margin-right: 10px"><b>-From-</b></label>
                    <input type="date" id="fromdate" name="fromdate">
                </div>
                <div class="col-md-6">
                    <label for="todate" style="margin-right: 10px"><b>-To-</b></label>
                    <input type="date" id="todate" name="todate">
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-success">Search</button>
            </div>
        </div>
    </form>

    <div class="w3-margin w3-container w3-padding">
        <div class="grid-container">
            <c:forEach items="${tours}" var="tour">
                <a href="<c:url value = "/tours/${tour.id}" />">
                    <div class="w3-container w3-border w3-round-large" style="padding:5px;background: #f9f9f9">
                        <img src="${tour.img}" width="500px" height="300px" alt="${tour.id}" class="w3-left w3-round-large w3-margin-right">

                        <p style="font-size: 1em; padding-top:5px;" >
                            <b style="font-size: 1em;">${tour.title}</b><br>
                            ${tour.price}$<br>
                            <fmt:formatDate type = "both" 
                                            dateStyle = "long" timeStyle = "medium" 
                                            value = "${tour.departureTime}" /><br>
                            ${tour.overview}
                        </p>
                    </div>
                </a>
                <br>
            </c:forEach>
        </div>
    </div>
</div>

<div class="d-flex justify-content-center">
    <c:forEach begin="1" end="${Math.ceil(tourcount/6)}" var="pg">
        <c:url value="/tours" var="pageClick">
            <c:param name="page" value="${pg}" />
        </c:url>
        <ul class="pagination justify-content-center" style="margin:20px 0">
            <li class="page-item"><a class="page-link" href="${pageClick}">${pg}</a></li>
        </ul>
    </c:forEach>
</div>