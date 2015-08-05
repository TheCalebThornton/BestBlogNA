<h3>Create a comment</h3>
<div id="validationerrors">
	<g:renderErrors bean="${comment}" />
</div>
<g:form name="createComment">
	<g:hiddenField name="postId" value="${post.id}" />
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
	<g:submitToRemote name="submit" url="[controller:'comment', action:'save']" update="comment" value="Save" />
</g:form>
</div>