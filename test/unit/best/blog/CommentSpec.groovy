package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Comment)
class CommentSpec extends Specification {

	
	void 'test commentContent'(){
		when: 'a valid name is written'
		def comment = new Comment(commentContent: 'This test is testless. I could test a better test in my test.')
		
		then:'check that it is valid'
		comment.validate(["commentContent"])
		
		when:'name is null'
		comment.commentContent = ''
		
		then:'it should be invalid'
		!comment.validate(["commentContent"])
		
		
		 
		when: 'the comment exceeds 200 characters'
		StringBuffer buffInput = new StringBuffer()
		int i;
		for(i=0;i<41;i++){
			buffInput.append("xxxxx");
		}
		comment = new Comment(commentContent: buffInput.toString())

		
		then:'it should be invalid'
		!comment.validate(["commentContent"])	
		
	}
	
	
	
	
    void 'test date'() {
		when:'a null date is written'
		def comment = new Comment(dateCreated: null)
		then:'it should be still be valid'
		comment.validate(["dateCreated"])
			}
}
