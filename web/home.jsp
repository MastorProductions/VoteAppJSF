<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 13/2/2018
  Time: 3:51 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
  <title>VoteApp - Login</title>
  <%@include file="/reusables/header.jspf" %>
</head>

<body>

<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
              data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">#NerdElections</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li>
          <a href="jsp/vote.jsp">Vote</a>
        </li>
        <li>
          <a href="jsp/history.jsp">My Votes</a>
        </li>
        <li>
          <a href="jsp/rankings.jsp">Rankings</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <p class="navbar-text">Already have an account?</p>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <b>Login</b>
          </a>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container-fluid -->
</nav>

<div class="container-fluid bg">

  <%@include file="/reusables/jumbotron.jspf" %>

  <div class="row">
    <div class="panel panel-login col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3" style="margin-top: 50px">
      <div class="panel-heading">

        <div class="row">
          <div class="col-xs-6">
            <a href="#" class="active" id="login-form-link">Login</a>
          </div>

          <div class="col-xs-6">
            <a href="#" id="register-form-link">Register</a>
          </div>
        </div>
        <hr>
      </div>

      <div class="panel-body">
        <div class="row">
          <div class="col-lg-12">

            <form id="login-form" action="login" method="post" style="display: block;">

              <div class="form-group">
                <input pattern="[0-9]{1,15}" required type="number" name="login-afm" id="login-afm" tabindex="1"
                       class="form-control" placeholder="AFM">
              </div>

              <div class="form-group">
                <input pattern=".{1,30}" required type="password" name="login-password"
                       id="login-password"
                       tabindex="1"
                       class="form-control"
                       placeholder="Password">
              </div>

              <div class="form-group">
                <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                       class="form-control btn btn-login"
                       value="Log In">
              </div>

            </form>

            <form id="register-form" action="register" method="post" style="display: none;">

              <div class="form-group">
                <input pattern="[0-9]{1,15}" required type="number" name="register-afm" id="register-afm" tabindex="1"
                       class="form-control"
                       placeholder="AFM">
              </div>

              <div class="form-group">
                <input pattern="[A-Za-z]{1,30}" required name="name" id="name" tabindex="2"
                       class="form-control" placeholder="Name">
              </div>

              <div class="form-group">
                <input pattern="[A-Za-z]{1,30}" required name="surname" id="surname" tabindex="2"
                       class="form-control"
                       placeholder="Surname">
              </div>

              <div class="form-group">
                <input pattern=".{1,30}" required type="password" name="register-password"
                       id="register-password" tabindex="3"
                       class="form-control"
                       placeholder="Password">
              </div>

              <div class="form-group">
                <input pattern=".{1,30}" type="password" name="confirm-password" id="confirm-password"
                       tabindex="3" class="form-control"
                       placeholder="Confirm Password">
              </div>

              <div class="form-group">
                <input type="submit" name="register-submit" id="register-submit" tabindex="4"
                       class="form-control btn btn-register" value="Register Now">
              </div>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <c:catch>
    <jsp:useBean id="error" scope="request" type="java.lang.String"/>
  </c:catch>
  <c:if test="${error ne null}">

    <div id="error" class="row">
      <div class="container col-md-2 col-md-offset-5" style="background-color: #f00; margin-top: 0;">
        <h3 class="text-center" style="color: white; margin: 10px">
          <strong>${error}</strong>
        </h3>
      </div>
    </div>

  </c:if>

</div>

<%@include file="/reusables/footer.jspf" %>

</body>

</html>