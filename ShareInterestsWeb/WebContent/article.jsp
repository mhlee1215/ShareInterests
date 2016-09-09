<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="image_src" href="http://54.201.96.236:8080/ShareInterestsWeb/assets/get.do?id=surfing.jpg" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="/ShareInterestsWeb/css/simplemde.min.css">
<script src="/ShareInterestsWeb/js/simplemde.min.js"></script>
<script src="/ShareInterestsWeb/js/marked.js"></script>

</head>
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



.left {
  
  font-family:Consolas,"Liberation Mono",Courier,monospace;
  float: left;
  width: 0%;
  height:95%;
  display:none;
}
.right {
  float: right;
  width: 100%;
  height:95%;
}
.show {display:block;}
.expanded_write { width: 44%; height:95%;}
.expanded_read { width: 55%; height:95%;}
.full-expanded { height:100vh; width:100% !important;}
.menu-full-expanded { width:100% !important;}

.collapsed { width: 0%; }
.edit_mode { overflow-y:auto; border:1px solid #eee;}


.trasition_div { min-height: 10em; transition: cubic-bezier(0, 0, 0.17, 0.79) 1s; }

.CodeMirror {
    height: 95vh;
}
</style>

<body>
<jsp:include page="header.jsp"/>



<div class="jumbotron text-center title_text">
  <h1>${hobbyTitle }</h1>
  <p>now writing by ${author.name}</p> 
</div>

<script type="text/javascript">
$(document).ready(function() {
	
	var action = '${action}';
	
	var simplemde = null;
	
	
		
		
	
	
	
	function goUpdateArticle(){
		//alert(simplemde.value());
		$.ajax({
			url: "/ShareInterestsWeb/browse/updateArticle.do",
			type: "post",
		    data: {
		    	articleId: '${article.id}',
		    	authorId: '${article.authorId}',
		    	description: simplemde.value()
		    },
		  success: function( result ) {
			  //alert(result);
			  if(result == 'success'){
				  //alert('login success!');
				  //window.location = '/ShareInterestsWeb/index.do';
				  $("#submit_button_text").html('Saved');
			  }else if(result == 'notfound'){
				  
				  alert('user not found');
			  }else {
				  alert(result);
			  }
			  //document.location = 'loginSuccess.do';				
		  }
		});
	}
	
	//alert(document.getElementById('read_textarea').innerHTML);
	document.getElementById('read_textarea_div').innerHTML =
	      marked(document.getElementById('read_textarea_div').innerHTML);
	//$('#MyID').keyup(function(e){
//		$("#submit_button_text").html('not_Saved');
//	});
	
	$('#edit_button').click(function(){
		
		$('#write_textarea_div').toggleClass('show');
	    $('#write_textarea_div').toggleClass('expanded_write');
	    $('#read_textarea_div').toggleClass('expanded_read');
	    $('#read_textarea_div').toggleClass('edit_mode');
	    
	    $('#parent_container').toggleClass('full-expanded');
	    $('.menu_container').toggleClass('menu-full-expanded');
	    
	    simplemde = new SimpleMDE({
	    	hideIcons: ["preview"],
	    	element: $("#write_textarea")[0] 
	    });
		//simplemde.value("This text will appear in the editor");
		
		simplemde.codemirror.on("change", function(){
		    //console.log(simplemde.value());
		    $("#submit_button_text").html('not_Saved');
		    
		    document.getElementById('read_textarea_div').innerHTML =
			      marked(simplemde.value());
		});
		
	});
	
	/*$('#write_textarea').bind('input propertychange', function() {
		
		document.getElementById('read_textarea_div').innerHTML =
		      marked($('#write_textarea').val());
		
		$("#submit_button_text").html('not_Saved');
	});*/
	
	$("#submit_button").on("click", function(event){
		goUpdateArticle();
	});
});
</script>

<div id="parent_container" class="container">

				<div id="write_textarea_div" class="left trasition_div" style="height:100%;">
				<textarea id="write_textarea" style="height:100%; width:100%;">${article.description}</textarea>		
				</div>
				
				 
				<div id="read_textarea_div" class="right trasition_div" style="height:100%;">${article.description}</div>
		
	
	
	
	
	
</div>


<c:if test="${authority == 'my' }">
<div class="container menu_container" style="text-align: right">
<button id="submit_button" class="button button_like"><span id="submit_button_text">Submit</span></button>
</div>
<div class="container menu_container" style="text-align: right">
<button id="edit_button" class="button button_like"><span id="submit_button_text">Edit mode</span></button>
</div>
</c:if>

<c:if test="${authority != 'my' }">
<div class="container menu_container" style="text-align: right">
like button is here..
</div>
</c:if>



<jsp:include page="footer.jsp"/>
<script src="/ShareInterestsWeb/js/pgwslider.min.js"></script>
</body>
</html>