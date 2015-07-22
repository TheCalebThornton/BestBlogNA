package best.blog

import java.util.Date;
import java.util.SortedSet;

class Post {
	
	static hasMany = [comments:Comment]
	SortedSet comments	
	String postName
	String postContent
	String teaser
	Boolean isPublished
	Date lastUpdated
	
	static constraints = {
		postName(nullable:false, blank:false, size:1..50)
		teaser(size:1..100)
		postContent(nullable:false, blank:false, size:1..2000)
		lastUpdated(nullable:true)
		isPublished(nullable:false)
		comments(nullable:true)
	}
}
