<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Check out</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <jsp:include page="topbar.jsp"></jsp:include>
    <!-- Topbar End -->


    <!-- Navbar Start -->
      <jsp:include page="navbar.jsp"></jsp:include>
    <!-- Navbar End -->


    <!-- Page Header Start -->
     <jsp:include page="pageHeader.jsp"></jsp:include>
    <!-- Page Header End -->


    <!-- Checkout Start -->
    <div class="container-fluid pt-5">
        <form action="checkout" method="post">
        <div class="row px-xl-5">
            <div class="col-lg-8">
                <div class="mb-4">
                    <h4 class="font-weight-semi-bold mb-4">Billing Address</h4>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <label>Name</label>
                            <input class="form-control" name="name" type="text" placeholder="Your name" value="${cus.name}">
                        </div>
                       
                        <div class="col-md-12 form-group">
                            <label>Mobile No</label>
                            <input class="form-control" type="text" name="phone" placeholder="your phone's number" value="${cus.phoneNumber}">
                        </div>
                        <div class="col-md-12 form-group">
                            <label>Address</label>
                            <input class="form-control" name="address" type="text" placeholder="your address" value="${cus.address}">
                        </div>
             
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Order Total</h4>
                    </div>
                    <div class="card-body">
                        
                        <h5 class="font-weight-medium mb-3">Products</h5>
                        <c:forEach items="${listCart}" var="c">
                        <div class="d-flex justify-content-between">
                            <p>${c.product.name}</p>
                            <p>${c.quantity}</p>
                            <p>$<fmt:formatNumber pattern="##.##" value="${c.price*c.quantity}"></fmt:formatNumber></p>
                        </div>
                        </c:forEach>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Total</h5>
                            <h5 class="font-weight-bold">$<fmt:formatNumber pattern="##.##" value="${cart.getTotalMoney()}"></fmt:formatNumber></h5>
                        </div>
                    </div>
                </div>
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Payment</h4>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input" name="payment" id="directcheck" required checked>
                                <label class="custom-control-label" for="directcheck">Direct Check</label>
                            </div>
                        </div>

                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <button class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Place Order</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    </div>
    <!-- Checkout End -->


    <!-- Footer Start -->
   <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>