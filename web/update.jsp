<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Update</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div id="editEmployeeModal" >
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="update?pid=${pro.id}&index=${index}&confirm=<%=1%>" method="post">

                                <div class="modal-header">						
                                    <h4 class="modal-title">Add Product</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">					
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input name="name" type="text" class="form-control" value="${pro.name}" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Image</label>
                                        <input name="image" type="text" class="form-control" value="${pro.image}" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input name="price" type="text" class="form-control" value="${pro.price}" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title</label>
                                        <textarea name="title" class="form-control" required>${pro.title}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea name="description" class="form-control" required>${pro.description}</textarea>
                                    </div>
                                    <div class="form-group" >
                                        
                                        <label>Size</label>
                                        <select name="size" class="form-select" aria-label="Default select example" required style="display: inline-block">
                                            <c:forEach items="${listS}" var="s">
                                                <option value="${s.id}">${s.size}</option>
                                            </c:forEach>
                                            </select>
                                           
                                        <input style="width: 10%; display: inline-block;"name="quantity" type="number" min="0" class="form-control" value="" >
                                    
                                        </div>
                                        <div class="form-group">
                                            <label>Category</label>
                                            <select name="category" class="form-select" aria-label="Default select example" required>
                                                <c:forEach items="${listC}" var="c">
                                                    <option value="${c.id}" ${c.id==cid?"selected":""}>${c.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="managerproduct?index=${index}" class="btn btn-default">Cancel</a>
                                        <input type="submit" class="btn btn-success" value="Add">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <script src="js/manager.js" type="text/javascript"></script>
                    </body>
                    </html>
                    <!-- Edit Modal HTML -->

                    <!-- Delete Modal HTML -->