<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Home</title>
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


            <!-- Featured Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5 pb-3">
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                            <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                            <h5 class="font-weight-semi-bold m-0">Quality Product</h5>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                            <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                            <h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                            <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                            <h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                            <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                            <h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Featured End -->

        <jsp:useBean id="d" class="model.DAO"/>
            <!-- Categories Start -->
            <div class="container-fluid pt-5">
                <div  class="row px-xl-5 pb-3">
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(1)} Product</p>
                            <a href="shop?cid=${1}" class="cat-img position-relative overflow-hidden mb-3">
                                <img class="img-fluid" src="img/Adidas_Logo.svg.png" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Adidas</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(2)} Products</p>
                            <a style="text-align: center" href="shop?cid=${2}" class="cat-img position-relative overflow-hidden mb-3">
                                <img class="img-fluid" src="img/Logo_nike.jpg" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Nike</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(3)} Products</p>
                            <a style="text-align: center" href="shop?cid=${3}" class="cat-img position-relative overflow-hidden mb-3">
                                <img class="img-fluid" src="img/vanslogo.jpg" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Vans</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(4)} Products</p>
                            <a style="text-align: center" href="shop?cid=${4}" class="cat-img position-relative overflow-hidden mb-3">
                                <img  class="img-fluid" src="img/conversee.jpg" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Converse</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(5)} Products</p>
                            <a style="text-align: center" href="shop?cid=${5}" class="cat-img position-relative overflow-hidden mb-3">
                                <img  class="img-fluid" src="img/Fila.png" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Fila</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(6)} Products</p>
                            <a style="text-align: center" href="shop?cid=${6}" class="cat-img position-relative overflow-hidden mb-3">
                                <img  class="img-fluid" style="padding-bottom:73px" src="img/reebok.jpg" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Reebok</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(7)} Products</p>
                            <a style="text-align: center" href="shop?cid=${7}" class="cat-img position-relative overflow-hidden mb-3">
                                <img  style="padding-bottom: 50px" class="img-fluid" src="img/puma.png" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Puma</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(8)} Products</p>
                            <a style="text-align: center" href="shop?cid=${8}" class="cat-img position-relative overflow-hidden mb-3">
                                <img  class="img-fluid" src="img/domba.png" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Domba</h5>
                        </div>
                    </div>
                    <div  class="col-lg-4 col-md-6 pb-1">
                        <div style="height:370px;overflow:hidden;object-fit: cover" class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                            <p class="text-right">${d.countProductById(9)} Products</p>
                            <a style="text-align: center" href="shop?cid=${9}" class="cat-img position-relative overflow-hidden mb-3">
                                <img  class="img-fluid" src="img/asic.png" alt="">
                            </a>
                            <h5 class="font-weight-semi-bold m-0">Asic</h5>
                        </div>
                    </div
                </div>
            </div>
            <!-- Categories End -->


            <!-- Offer Start -->
            <div class="container-fluid offer pt-5">
                <div class="row px-xl-5">
                    <div class="col-md-6 pb-4">
                        <div class="position-relative bg-secondary text-center text-md-right text-white mb-2 py-5 px-5">
                            <img style="height:370px;padding-bottom: 22px" src="img/adidas_a_1.png" alt="">
                            <div class="position-relative" style="z-index: 1;">
                                <h5 class="text-uppercase text-primary mb-3">Adidas shoe</h5>
                                <h1 class="mb-4 font-weight-semi-bold">New Collection</h1>
                                <a href="shop?cid=1" class="btn btn-outline-primary py-md-2 px-md-3">Shop Now</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 pb-4">
                        <div class="position-relative bg-secondary text-center text-md-left text-white mb-2 py-5 px-5">
                            <img src="img/nikebanner.png" alt="">
                            <div class="position-relative" style="z-index: 1;">
                                <h5 class="text-uppercase text-primary mb-3">Nike 2022</h5>
                                <h1 class="mb-4 font-weight-semi-bold">Winter Collection</h1>
                                <a href="shop?cid=2" class="btn btn-outline-primary py-md-2 px-md-3">Shop Now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Offer End -->


            <!-- Products Start -->
            <div class="container-fluid pt-5">
                <div class="text-center mb-4">
                    <h2 class="section-title px-5"><span class="px-2">Trendy Products</span></h2>
                </div>
                
                <div style="margin: 0 0 17px 27px; max-width:95%" class="row ">
                    <c:set var="count" value="0"/>
                    <c:forEach items="${listP}" var="o">
                       <c:set var="count" value="${count+1}"/>
                       <c:if test="${count<=24}">
                            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                                <div style="" class="card product-item border-0 mb-4">
                                    <div style="object-fit: cover" class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">

                                        <img style="height:400px;object-fit: cover" class="img-fluid w-100" src="${o.image}" alt="">

                                    </div>

                                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                        <h6 class="text-muted ml-2">${o.name}</h6>
                                     <h6 class="text-truncate mb-3">${o.price}</h6>
                                        
                                        <div class="d-flex justify-content-center ">
                                           
                                           
                                        </div>
                                    </div>
                                    <div style="text-align: center;" class="card-footer bg-light border">
                                        <a href="detail?pid=${o.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                    </div>
                                </div>
                            </div>
                                    </c:if>
                        </c:forEach>
                </div>
                </div>
                    <div style="text-align: center">
            <a style="color: black; background-color: #bd726b;width: 100%;padding: 10px 10px 10px 10px" href="shop">See More</a>
                    </div>
            <!-- Products End -->




                
            </div>
            <!-- Products End -->





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