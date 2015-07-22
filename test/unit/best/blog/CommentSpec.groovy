package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Comment)
class CommentSpec extends Specification {

	
	void 'test commentContent'(){
		when:
		def comment = new Comment(commentContent: 'This test is testless. I could test a better test in my test.')
		
		then:
		comment.validate(["commentContent"])
		
		when:
		comment.commentContent = ''
		
		then:
		!comment.validate(["commentContent"])
		
		when:
		comment.commentContent = 

		then:
		!comment.validate		
		
	}
	
	
	
	
    void 'test date'() {
		when:
		def comment = new Comment(dateCreated: null)
		then:
		comment.validate(["dateCreated"])
			}
}
