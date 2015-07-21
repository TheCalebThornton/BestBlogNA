package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Post)
class PostSpec extends Specification {

    def setup() {
		
    }

    def cleanup() {
    }

	void "Test that name must not be empty"() {
		when: 'the name contains nothing'
		def p = new Post(name: '')

		then: 'validation should fail'
		!p.validate()

		when: 'the name contains stuff'
		p = new Post(name: 'stuff')

		then: 'validation should pass'
		p.validate()
	}
	
	void "Test that name not nullable"() {
		when: 'the name is set to null'
		def p = new Post(name: null)

		then: 'validation should fail'
		!p.validate()

		when: 'the name is not null'
		p = new Post(name: 'Not set to null')

		then: 'validation should pass'
		p.validate()
	}
	void "Test that name should not be grater than 50 characters"() {
		when: 'the name is more than 50 characters'
		StringBuffer buffInput = new StringBuffer()
		for(i=0;i<60;i++){
			buffInput.append(i);
		}
		def p = new Post(name: buffInput.toString())
		
		then: 'validation should fail'
		!p.validate()

		when: 'the name is less than 50 characters'
		buffInput = null
		for(i=0;i<60;i++){
			buffInput.append(i);
		}
		p = new Post(name: buffInput.toString())
		
		then: 'validation should pass'
		p.validate()
	}
}
