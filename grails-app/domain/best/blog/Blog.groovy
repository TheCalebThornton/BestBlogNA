package best.blog

class Blog {
	static hasMany = [posts:Post]
	
	String title		//url
	
    static constraints = {
    }
}
