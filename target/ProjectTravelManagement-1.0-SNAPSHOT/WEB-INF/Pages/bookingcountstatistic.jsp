<%-- 
    Document   : bookingcountstatistic
    Created on : Apr 8, 2022, 3:02:35 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center"><b>Booking Count Statistic</b></h2>
<div class="row justify-content-center align-items-center">
    <div class="col-md-4">
        <table class="table">
            <tr>
                <th>Tour Id</th>
                <th>Tour Title</th>
                <th>Booking Count</th>
            </tr>
            <c:forEach items="${statistic}" var="statistic">
                <tr>
                    <td>${statistic[0]}</td>
                    <td>${statistic[1]}</td>
                    <td>${statistic[2]}</td>
                </tr>
            </c:forEach>
        </table>

        <form id = "limitform">
            <select onchange="limitSubmit()" id="limit" name = "limit">
                <option value ="" selected>Choose limit</option>
                <option value ="3">Top 3</option>
                <option value ="5">Top 5</option>
                <option value ="10">Top 10</option>
            </select>
        </form>

        <form>
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

    <div class="col-md-7">
        <canvas id="myChart" width="500" height="500"></canvas>
    </div>
</div>

<script>
    const labels = [];
    const data = [];
    <c:forEach items="${statistic}" var="statistic">
    labels.push('${statistic[1]}');
    data.push('${statistic[2]}');
    </c:forEach>

    window.onload = () => {
        const ctx = document.getElementById('myChart').getContext('2d');
        drawChart(ctx, labels, data, 'bar', 'Booking Count');
    };
</script>

<script>
    function limitSubmit() {
        document.getElementById("limitform").submit();
    }
</script>