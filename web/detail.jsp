<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>${detail.title}</title>
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

     <jsp:useBean id="d" class="model.DAO"/>
    <!-- Shop Detail Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
            <div class="col-lg-5 pb-5">
                
                    <div class="border">
                        
                            <img class="w-100 h-100" src="${detail.image}" alt="${detail.title}">
                        
                        
                    </div>
                    
             
            </div>

            <div class="col-lg-7 pb-5">
                <h3 class="font-weight-semi-bold">${detail.name}</h3>
                <div class="d-flex mb-3">
                    <div class="text-primary mr-2">
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star-half-alt"></small>
                        <small class="far fa-star"></small>
                    </div>
                    <small class="pt-1">(50 Reviews)</small>
                </div>
                <h3 class="font-weight-semi-bold mb-4">${detail.price} $</h3>
                <p class="mb-4">${detail.description}</p>
               <div class="d-flex mb-3">
                    <p class="text-dark font-weight-medium mb-0 mr-3">Sizes:</p>
                    <c:set var="id" value="${detail.id}"></c:set>
                    <form name="f" action="" method="post">
                        <c:forEach items="${requestScope.listS}" var="s">
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" ${s.id==size?"checked":""} onclick="choice('${id}')" class="custom-control-input" id="${s.id}" name="size" value="${s.id}">
                            <label class="custom-control-label" for="${s.id}">${s.size}</label>
                        </div>
                        </c:forEach>
                    </form>
                </div>
                <c:if test="${!requestScope.listS.isEmpty()}">
                   <form name="fo" action="" method="post" class="input-group-btn">
                <div class="d-flex align-items-center mb-4 pt-2">
                    <div class="input-group quantity mr-3" style="width: 130px;">
                        <div class="input-group-btn">
                            <button ${size==null?"disabled":""} onclick="minus('${detail.id}','${size}')" class="btn btn-primary btn-minus" ${num==1?"disabled":""} >
                            <i class="fa fa-minus"></i>
                            </button>
                        </div>
                       
                        <input name="num" type="text" class="form-control bg-secondary text-center" value="${num}">
                       
                        <div class="input-group-btn">
                            <button ${size==null?"disabled":""} onclick="plus('${detail.id}','${size}')" class="btn btn-primary btn-plus" ${num==numstore?"disabled":""}>
                                <i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${requestScope.listS.isEmpty()}">
                    <button class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Sold Out</button>
                </c:if>
                    <c:if test="${!requestScope.listS.isEmpty()}">
                        <button ${size==null?"disabled":""} onclick="add('${detail.id}','${size}')" class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</button>
                      </c:if>
                    
                </div>
                       <div>
                       <c:if test="${size!=null}">
                           <p style="color:red;font-style: italic">${numstore} products left...<p>
                                  </c:if>   
                                </div>
                       </form>
                <div class="d-flex pt-2">
                    <p class="text-dark font-weight-medium mb-0 mr-2">Share on:</p>
                    <div class="d-inline-flex">
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-pinterest"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row px-xl-5">
            <div class="col">
                <div class="nav nav-tabs justify-content-center border-secondary mb-4">
                    <a class="nav-item nav-link active" data-toggle="tab" href="#tab-pane-1">Description</a>
                </div>
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="tab-pane-1">
                        <h4 class="mb-3">Product Description</h4>
                        ${detail.description}
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Detail End -->


    <!-- Products Start -->
    <div class="container-fluid py-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">You May Also Like</span></h2>
        </div>
        <div class="row px-xl-5">
            <div class="col">
                <div class="owl-carousel related-carousel">
                    <c:forEach items="${listP}" var="p">
                    <div class="card product-item border-0">
                        <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                            <img class="img-fluid w-100" src="${p.image}" alt="">
                        </div>
                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                            <h6 class="text-truncate mb-3">${p.name}</h6>
                            <div class="d-flex justify-content-center">
                                <h6>${p.price}</h6>
                            </div>
                        </div>
                            <div style="text-align: center;"class="card-footer bg-light border">
                            <a href="detail?pid=${p.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                          
                        </div>
                    </div>
                    </c:forEach>
             </div>
            </div>
        </div>
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
    <script type="text/javascript">
  function choice(id) {
    var m= document.f.size.value;
    document.f.action="detail?pid="+id+"&sid="+m;
    document.f.submit();
  }
  function add(id,size) {
    var m= document.fo.num.value;
    document.fo.action="buy?pid="+id+"&sid="+size+"&num="+m;
    document.fo.submit();
  }
  function plus(id,size){
       var m= document.fo.num.value;
      document.fo.action="detail?pid="+id+"&sid="+size+"&num="+m+"&numm="+1;
      document.fo.submit();
  }
  function minus(id,size){
       var m= document.fo.num.value;
      document.fo.action="detail?pid="+id+"&sid="+size+"&num="+m+"&numm="+-1;
      document.fo.submit();
  }
  
    </script>
</body>

</html>