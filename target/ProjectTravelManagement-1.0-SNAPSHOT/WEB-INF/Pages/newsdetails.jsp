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
        <a href="${editAction}" class="btn btn-primary">Edit</a>

        <c:if test="${pageContext.request.userPrincipal.authorities == '[Admin]'}">
            <button id="delbtn" type="button" name="delbtn" 
                    onclick="document.getElementById('delModal').style.display = 'block'"
                    style="width:auto">
                Delete
            </button>
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

<div id="delModal" class="modal">
    <div class="modal-content animate" style="width:30%">
        <div class="modal-header">
            <h2>Confirmation</h2>
        </div>
        <div class="modal-body">
            <p>Are you sure you want to delete this news?</p>
        </div>
        <div class="modal-footer">
            <a href="<c:url value = "/news/${news.id}/delete" />" class="btn btn-primary" id="delConfirm">Yes</a>
            <button type="button" onclick="modal.style.display = 'none'" style="width:auto">No</button>
        </div>
    </div>
</div>

<script>
    var modal = document.getElementById('delModal');
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };
</script>