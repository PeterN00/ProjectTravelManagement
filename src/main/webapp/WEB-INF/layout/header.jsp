<%-- 
    Document   : header
    Created on : Mar 24, 2022, 3:31:40 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-toggleable-md navbar-dark bg-dark">
    <a class="navbar-brand" href="<c:url value="/" />">GlobTourism</a>
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/news" />">News</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/tours" />">Tours</a>
            </li>
        </ul>
    </div>

    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <button onclick="document.getElementById('login').style.display = 'block'" 
                style="width: 100px">
            Sign In
        </button>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal.authorities == '[Admin]'}">
        <a class="nav-link"
           style="color: green; text-align: center"
           href="<c:url value="/statistics" />">
            Statistics
        </a>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <c:if test="${pageContext.request.userPrincipal.authorities == '[Admin]'
                      || pageContext.request.userPrincipal.authorities == '[Employee]'}">
              <a class="nav-link"
                 style="color: green; text-align: center"
                 href="<c:url value="/tours/add" />">
                  Add Tour
              </a>
              <a class="nav-link"
                 style="color: green; text-align: center"
                 href="<c:url value="/news/add" />">
                  Add News
              </a>
              <a class="nav-link"
                 style="color: green; text-align: center"
                 href="<c:url value="/users/register" />">
                  Register User
              </a>
        </c:if>
        <a class="nav-link row"
           style="color: red; text-align: center"
           href="<c:url value="/users/${pageContext.request.userPrincipal.name}" />">
            <img src="${pageContext.session.getAttribute("currentUser").img}" 
                 class="rounded-circle" width="40" style="float:left" />
            ${pageContext.request.userPrincipal.name}
            ${pageContext.request.userPrincipal.authorities}
        </a>
        <a class="nav-link button"
           style="width: 140px"
           href="<c:url value="/logout" />">
            Sign Out
        </a>
    </c:if>
</nav>

<c:url value="/login" var="login" />
<div id="login" class="modal-sm">
    <form class="modal-content animate" action="${login}" method="post">
        <h1 class="text-center">LOGIN</h1>
        <div class="container">
            <label for="username"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" required>

            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" required>

            <button type="submit" name="logbtn">Login</button>
            <a class="btn btn-primary text-center d-flex justify-content-center" 
               style="font-weight: bold"
               href="<c:url value="/users/register" />">Register</a>
            <button type="button" onclick="document.getElementById('login').style.display = 'none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>

<script>
    var modal = document.getElementById('login');
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>