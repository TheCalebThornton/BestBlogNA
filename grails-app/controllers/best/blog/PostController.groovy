package best.blog

class PostController {

	static defaultAction = 'list'

	def edit = {
		def post = Post.get(params.id)
		if(!post) {
			post = new Post()
		}
		render(view:'edit', model:[post:post])
	}

//	def postList = {
//		[posts: Post.list(params), postCount: Post.count()]	
//	}
	
	def list = {
		render(
				view:'list',
				model:[posts:Post.list(sort:'lastUpdated',
					order:'desc'), postCount:Post.count(), offset:'0'])
	}

	
//	def save = {
//		def editPost = params
//		def post = loadPost(params.id)
//		post.postName = editPost.postName
//		post.postContent = editPost.postContent
//		post.teaser = editPost.teaser
//		if (editPost.isPublished == null){
//			post.isPublished = false
//		}
//		else{
//			post.isPublished = editPost.isPublished
//		}
//		post.comments = null
//
//		if(post.save(flush: true)) {
//			redirect(action:'list')
//		} else {
//			render(view:'edit', model:[post:post])
//		}
//	}
	//REKT
	def save = { 
		def post = loadPost(params.id) 
		post.properties = params 
		if(post.save(flush: true)) { redirect(action:'list') } 
		else { render(view:'edit', model:[post:post]) } 
	}
	def delete = {
		def post = loadPost(params.id)
		if(!post.delete(flush: true)) {
			redirect(action:'list')
		} else {
			render(view:'edit', model:[post:post])
		}
	}
	
	def view = {
		render(view:'view', model:[post:Post.get(params.id)])
	}
	
	//Creates instance of Post with specific ID
	private loadPost(id) {
		def post = new Post();
		if(id) {
			post = Post.get(id)
		}
		return post
	}
}
