package best.blog

class CommentController {

//    def edit = {
//		def post = Post.get(params.id)
//        render(view:'edit',
//                model:[
//                        comment:new Comment(),
//                        postId:post.id])
//    }

    def save = {
        def comment = new Comment(params)
        comment.dateCreated = new Date()
        comment.post = Post.get(params.postId)
        if(comment.save(flush: true)) {
			render(template:'commentList', model:[post:comment.post])
        } else {
			println(comment.errors)
        }
    }
	def delete = {
		def comment = loadComment(params.id)
		if(!comment.delete(flush: true)) {
			redirect(controller:'post',
                    action:'view',
                    id:comment.post.id)
		} else {
			flash.message = "Delete failed"
		}
	}
	//Creates instance of Post with specific ID
	private loadComment(id) {
		def comment = new Comment();
		if(id) {
			comment = Comment.get(id)
		}
		return comment
	}
}
