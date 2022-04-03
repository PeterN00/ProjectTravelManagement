<%-- 
    Document   : index
    Created on : Mar 14, 2022, 12:56:47 PM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
                    <input class="form-control text-center" id="toursearch" placeholder="Search by titles..." name="toursearch">
                </div>
                <div>
                    <button type="submit" class="btn btn-success">Search</button>
                </div>
            </div>
        </form>
    </div>

    <br>

    <div class="row">
        <c:forEach items="${tours}" var="tour">
            <div class="col-md-4 col-sm-12">
                <div class="card">
                    <img class="card-img-top" src="${tour.img}" alt="${tour.id}" width="300" height="300">
                    <div class="card-body">
                        <h4 class="card-title">${tour.title}</h4>
                        <h4 class="card-title">${tour.price}$</h4>
                        <p class="card-text">${tour.overview}</p>
                        <a href="<c:url value = "/tours/${tour.id}" />" class="btn btn-primary">See More</a>
                    </div>
                </div>
                <br>
            </div>
        </c:forEach>
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