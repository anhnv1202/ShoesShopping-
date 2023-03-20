<%-- 
    Document   : Topbar
    Created on : Oct 23, 2022, 3:10:08 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <div class="container-fluid">
        <div class="row bg-secondary py-2 px-xl-5">
 
            <div class="col-lg-12 text-center text-lg-right">
                <div  class="d-inline-flex align-items-center">
                    <a class="text-dark px-2" href="https://www.facebook.com/codebasic2022">
                        <i  class="fab fa-facebook-f"></i><span>acebook</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="home" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Ez</span>Shoes</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="search" method="post">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                          <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                         
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 col-6 text-right">
                <c:if test="${sessionScope.acc.isAdmin==true}">
                <a href="managerproduct" class="btn border">
                    <i class="fa fa-user text-primary"></i>
                    <span class="badge">Product</span>
                </a>
                <a href="managerorder" class="btn border">
                    <i class="fa fa-shopping-cart text-primary"></i>
                    <span class="badge">Cart</span>
                </a>
                </c:if>
                <a href="show" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge">${amount}</span>
                </a>
                 
            </div>
        </div>
    </div>
</html>
