<%-- 
    Document   : header
    Created on : Mar 24, 2022, 3:31:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <button onclick="document.getElementById('login').style.display = 'block'" 
                style="width: 95px">Sign In</button>
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