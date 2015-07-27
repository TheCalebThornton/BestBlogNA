<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Best Blog NA</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'simplePagination.css')}" type="text/css">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<g:javascript library="jquery.simplePagination" />

<style type="text/css">
img {
	max-width: 100%;
}
</style>
<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}"
	type="image/x-icon">
</head>
<body class ="landing">
	<header role="header" id="header" class="alt">
		<!--<nav role="navigation" class="navbar navbar-static-top navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle Navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/best-blog-NA/">Best Blog NA</a>

				</div>
			</div>
		</nav>-->
	</header>
	<main role="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div id="allposts" class="col-sm-6">
				<div id="spinner" class="spinner" style="display: none;">
					<g:message code="spinner.alt" default="Loading&help;" />
				</div>
				
				Search:
				<input type="text" id="searchCustom">
				<br />
					<g:link controller="post" action="edit"><button class = "button small" type="button">Create a new post</button>  </g:link>
				<br />
				<h2>My Posts</h2>
				
				
				<g:each in="${posts}" var="post">
				
					<div id="${post.id}" class="singlepost">
						<%--<g:set var="linkTitle" value="${post.postName}"></g:set>--%>
						<g:javascript>linkTitle = "${post.postName}".replace(/\s/g, ''); </g:javascript>
						<g:link controller="post" action="view" id="${post.id}" elementId="${post.id}" params='[title:"${post.postName}".replaceAll('\\s+','-')]'>
						<section id="blogCustom" class="wrapper special">

							<h2>
								${post.postName}
							</h2>
							</g:link>
							<p>
								${post.teaser}
							</p>
							<h6>
								Last Updated:
								${post.lastUpdated}
							</h6>
							
						<g:link controller="post" action="edit" id="${post.id}">
          					<button class = "button small" type="button">Edit post </button>
          				</g:link>
						<g:link controller="post" action="view" id="${post.id}"><button class = "button small" type="button">View Comments</button></g:link>
						</section>
					</div>
				</g:each>
				<p></p>
				<div class="simple-pagination" id="pagination" >
				</div>
			</div>
			<div class="col-sm-4 sidebar-nav" id="sidebar">
				<br /> About me! <br /> Best blogalog NA
			</div>
		</div>
	</div>
	</main>
	<footer role="contentInfo">
		<div class="footer">
			<p>
				<small>Copyright &copy; Manifest Solutions 2014, Written by
					Caleb Thornton and Garrick Servello</small>
			</p>
		</div>
	</footer>
	
<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>
<script>
	$(document).ready(function(){

		$(function() {
			var items = $(".singlepost");

		    var numItems = items.length;
		    var perPage = 10;

		    items.slice(perPage).hide();

		    $("#pagination").pagination({
		        items: numItems,
		        itemsOnPage: perPage,
		        cssStyle: 'light-theme',
		        onPageClick: function(pageNumber) { 
		            var showFrom = perPage * (pageNumber - 1);
		            var showTo = showFrom + perPage;

		            items.hide() 
		                 .slice(showFrom, showTo).show();
		        }
		    });
		});
		
		$("#searchCustom").keyup(function(){
			 var val = $(this).val().toLowerCase();
			 $(".singlepost").hide();
			 
			 $(".singlepost").each(function(){
				 
			 	var text = $(this).text().toLowerCase();
			 	
			 	if(text.indexOf(val) != -1)
			 	{
			 		$(this).show();
			 	}
			 	
			 });
		});	

	});

	

</script>

</body>
</html>
