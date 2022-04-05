<%-- 
    Document   : news
    Created on : Apr 4, 2022, 8:00:47 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <input class="form-control text-center" id="newssearch" placeholder="Search by titles..." name="search">
            </div>
            <div>
                <button type="submit" class="btn btn-success">Search</button>
            </div>
        </div>
    </form>

    <c:forEach items="${news}" var="news">
        <div class="container">
            <h4><b>${news.title}</b></h4>
            <p>${news.description}</p>
            <p>
                Last Modified: 
                <fmt:formatDate type = "both" 
                                dateStyle = "long" timeStyle = "medium" 
                                value = "${news.date}" />
            </p>
            <a href="<c:url value = "/news/${news.id}" />" class="btn btn-primary">Read</a>
        </div>
    </c:forEach>
</div>

<div class="d-flex justify-content-center">
    <c:forEach begin="1" end="${Math.ceil(newscount/6)}" var="pg">
        <c:url value="/news" var="pageClick">
            <c:param name="page" value="${pg}" />
        </c:url>
        <ul class="pagination justify-content-center" style="margin:20px 0">
            <li class="page-item"><a class="page-link" href="${pageClick}">${pg}</a></li>
        </ul>
    </c:forEach>
</div>
