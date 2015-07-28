<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>
	${post.postName}
</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style type="text/css">
img {
	max-width: 100%;
}
</style>
</head>
<body class ="landing" >
	<header role="banner" >
	<a class="navbar-brand" href="/best-blog-NA/">Best Blog NA</a>
		<!--<nav role="navigation" class="navbar navbar-static-top navbar-default">
			<div class="container" >
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle Navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					</div>
					
				
			</div>
		</nav>-->
	</header>
	<main role="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-6" id="content">
				<g:link controller="post" action="edit"><button class = "button small" type="button">Create a new post</button>  </g:link>
		
				<h1>
					${post.postName}
				</h1>
				<p>
					${post.teaser}
				</p>
				<div>
					${post.postContent}
				</div>
				<g:link controller="post" action="edit" id="${post.id}">
          		<button type="button" class = "button small">Edit this post</button> 
          		</g:link>
				<div>
					<g:link controller="comment" action="edit" id="${post.id}"><button type="button" class = "button small">Add Comment</button> </g:link>
					<g:if test="${post.comments.isEmpty()}">
					</g:if>
					<g:else>
						<h5>Comments:</h5>
						<g:each in="${post.comments}" var="comment">
							<div class="comment">
								<p>
									${comment.commentContent}
								</p>
								<p>
									Made by:
									${comment.who.name}
									on
									${comment.dateCreated}
								</p>
								<g:link controller="comment" action="delete" id="${comment.id}">Delete Comment</g:link>
							</div>
						</g:each>
					</g:else>
				</div>
			</div>
			<div class="col-sm-4">
				<br /> About me! <br /> Ladi dodi
			</div>
		</div>
	</div>
	</main>
	<footer role="contentInfo">
		<div class="footer">
			<p>
				<small>Copyright &copy; Manifest Solutions 2015, Written by
					Caleb Thornton and Garrick Servello</small>
			</p>
		</div>
	</footer>


</body>
</html>