<%-- 
    Document   : newsdetails
    Created on : Apr 5, 2022, 7:04:50 AM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<div class="container">     
    <h4><b>${news.title}</b></h4>
    <p>
        Last Modified: 
        <fmt:formatDate type = "both" 
                        dateStyle = "long" timeStyle = "medium" 
                        value = "${news.date}" />
    </p>
    <p>${news.description}</p>

    <c:if test="${pageContext.request.userPrincipal.name != null
                  && pageContext.request.userPrincipal.authorities != '[Customer]'}">
        <c:url value = "/news/${news.id}/edit" var="editAction" />
        <a href="${editAction}">Edit</a>

        <c:if test="${pageContext.request.userPrincipal.authorities == '[Admin]'}">
            <c:url value = "/news/${news.id}/delete" var="deleteAction" />
            <form:form action ="${deleteAction}">
                <button id="delsubmit" type="submit" name="delbtn">Delete</button>
            </form:form>
        </c:if>
    </c:if>

</div>
    
<div class="container">
    <h2><b>Comments</b></h2>
    <c:url value="/news/${news.id}/comment" var = "comment" />
    <form:form action="${comment}" method="post" modelAttribute="comment">
        <form:textarea placeholder="Comment Here..." path="comment" name="comment" style="width: 100%; height: 25%" />
        <form:errors path="comment" cssClass="text-danger" />
        
        <button id="submitbtn" type="submit" name="submitbtn">Submit</button>
    </form:form>
    
    <br>
    
    <c:forEach items="${comments}" var = "comments">
        <div class="row">
            <div class="col-md-7">
                <p><b>${comments[1]}</b></p>
                <p>${comments[2]}</p>
            </div>
            <div class="col-md-3">
                <p>
                    At: 
                    <fmt:formatDate type = "both" 
                        dateStyle = "long" timeStyle = "medium" 
                        value = "${comments[3]}" />
                </p>
            </div>
        </div>
    </c:forEach>
</div>