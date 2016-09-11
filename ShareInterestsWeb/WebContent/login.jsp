<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>SignIn - WSnippets</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<script   src="https://code.jquery.com/jquery-3.1.0.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.si_header {
	background-color: #777 !important;
	color: #FFF !important;
	padding-top:58px !important;
	padding-bottom:8px !important;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	function goRequestLogin(){
		
		$.ajax({
			url: "requestLogin",
		    data: {
		    	email:$("#login-username").val(),
		    	password:$("#login-password").val()
		    },
		  success: function( result ) {
			  //alert(result);
			  if(result == 'success'){
				  //alert('login success!');
				  window.location = '${callbackUrl}';
			  }else if(result == 'notfound'){
				  alert('user not found');
			  }else {
				  alert(result);
			  }
			  //document.location = 'loginSuccess';				
		  }
		});
	}
	
	function goRequestSignup(){
		
		$.ajax({
			url: "requestSignup",
		    data: {
		    	email:$("#signup-email").val(),
		    	name:$("#signup-name").val(),
		    	password:$("#signup-password").val()
		    },
		  success: function( result ) {
			  //alert(result);
			  if(result == 'success'){
				  //alert('login success!');
				  document.location = '/ShareInterestsWeb/login';
			  }else if(result == 'notfound'){
				  //alert('user not found');
			  }else {
				  //alert(result);
			  }
			  //document.location = 'loginSuccess';				
		  }
		});
	}
	
	$("#btn-login").on("click", function(event){
		goRequestLogin();
	});
	
		
	$("#btn-signup").on("click", function(event){
		goRequestSignup();
	});
	
	$("#btn-fbsignup").on("click", function(event){
		checkLoginState();
	});

	
	if('${result}' == 'notfound'){
		alert('User Not found! Please sign up first.');	
	}

	$('#login-password').bind("enterKey",function(e){
		   //do stuff here
		goRequestLogin();
	});
	
	$('#login-password').keyup(function(e){
	    if(e.keyCode == 13)
	    {
	        $(this).trigger("enterKey");
	    }
	});
	
	$('#signup-password').bind("enterKey",function(e){
		   //do stuff here
		goRequestSignup();
	});
	
	$('#signup-password').keyup(function(e){
	    if(e.keyCode == 13)
	    {
	        $(this).trigger("enterKey");
	    }
	});
});
</script>



<!--   //http://graph.facebook.com/10208778724299557/picture?type=large -->
   </head>
  <body>
  <jsp:include page="header.jsp"></jsp:include>
  <div class="jumbotron text-center si_header">
	  <h1>Sign in</h1>
	  <p>Resize this responsive page to see the effect!</p> 
  </div>
    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form id="loginform" class="form-horizontal" role="form">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username or email">                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                                    </div>
                                    

                                
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                      </div>
                                    </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <a id="btn-login" href="#" class="btn btn-success">Login  </a>
                                      <a id="btn-fblogin" href="/ShareInterestsWeb//social/facebook/signin" class="btn btn-primary">Login with Facebook</a>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Don't have an account! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     



                        </div>                     
                    </div>  
        </div>
        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form">
                                
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>
                                    
                                
                                  
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input id="signup-email" type="text" class="form-control" name="email" placeholder="Email Address">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="name" class="col-md-3 control-label">Name</label>
                                    <div class="col-md-9">
                                        <input id="signup-name" type="text" class="form-control" name="name" placeholder="Name">
                                    </div>
                                </div>
                                
                                <!-- 
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="lastname" placeholder="Last Name">
                                    </div>
                                </div>
                                 -->
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input id="signup-password" type="password" class="form-control" name="passwd" placeholder="Password">
                                    </div>
                                </div>
                                    
                                <!-- 
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Invitation Code</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="icode" placeholder="">
                                    </div>
                                </div>
								 -->
								 
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                        <span style="margin-left:8px;">or</span>  
                                    </div>
                                </div>
                                
                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <a id="btn-fblogin" href="/ShareInterestsWeb//social/facebook/signin" class="btn btn-primary">Sign Up with Facebook</a>
                                    </div>                                           
                                </div>
                            </form>
                         </div>
                    </div>

               
               
                
         </div> 
    </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>