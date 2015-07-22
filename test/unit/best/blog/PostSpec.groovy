package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Post)
class PostSpec extends Specification {

	private static final String VALID_INPUT = 'This input is valid'
	private static final Date VALID_DATE = new Date()
	private static final String TWENTY_CHARACTERS = "xxxxxxxxxxxxxxxxxxxx"
	private static final String SINGLE_CHARACTER = "x"

    def setup() {
		
    }

    def cleanup() {
    }

	void "Test that name must not be empty"() {
		when: 'the name contains nothing'
		def p = new Post(postName: '')

		then: 'validation should fail'
		!p.validate(["postName"])

		when: 'the name contains stuff'
		p = new Post(postName: VALID_INPUT)

		then: 'validation should pass'
		p.validate(["postName"])
	}
	
	void "Test that name not nullable"() {
		when: 'the name is set to null'
		def p = new Post(postName: null)

		then: 'validation should fail'
		!p.validate(["postName"])

		when: 'the name is not null'
		p = new Post(postName: VALID_INPUT)

		then: 'validation should pass'
		p.validate(["postName"])
	}
	void "Test that name size should not be greater than 50 characters"() {
		when: 'the name is more than 50 characters'
		StringBuffer buffInput = new StringBuffer()
		int i;
		for(i=0;i<60;i++){
			buffInput.append(SINGLE_CHARACTER);
		}
		def p = new Post(postName: buffInput.toString())
		
		then: 'validation should fail'
		!p.validate(["postName"])

		when: 'the name is less than 50 characters'
		buffInput = new StringBuffer();
		for(i=0;i<50;i++){
			buffInput.append(SINGLE_CHARACTER);
		}
		p = new Post(postName: buffInput.toString())
		
		then: 'validation should pass'
		p.validate(["postName"])
	}
	void "Test that teaser size should be less than 100 characters"() {
		when: 'the teaser is more than 100 characters'
		StringBuffer buffInput = new StringBuffer()
		int i;
		for(i=0;i<101;i++){
			buffInput.append(SINGLE_CHARACTER);
		}
		def p = new Post(teaser: buffInput.toString())
		
		then: 'validation should fail'
		!p.validate(["teaser"])

		when: 'the teaser is less than 100 characters'
		buffInput = new StringBuffer();
		for(i=0;i<60;i++){
			buffInput.append(SINGLE_CHARACTER);
		}
		p = new Post(teaser: buffInput.toString())
		
		then: 'validation should pass'
		p.validate(["teaser"])
	}
	void "Test that postContent should not be null"() {
		when: 'the postContent is set to null'
		def p = new Post(postContent: null)
		
		then: 'validation should fail'
		!p.validate(["postContent"])

		when: 'the postContent is not null'
		p = new Post(postContent: VALID_INPUT)
		
		then: 'validation should pass'
		p.validate(["postContent"])
	}
	void "Test that postContent should not be blank"() {
		when: 'the postContent is set to blank'
		def p = new Post(postContent: "")
		
		then: 'validation should fail'
		!p.validate(["postContent"])

		when: 'the postContent is not blank'
		p = new Post(postContent: VALID_INPUT)
		
		then: 'validation should pass'
		p.validate(["postContent"])
	}
	void "Test that postContent size should not be greater than 2000"() {
		when: 'the postContent size is set to 2001'
		StringBuffer buffInput = new StringBuffer()
		int i;
		for(i=0;i<101;i++){
			buffInput.append(TWENTY_CHARACTERS);
		}
		def p = new Post(postContent: buffInput.toString())
		
		then: 'validation should fail'
		!p.validate(["postContent"])

		when: 'the postContent size is set to 2000'
		buffInput = new StringBuffer();
		for(i=0;i<100;i++){
			buffInput.append(TWENTY_CHARACTERS);
		}
		p = new Post(postContent: buffInput.toString())
		
		then: 'validation should pass'
		p.validate(["postContent"])
	}
	void "Test that lastUpdated should be null"() {
		when: 'the lasUpdated is set to null'
		def p = new Post(lastUpdated: null)
		
		then: 'validation should fail'
		p.validate(["lastUpdated"])

		when: 'the lastUpdated is not null'
		p = new Post(lastUpdated: VALID_DATE)
		
		then: 'validation should pass'
		p.validate(["lastUpdated"])
	}
	void "Test that isPublished should not be null"() {
		when: 'the isPublished is set to null'
		def p = new Post(isPublished: null)
		
		then: 'validation should fail'
		!p.validate(["isPublished"])

		when: 'the isPublished is not null'
		p = new Post(isPublished: true)
		
		then: 'validation should pass'
		p.validate(["isPublished"])
	}
}
