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
		comment(nullable:false, blank:false, length:1..50)
		dateCreated(nullable:true)
	}
	
	public int compareTo(Object o){
		return dateCreated.compareTo(o.dateCreated)
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean nullable() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
