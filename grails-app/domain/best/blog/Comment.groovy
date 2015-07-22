package best.blog

import java.lang.annotation.Annotation;
import java.util.Date

import grails.validation.Validateable

class Comment implements Comparable{
	static belongsTo = Post
	
	String commentContent
	Commentator who = new Commentator()
	Date dateCreated
	
	static constraints = {
		commentContent(nullable:false, blank:false, size:1..200)
		dateCreated(nullable:true)
	}
	
	public int compareTo(Object o){
		return dateCreated.compareTo(o.dateCreated)
	}
}
