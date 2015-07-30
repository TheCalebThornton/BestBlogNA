<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Create Comment</title>
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
<body>
	<header role="banner">
		<!--<nav role="navigation" class="navbar navbar-static-top navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle Navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
		
					<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a href="/BestBlogNA/">Home</a></li>
						<li><g:if test="${session.user}">
								<g:link controller="user" action="logout">Logout</g:link>
							</g:if> <g:else>
								<g:link controller="user" action="login">Login</g:link>
						</ul>
				</div>
			</div>
		</nav>-->
	</header>
	<main role="main">
	<div class="container-fluid">
		<a href="/best-blog-NA/" class="image fit" id="logo"><img src="${resource(dir: 'images', file: 'Better_Logo.bmp')}" alt="Best Blog NA" /></a>
		<div class="row">
			<div class="col-sm-2">
			<!--  HeMan -->
			</div>
			<div class="col-sm-6">
				<h3>Create a comment</h3>
				<div id="validationerrors">
					<g:renderErrors bean="${comment}" />
				</div>
				<g:form controller="comment" action="save">
					<g:hiddenField name="postId" value="${postId}" />
					<dl class="row uniform 50%">
						<dt class="6u 12u$(xsmall)">Your name:</dt>
						<dd>
							<g:textField name="who.name" value="${comment.who.name}" />
						</dd>
						<dt class="6u 12u$(xsmall)">Add your comment:</dt>
						<dd>
							<g:textArea name="commentContent" value="${comment.commentContent}" rows="5"
								cols="150" />
						</dd>
					</dl>
					<br />
					<g:submitButton name="submit" value="Save" />
				</g:form>
			</div>

			<div class="col-sm-4">
				<br /> About me! <br /> Bibidy Bobidy Buu
			</div>
		</div>
	</div>
	</main>
	<footer role="contentInfo">
		<div class="footer">
			<p>
				<small>Copyright &copy; Manifest Solutions 2015, Written by
					Caleb Thornton & Garrick Servello </small>
			</p>
		</div>
	</footer>

</body>
</html>