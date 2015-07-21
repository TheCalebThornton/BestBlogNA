package best.blog
import java.util.Date;

class Comment implements Comparable {
	static belongsTo = Post
	
	Post post
	String commentContent
	Commentator who = new Commentator()
	Date dateCreated
	
	static constraints = {
	}
	
	public int compareTo(Object o){
		return dateCreated.compareTo(o.dateCreated)
	}
    
}
