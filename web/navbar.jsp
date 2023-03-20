<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <c:forEach items="${listC}" var="c">
                        <a href="shop?cid=${c.id}" class="nav-item nav-link active">${c.name}</a>
                        </c:forEach>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="home" class="nav-item nav-link ${current=="home"? "active":""}">Home</a>
                            <a href="shop" class="nav-item nav-link ${current=="shop"? "active":""}">Shop</a>
                            <a href="detail?pid=${detail.id}" class="nav-item nav-link ${current=="detail"? "active":""}">New Arrival</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle ${current=="pages"? "active":""}" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="show" class="dropdown-item">Shopping Cart</a>
                                    <a href="checkout" class="dropdown-item">Checkout</a>
                                </div>
                            </div>
                        </div>
                        <div class="navbar-nav ml-auto py-0">
                            <c:if test="${sessionScope.acc !=null}">
                                <a href="#" class="nav-item nav-link">Hello ${sessionScope.acc.user}</a>
                            <a href="logout" class="nav-item nav-link">Logout</a>
                            </c:if>
                             <c:if test="${sessionScope.acc ==null}">
                            <a href="login.jsp" class="nav-item nav-link">Login</a>
                            <a href="signup.jsp" class="nav-item nav-link">Register</a>
                             </c:if>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->
    </body>

