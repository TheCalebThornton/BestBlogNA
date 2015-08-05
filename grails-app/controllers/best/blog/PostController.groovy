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
	
	def list = {
		render(
				view:'list',
				model:[posts:Post.list(sort:'lastUpdated',
					order:'desc'), postCount:Post.count()])
	}

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
		render(view:'view', model:[post:Post.get(params.id),
			comment:new Comment()])	
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
