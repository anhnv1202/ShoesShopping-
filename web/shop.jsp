<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>EShopper - Bootstrap Shop Template</title>
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


    <!-- Shop Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
           


            <!-- Shop Product Start -->
            <div class="col-lg-12 col-md-12">
                <div class="row pb-3">
                    <div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <form action="shop?cid=${cid}" method="post">
                                <div class="input-group">
                                    <input type="text" name="search" class="form-control" placeholder="Search by name" >
                                    <div class="input-group-append">
                                       <span class="input-group-text bg-transparent text-primary">
                                            <i class="fa fa-search"></i>
                                        </span>
                                    </div>
                                </div>
                            </form>
                            <div class="dropdown ml-4">
                                <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                        aria-expanded="false">
                                            Sort by
                                        </button>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                    <a class="dropdown-item" href="shop?index=${tagg}&cid=${cid}&search=${search}&sort=${1}">Latest</a>
                                    <a class="dropdown-item" href="shop?index=${tagg}&cid=${cid}&search=${search}&sort=${2}">Price Increase</a>
                                    <a class="dropdown-item" href="shop?index=${tagg}&cid=${cid}&search=${search}&sort=${3}">Price Decrease</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:forEach items="${listP}" var="o">
                    <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                        <div class="card product-item border-0 mb-4">
                            <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                <img class="img-fluid w-100" src="${o.image}" alt="">
                            </div>
                            <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                <h6 class="text-truncate mb-3">${o.name}</h6>
                                <div class="d-flex justify-content-center">
                                    <h6>${o.price} $</h6>
                                </div>
                            </div>
                                <div style="text-align: center" class="card-footer bg-light border">
                                <a  href="detail?pid=${o.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                   
                    
                    <div class="col-12 pb-1">
                        <nav aria-label="Page navigation">
                          <ul class="pagination justify-content-center mb-3">
                            <li class="page-item ${tagg == 1?"disabled":""}">
                              <a class="page-link" href="shop?index=${tagg-1}&cid=${cid}&search=${search}&sort=${sort}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                              </a>
                            </li>
                          <c:forEach begin="1" end="${endP}" var="i">
                            <li class="page-item ${tagg == i?"active":""}"><a class="page-link" href="shop?index=${i}&cid=${cid}&search=${search}&sort=${sort}">${i}</a></li>
                          </c:forEach> 
                            <li class="page-item ${tagg == endP?"disabled":""}">
                              <a class="page-link" href="shop?index=${tagg+1}&cid=${cid}&search=${search}&sort=${sort}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                              </a>
                            </li>
                          </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Shop Product End -->
        </div>
    </div>
    <!-- Shop End -->


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