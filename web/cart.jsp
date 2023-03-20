<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Cart</title>
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


            <!-- Cart Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <div class="col-lg-8 table-responsive mb-5">
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                                <tr>
                                    <th>Products</th>
                                    <th>Size</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">

                            <c:forEach items="${requestScope.cart}" var="i">
                                <tr>

                                    <td class="d-flex justify-content-start"><img src="${i.product.image}" alt="" style="width: 50px;"> ${i.product.name}</td>
                                    <td class="align-middle">${i.size.size}</td>
                                    <td class="align-middle">$${i.price}</td>
                                    <td class="align-middle">

                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">

                                                <a href="process?pid=${i.product.id}&sid=${i.size.id}&num=<%=-1%>">
                                                    <button class="btn btn-sm btn-primary btn-minus">
                                                        <i class="fa fa-minus"></i>
                                                    </button>
                                                </a>
                                            </div>
                                            <input type="text" class="form-control form-control-sm bg-secondary text-center" value="${i.quantity}"><!-- comment -->
                                            <div class="input-group-btn">
                                                <a href="process?pid=${i.product.id}&sid=${i.size.id}&num=<%=1%>">
                                                    <button  class="btn btn-sm btn-primary btn-plus" ${i.quantity==store?"disabled":""}>
                                                        <i class="fa fa-plus"></i><!-- comment -->
                                                    </button>
                                                </a>
                                            </div>
                                        </div>
                                        </form>

                                    </td>
                                    <td class="align-middle">$<fmt:formatNumber pattern="##.#" value="${i.price*i.quantity}"></fmt:formatNumber></td>
                                        
                                        <td class="align-middle">
                                            <form action="process?pid=${i.product.id}&sid=${i.size.id}" method="post">
                                            <button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                                            </form>
                                        </td>

                                    </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    
                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                        </div>
                        <div class="card-body">
                            <div class="d-flex justify-content-between mb-3 pt-1">
                                <h6 class="font-weight-medium">Subtotal</h6>
                                <h6 class="font-weight-medium">$<fmt:formatNumber pattern="##.##" value="${car.getTotalMoney()}"></fmt:formatNumber></h6>
                                </div>
                                <div class="d-flex justify-content-between">
                                    <h6 class="font-weight-medium">Shipping</h6>
                                    <h6 class="font-weight-medium">$0</h6>
                                </div>
                            </div>
                            <div class="card-footer border-secondary bg-transparent">
                                <div class="d-flex justify-content-between mt-2">
                                    <h5 class="font-weight-bold">Total</h5>
                                    <h5 class="font-weight-bold">$<fmt:formatNumber pattern="##.##" value="${car.getTotalMoney()}"></fmt:formatNumber></h5>
                                </div>
                                <form action="checkout">
                                <button class="btn btn-block btn-primary my-3 py-3" ${cart.size()==0?"disabled":""}>Proceed To Checkout</button>
                                </form>
                    </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Cart End -->


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

