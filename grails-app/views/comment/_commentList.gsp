<g:each in="${post.comments}" var="comment">
	<div class="comment"> <!-- render this as a template-->
	<p>
		${comment.commentContent}
	</p>
	<p>
		Made by:
		${comment.who.name}
		on
		${comment.dateCreated}
	</p>	
	<span><g:link controller="comment" action="delete" id="${comment.id}">Delete Comment</g:link></span>
	</div>
</g:each>