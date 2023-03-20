<%-- 
    Document   : signup
    Created on : Oct 24, 2022, 10:39:57 PM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi" class="h-100">
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Sign up</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css" type="text/css">
    <!-- Font awesome -->
    <link rel="stylesheet" href="../vendor/font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Custom css - Các file css do chúng ta tự viết -->
   <link rel="stylesheet" href="css/styleformsignup.css">
</head>

  <body>
    <!-- Body of Form starts -->
  	<div class="container">
            <h2 style="color: white; padding-bottom: 15px; margin-top: -20px; text-align: center; font-size: 40px">Sign <span style=" color:#e4606d;font-size: 40px">up</span></h2>
      <form action="sign" method="post" autocomplete="on">
          <div style="color: red">${mess}</div>

    		<div class="box">
          <label for="Name" class="fl fontLabel"> Name: </label>
    			<div class="new iconBox">
            <i class="fa fa-user" aria-hidden="true"></i>
          </div>
    			<div class="fr">
    					<input type="text" name="name" placeholder="Your Name"
              class="textBox" autofocus="on" required>
    			</div>
    			<div class="clr"></div>
    		</div>


       
    		<div class="box">
          <label for="Address" class="fl fontLabel"> Address: </label>
    			<div class="fl iconBox">
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </div>
    			<div class="fr">
    					<input type="text" required name="address"
              placeholder="Your Address" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    			
    		<div class="box">
          <label for="phone" class="fl fontLabel"> Phone No.: </label>
    			<div class="fl iconBox"><i class="fa fa-phone-square" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="text" required name="no" maxlength="10" placeholder="Phone No." class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		
    		<div class="box">
          <label for="user" class="fl fontLabel"> Username </label>
    			<div class="fl iconBox"><i class="fa fa-envelope" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="user" required name="username" placeholder="Username" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--UserName----->


    		<!---Password------>
    		<div class="box">
          <label for="password" class="fl fontLabel"> Password </label>
    			<div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="Password" required name="password" placeholder="Password" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Password---->
                
                <!---rePassword------>
    		<div class="box">
          <label for="repassword" class="fl fontLabel"> RePassword </label>
    			<div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="Password" required name="repassword" placeholder="RePassword" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Password---->



    		<!--Terms and Conditions------>
    		<div class="box terms">
    				<input type="checkbox" name="Terms" required> &nbsp; I accept the terms and conditions
    		</div>
    		<!--Terms and Conditions------>



    		<!---Submit Button------>
    		<div class="box" style="background:#D2a3a9">
    				<input type="Submit" name="Submit" class="submit" value="SUBMIT">
    		</div>
    		<!---Submit Button----->
      </form>
  </div>
  <!--Body of Form ends--->
  </body>
</html>
