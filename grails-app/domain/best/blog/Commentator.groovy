package best.blog

class Commentator {
	static belongsTo = Comment
	
	String name
	
    static constraints = {
		name(nullable:false, blank:false)
    }
}
