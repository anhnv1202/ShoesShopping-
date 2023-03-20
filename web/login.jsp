<%-- 
    Document   : login
    Created on : Oct 23, 2022, 2:01:01 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleform.css">
    </head>
    <body id="particles-js"></body>
    <div class="animated bounceInDown">
        <div class="container">
            <span class="error animated tada" id="msg"></span>
            <form name="form1" class="box" action="login " method="post"">
                <h4>Ez<span>Shoes</span></h4>
                <h5>Sign in to your account.</h5>
                <c:set var="cookie" value="${pageContext.request.cookies}"></c:set>
                <div style="margin-top: -50px; color: red">${mess}</div><!-- comment -->
                <input type="text" name="username" placeholder="Username"  value="${cookie.cuser.value}">
                <i class="typcn typcn-eye" id="eye"></i>
                <input type="password" name="password" placeholder="Passsword" id="pwd"  value="${cookie.cpass.value}">
                    <input type="checkbox" name="rem" value="ON" ${cookie.crem!=null?"checked":""} />&nbsp; Remember me
                
              
                <input type="submit" value="Sign in" class="btn1">
            </form>
            <a href="signup.jsp" class="dnthave">Don’t have an account? Sign up</a>
        </div> 
        <div class="footer">
            <span>Made with <i class="fa fa-heart pulse"></i> <a href="https://www.google.de/maps/place/Augsburger+Puppenkiste/@48.360357,10.903245,17z/data=!3m1!4b1!4m2!3m1!1s0x479e98006610a511:0x73ac6b9f80c4048f"><a href="https://codepen.io/lordgamer2354">EzShoes</a></span>
        </div>
    </div>
</html>
