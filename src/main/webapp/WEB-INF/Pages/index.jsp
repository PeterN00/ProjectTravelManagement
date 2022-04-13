<%-- 
    Document   : index
    Created on : Mar 14, 2022, 12:56:47 PM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div
    style="background-image: url('<c:url value="/resources/images/indexBackground.png" />');
    background-repeat: no-repeat; padding-top: 400px; background-position: center center; position: relative">
    <br>
    <img class="indexicon" src="<c:url value="/resources/images/GTIcon.png" />">
    <c:if test="${msg!=null}">
        <div class="alert" style="background-color: green">
            <span class="closebtnalert" 
                  onclick="this.parentElement.style.display = 'none';">&times;
            </span> 
            ${msg}
        </div>
    </c:if>  

    <div class="container position-relative" 
         >
        <div class="row justify-content-center">
            <div class="text-center text-white" style="font-size: 20px">
                <h1 class="mb-5"><b>Welcome To GlobTourism</b></h1>
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
                                   style="margin-left: 10px; margin-right: 10px">
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
                            <button type="submit" class="btn btn-success" style="margin-top: 10px">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>       
    </div>
</div>

<script>

</script>