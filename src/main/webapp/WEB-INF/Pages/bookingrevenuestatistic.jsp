<%-- 
    Document   : bookingrevenuestatistic
    Created on : Apr 8, 2022, 7:28:36 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center"><b>Booking Revenue Statistic</b></h2>
<div class="row justify-content-center align-items-center">
    <div class="col-md-4">
        <table class="table">
            <tr>
                <th>Tour Id</th>
                <th>Tour Title</th>
                <th>Month of Year</th>
                <th>Total Revenue</th>
            </tr>
            <c:forEach items="${statistic}" var="statistic">
                <tr>
                    <td>${statistic[0]}</td>
                    <td>${statistic[1]}</td>
                    <td>${statistic[2]}, ${statistic[3]}</td>
                    <td>
                        <fmt:formatNumber 
                        value="${statistic[4]}" 
                        maxFractionDigits="2"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <form id = "limitform">
            <select onchange="limitSubmit()" id="limit" name = "limit">
                <option value ="" selected>Choose limit</option>
                <option value ="5">Top 5</option>
                <option value ="10">Top 10</option>
            </select>
        </form>
        
        <form>
            <div class="form-group">
                <div class="d-flex flex-column">
                    <input class="form-control text-center" id="toursearch" placeholder="Search by titles..." name="search">
                    <label for="fromdate"><b>From:</b></label>
                    <input type="date" id="fromdate" name="fromdate">
                    <label for="todate"><b>To:</b></label>
                    <input type="date" id="todate" name="todate">
                </div>
                <div>
                    <button type="submit" class="btn btn-success">Search</button>
                </div>
            </div>
        </form>
    </div>
    
    <div class="col-md-7">
        <canvas id="myChart" width="700" height="700"></canvas>
    </div>
</div>

<script>
    const labels = [];
    const data = [];
    <c:forEach items="${statistic}" var="statistic">
        labels.push('${statistic[1]} (${statistic[2]},${statistic[3]})');
        data.push('${statistic[4]}');
    </c:forEach>

    window.onload = () => {
        const ctx = document.getElementById('myChart').getContext('2d');
        drawChart(ctx, labels, data, 'pie', 'Revenue');
    };
</script>

<script>
    function limitSubmit(){
        document.getElementById("limitform").submit();
    }
</script>