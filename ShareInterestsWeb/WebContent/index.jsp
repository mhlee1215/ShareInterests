<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Share Interests</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<script   src="https://code.jquery.com/jquery-3.1.0.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

 <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-heading">Share Interests</div>
                <div class="intro-lead-in">Tell us your Story and More</div>
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                    </div>
                </div>
            </div>
    </header>
    
<!-- logo -->
<div class="container" style="display:block;">
	<!-- Header -->
   <!-- 
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
	 -->
	  
	 

	<!-- category -->
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	<c:forEach items="${category}" var="cat">
		<div class="panel panel-default" style="margin:0px">
    		<div class="panel-heading" role="tab" id="heading${cat.id}">
      			<h4 class="panel-title">
        			<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${cat.id}" aria-expanded="false" aria-controls="collapse${item.id}">
					${cat.name} <span class="badge" align="right"> ${cat.size()} </span>      
        			</a>
      			</h4>
    		</div>
    		<div id="collapse${cat.id}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${cat.id}">
      			<div class="panel-body">
        		<c:forEach items="${cat.hobbyList}" var="hobby">
        			<a href="${cat.name}/${hobby.title}.do"> ${hobby.title}, </a>
      			</c:forEach>
      			</div>
    		</div>
  		</div>  		
	</c:forEach>
	</div>
	
	<c:forEach items="${category}" var="cat">
	<button class="accordion2">${cat.name} <span class="badge" align="right"> ${cat.size()} </span>   </button>
	<div class="panel2">
	  <div class="panel-body">
        		<c:forEach items="${cat.hobbyList}" var="hobby">
        			<a href="${cat.name}/${hobby.title}.do"> ${hobby.title}, </a>
      			</c:forEach>
      			</div>
	</div>
	</c:forEach>
	
	
	
	
<script>
var acc = document.getElementsByClassName("accordion2");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function(){
        this.classList.toggle("active");
        this.nextElementSibling.classList.toggle("show");
  }
}
</script>
<style>
button.accordion2 {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    transition: 0.4s;
}

button.accordion2.active, button.accordion:hover {
    background-color: #ddd;
}

button.accordion2:after {
    content: '\02795';
    font-size: 13px;
    color: #777;
    float: right;
    margin-left: 5px;
}

button.accordion2.active:after {
    content: "\2796";
}

div.panel2 {
    padding: 0 18px;
    background-color: white;
    max-height: 0;
    overflow: hidden;
    transition: 0.6s ease-in-out;
    opacity: 0;
}

div.panel2.show {
    opacity: 1;
    max-height: 500px;
}
</style>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>