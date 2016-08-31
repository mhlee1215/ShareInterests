<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/ShareInterestsWeb/css/pgwslider.min.css">
<script src="/ShareInterestsWeb/js/pgwslider.min.js"></script>

</head>
<script type="text/javascript">
$(document).ready(function() {
    $('.pgwSlider').pgwSlider({
    	"maxHeight":300,
    	"displayControls":true,
    	"verticalCentering":true,
    	"intervalDuration":5000
    });
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
  font-size: 15px;
  padding: 10px;
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
  font-size: 15px;
  padding: 10px;
  width: 150px;
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
<div class="jumbotron text-center title_text">
  <h1>${hobbyTitle }</h1>
  <p>Resize this responsive page to see the effect!</p> 
  <button class="button button_like"><span>324 Likes </span></button>
  <button class="button button_articles"><span>3245 Articles </span></button> 
</div>

<div class="container" >
<ul class="pgwSlider">
    <li><img src="/ShareInterestsWeb/assets/surfing.jpg" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars"></li>
    <li><img src="/ShareInterestsWeb/assets/surfing.jpg" alt="Montréal, QC, Canada" data-large-src="/ShareInterestsWeb/assets/surfing.jpg"></li>
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
    <div class="col-sm-4">
      <h3>Column 1</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    <div class="col-sm-4">
      <h3>Column 2</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    <div class="col-sm-4">
      <h3>Column 3</h3> 
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div>
</div>
</body>
</html>