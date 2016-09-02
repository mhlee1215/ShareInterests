<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Share Interests</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/ShareInterestsWeb/css/searchFormStyle.css">
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
	  <form class="ct-formSearch--extended ct-u-marginBottom50" role="form">
        <div class="form-group ">
            <div class="ct-form--label--type1">
                <div class="ct-u-displayTableVertical">
                    <div class="ct-u-displayTableCell">
                        <div class="ct-input-group-btn">
                            <button class="btn btn-primary">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                    <div class="ct-u-displayTableCell text-center">
                        <span class="text-uppercase">Search for property</span>
                    </div>
                </div>
            </div>
            <div class="ct-u-displayTableVertical ct-u-marginBottom20">
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Property id</label>
                        <input type="text" required class="form-control input-lg" placeholder="Any">
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Location</label>
                        <select class="ct-js-select ct-select-lg">
                            <option value="any">Any</option>
                            <option value="1">New York</option>
                            <option value="2">New Jersey</option>
                            <option value="3">Newark</option>
                            <option value="4">Philadelphia</option>
                        </select>
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Sub-Location</label>
                        <select class="ct-js-select ct-select-lg">
                            <option value="any">Any</option>
                            <option value="1">New York</option>
                            <option value="2">Jersey</option>
                            <option value="3">Newark</option>
                            <option value="4">Philadelphia</option>
                        </select>
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Property Status</label>
                        <select class="ct-js-select ct-select-lg">
                            <option value="any">Any</option>
                            <option value="1">Sale</option>
                            <option value="2">New</option>
                            <option value="3">Loan</option>
                        </select>
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Property type </label>
                        <select class="ct-js-select ct-select-lg">
                            <option value="any">Any</option>
                            <option value="1">Houses</option>
                            <option value="2">Industrial</option>
                            <option value="3">Retail</option>
                            <option value="4">Apartments</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="ct-u-displayTableVertical ct-slider--row ct-sliderAmount">
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Bedrooms</label>
                        <select class="ct-js-select ct-select-lg">
                            <option value="any">Any</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3+</option>
                        </select>
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Bathrooms</label>
                        <select class="ct-js-select ct-select-lg">
                            <option value="any">Any</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3+</option>
                        </select>
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <label>Price ($)</label>
                        <input type="text" value="1000000" required class="form-control input-lg ct-js-slider-min" placeholder="">
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <input type="text" class="slider ct-js-sliderAmount" value="" data-slider-tooltip="hide" data-slider-handle="square" data-slider-min="5000" data-slider-max="5000000" data-slider-step="5000" data-slider-value="[1000000,2000000]">
                    <label>Min</label>
                    <label class="pull-right">Max</label>
                </div>
                <div class="ct-u-displayTableCell">
                    <div class="ct-form--item">
                        <input type="text" value="2000000" required class="form-control input-lg ct-js-slider-max" placeholder="">
                    </div>
                </div>
                <div class="ct-u-displayTableCell">
                    <input type="text" class="slider ct-js-sliderTicks" value="" data-slider-handle="square" data-slider-min="0" data-slider-max="200" data-slider-step="20" data-slider-value="[60,120]"/>
                    <label class="text-center center-block">Area (m2)</label>
                </div>
                <div class="ct-u-displayTableCell">
                    <button type="submit" class="btn btn-warning text-capitalize pull-right">search now</button>
                </div>
            </div>
        </div>
    </form>
	 

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