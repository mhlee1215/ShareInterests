<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Share Interests</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<script   src="https://code.jquery.com/jquery-3.1.0.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style type="text/css">
header .index {
	padding-top:200px !important;
	padding-bottom:50px !important;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

 <header>
        <div class="container">
            <div class="intro-text index">
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

<style>

.col-md-7{
	width:30%;
}

</style>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    <small>Search Result for:</small> ${keyword}
                </h1>
            </div>
        </div>
        <!-- /.row -->



        <!-- Search Result List -->
        
        <c:forEach items="${searchResult}" var="hobby">
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img class="img-responsive" src="/ShareInterestsWeb/assets/get?id=${hobby.represent_img_id}" alt="">
                </a>
            </div>
            <div class="col-md-5">
                <h3>${hobby.title}</h3>
                <!--<h4>Subheading: quote for this hobby</h4>-->
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium veniam exercitationem expedita laborum at voluptate. Labore, voluptates totam at aut nemo deserunt rem magni pariatur quos perspiciatis atque eveniet unde.</p>
                <a class="btn btn-primary" href="<%=contextPath%>/browse/search">Details<span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
        <!-- /.row -->

        <hr>
        </c:forEach>
        

        <!-- Pagination -->
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li>
                        <a href="#">&laquo;</a>
                    </li>
                    <li class="active">
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li>
                        <a href="#">&raquo;</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /.row -->

        <hr>

        

    </div>
    <!-- /.container -->

<jsp:include page="footer.jsp"/>
</body>
</html>