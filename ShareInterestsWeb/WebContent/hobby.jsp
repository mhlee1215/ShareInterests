<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Share Interests > ${categoryName} > ${hobbyTitle}</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/ShareInterestsWeb/css/pgwslider.min.css">


</head>
<script type="text/javascript">
$(document).ready(function() {
    $('.pgwSlider').pgwSlider({
    	"maxHeight":300,
    	"displayControls":true,
    	"verticalCentering":true,
    	"intervalDuration":5000
    });
    
        
    
    $("#action_article").on("click", function(event){
    	document.location = '${actionArticleUrl}';
	});
    
	function goArticleAction(url){
		
		$.ajax({
			url: url,
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
});
</script>
<style>
.title_text {
    text-transform: uppercase;
}

.button_like {
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 12px;
  padding: 7px;
  width: 100px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button_articles {
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 12px;
  padding: 7px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button_price {
  border-radius: 4px;
  background-color: #4CAF50;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 12px;
  padding: 7px;
  width: 50px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button_my_article {
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  padding: 7px;
  text-align: center;
  font-size: 13px;
  width: 160px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '»';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

</style>

<body>
<jsp:include page="header.jsp"/>



<div class="jumbotron text-center title_text">
  <h1>${hobbyTitle }</h1>
  <p>Resize this responsive page to see the effect!</p> 
  <button class="button button_like"><span>324 Likes </span></button>
  <button class="button button_articles"><span>3245 Articles </span></button> 
  <button class="button button_price"><span>$$</span></button>
</div>

<div class="container" style="text-align: right">
<button id="action_article" class="button button_my_article"><span>${actionArticleDisplay}</span></button>
</div>

<div class="container" >
<ul class="pgwSlider">
    <li><img src="/ShareInterestsWeb/assets/get?id=surfing" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars"></li>
    <li><img src="/ShareInterestsWeb/assets/get?id=surfing" alt="Montréal, QC, Canada" data-large-src="/ShareInterestsWeb/assets/surfing.jpg"></li>
    <li>
        <img src="/ShareInterestsWeb/assets/surfing.jpg">
        <span>Shanghai, China</span>
    </li>
    <li>
        <a href="http://www.nyc.gov" target="_blank">
            <img src="/ShareInterestsWeb/assets/surfing.jpg">
	    <span>New York, NY, USA</span>
        </a>
    </li>
</ul>
</div>

<div class="container">
  <div class="row">
    <c:forEach items="${popularArticleList}" var="article" begin="0"
               end="2" step="1">
	    <div class="col-sm-4">
		    <h3>${article.title} <a href="/ShareInterestsWeb/browse/${categoryName}/${hobbyTitle}/${article.authorId}">Detail</a> </h3>
		    <p>(${article.likes } likes)</p>
		    <p>${article.articleAbstract}</p>
	    </div>
    </c:forEach>
  </div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/ShareInterestsWeb/js/pgwslider.min.js"></script>
</body>
</html>