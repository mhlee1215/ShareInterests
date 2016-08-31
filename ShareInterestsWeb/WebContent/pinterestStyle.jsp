<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<link rel="stylesheet" href="/ShareInterestsWeb/css/pinterest-style.css">
<script src="/ShareInterestsWeb/js/freewall.js"></script>
</head>
<script type="text/javascript">
		$(document).ready(function() {
			var wall = new Freewall("#freewall");
			wall.reset({
				selector: '.brick',
				animate: true,
				cellW: 200,
				cellH: 'auto',
				onResize: function() {
					wall.fitWidth();
				}
			});

			wall.container.find('.brick img').load(function() {
				wall.fitWidth();
			});
		});

		</script>
		<style type="text/css">
			body {
				background: rgba(231, 231, 231, 0.43);
			}
			.free-wall {
				margin: 15px;
			}
			.brick {
				width: 221.2px;
			}
			.info {
				padding: 15px;
				color: #333;
			}
			.brick img {
				margin: 0px;
				padding: 0px;
				display: block;
			}
		</style>
<body>
<div class='header'>
<jsp:include page="header.jsp"></jsp:include>			
		</div>
		<div id="freewall" class="free-wall">
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing2.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing3.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing4.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing2.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/camping2.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/camping1.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/camping4.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing2.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing3.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/camping3.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing4.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing2.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing3.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    <div class="brick">
		        <img src="/ShareInterestsWeb/assets/surfing4.jpg" width="100%">
		        <div class="info">
		            <h3>Freewall</h3>
		            <h5>Pinterest layout</h5>
		        </div>
		    </div>
		    
		</div>
<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>