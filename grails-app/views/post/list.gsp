<%@ page contentType="text/html;charset=UTF-8" %><asset:assetPath/>
<html>
	<head>
		<title>The Blog</title>
	</head>
	<body>
	<h1>My Posts</h1>
	
	<g:each in="${posts}" var="post">
		<div>
			<h2>${post.title}</h2>
			<p>${post.teaser}</p>
			<p>Last Update: ${post.lastUpdated}</p>
		</div>
	</g:each>
	</body>
</html>