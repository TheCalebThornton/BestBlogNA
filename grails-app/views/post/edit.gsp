<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Manage Post</title>
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
	<a class="navbar-brand" href="/best-blog-NA/">Best Blog NA</a>
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
			</div>
		</nav>-->
	</header>
	<main role="main">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-6">
				<h1>Edit your post</h1>
				<div id="validationerrors">
					<g:renderErrors bean="${post}" />
				</div>
				<g:form controller="post" action="save">
					<g:hiddenField name="id" value="${post.id}" />
					<dl>
						<dt>Post Title:</dt>
						<dd>
							<g:textField name="postName" value="${post.postName}" size="50" />
						</dd>
						<dt>Post Teaser:</dt>
						<dd>
							<g:textArea name="teaser" value="${post.teaser}" cols="50" />
						</dd>
						<dt>Content:</dt>
						<dd>
							<g:textArea name="postContent" value="${post.postContent}" rows="20"
								cols="50" />
						</dd>
						<dt>Publish:</dt>
						<dd>
							<g:checkBox name="isPublished" value="${post.isPublished}" />
						</dd>
					</dl>
					<g:submitButton name="submit" value="Save"/>
					<g:actionSubmit name="delete" action="delete" value="Delete"/>
				</g:form>
			</div>
			<div class="col-sm-4">
				<br /> About me! <br /> I pity the fool
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