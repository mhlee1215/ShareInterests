<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Share Interests</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script   src="https://code.jquery.com/jquery-3.1.0.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Navigation Bar -->
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact Us</a></li>
          </ul>
        </div>
      </div>
</div>
<!-- logo -->
<div class="container">
    <div style="margin-top: 100px; text-align: center;">
        <h1>Share Interests</h1>
        <p class="lead">Never stop exploring</p>
    </div>
      
	<div class="input-group">
  	<input type="text" class="form-control">
  	<span class="input-group-btn">
    <button class="btn btn-default" type="button">Go!</button>
  	</span>
	</div>

	<!-- category -->
	<ul class="list-group">
	<c:forEach items="${category}" var="item">
  		<li class="list-group-item">${item.name} <span class="badge"> ${item.size()} </span></li>
	</c:forEach>
	</ul>

</div>
</body>
</html>
</body>
</html>