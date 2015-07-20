import best.blog.Post

class BootStrap {

    def init = { servletContext ->
		
		new Post(postName:"Frist Grails Project",
			teaser:"Clearing out the clutter",
			postContent:"The full content of the article",
			isPublished:true).save()
			
		new Post(postName:"Frist Grails Project",
			teaser:"Clearing out the clutter",
			postContent:"The full content of the article",
			isPublished:true).save()
			
		
		
    }
    def destroy = {
    }
}
