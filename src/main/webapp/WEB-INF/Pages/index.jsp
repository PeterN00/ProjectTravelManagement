<%-- 
    Document   : index
    Created on : Mar 14, 2022, 12:56:47 PM
    Author     : PHUC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            <%@include file="/resources/style.css"%>
        </style>
    </head>
    
    <body>
        
        <nav class="navbar navbar-expand-sm navbar-toggleable-md navbar-dark bg-dark">
            <a class="navbar-brand" href="/ProjectTravelManagement">Home</a>
            <div class="container-fluid">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                      <a class="nav-link" href="#">News</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/ProjectTravelManagement/tours">Tours</a>
                    </li>
                </ul>
            </div>
            <ul class="navbar-nav ml-auto">
                <button onclick="document.getElementById('login').style.display='block'" style="width:auto;">Sign In</button>
            </ul>
        </nav>
        
        <div id="login" class="modal-sm">
            <form class="modal-content animate" action="" method="post">
            <h1 class="text-center">LOGIN</h1>
            <div class="container">
              <label for="usrname"><b>Username</b></label>
              <input type="text" placeholder="Enter Username" name="usrname" required>

              <label for="psw"><b>Password</b></label>
              <input type="password" placeholder="Enter Password" name="psw" required>

              <button type="submit" name="logbtn">Login</button>
                <a class="btn btn-primary text-center d-flex justify-content-center" href="/ProjectTravelManagement/register">Register</a>
              <button type="button" onclick="document.getElementById('login').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
            </form>
        </div>
        
        <script>
            var modal = document.getElementById('login');
            window.onclick = function(event) {
              if (event.target == modal) {
                modal.style.display = "none";
              }
            }
        </script>
        
        <div class="container">
            <h1 class="text-center">TOURS</h1>
            
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
                            <img class="card-img-top" src="${tour.img}" alt="${tour.id}">
                            <div class="card-body">
                              <h4 class="card-title">${tour.title}</h4>
                              <p class="card-text">${tour.overview}</p>
                              <a href="#" class="btn btn-primary">See More</a>
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
        
    </body>
</html>
