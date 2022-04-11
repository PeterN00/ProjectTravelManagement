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
                <br>
                <div class="row justify-content-center">
                    <p><b>-Price Range-</b></p>
                    <input type="range" min="1" max="${highestprice}" value="${highestprice/2}" class="slider" 
                           id="pricerange" name="pricerange"
                           onchange="displayMaxPriceRangeValue()"
                           style="width: 30%; margin-left: 10px; margin-right: 10px">
                    <p><b>Max: <span id="maxvalue"></span></b>$</p>
                </div>
                <div class="d-flex flex-column">
                    <div class="col-md-5">
                        <label for="fromdate" style="margin-right: 10px"><b>-From-</b></label>
                        <input type="date" id="fromdate" name="fromdate" style="width:30%">
                    </div>
                    <div class="col-md-5">
                        <label for="todate" style="margin-right: 10px"><b>-To-</b></label>
                        <input type="date" id="todate" name="todate" style="width:30%">
                    </div>
                </div>
                <div>
                    <button type="submit" class="btn btn-success">Search</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>

</script>