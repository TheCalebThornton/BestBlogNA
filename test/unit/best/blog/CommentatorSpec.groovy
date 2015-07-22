package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Commentator)
class CommentatorSpec extends Specification {

	private static final String VALID_EMAIL = "gg@wp.com"
	private static final String INVALID_EMAIL = "gg.com"
	private static final String VALID_URL = "https://www.google.com/"
	private static final String INVALID_URL = "Not valid.url"
	private static final String VALID_NAME = "This is valid input"

    def setup() {
    }

    def cleanup() {
    }

	void "Test that name must not be blank"() {
		when: 'the name contains nothing'
		def c = new Commentator(name: '')
	
		then: 'validation should fail'
		!c.validate(["name"])
	
		when: 'the name contains stuff'
		c = new Commentator(name: VALID_NAME)
	
		then: 'validation should pass'
		c.validate(["name"])
	}
	void "Test that name must not be null"() {
		when: 'the name contains nothing'
		def c = new Commentator(name: null)
	
		then: 'validation should fail'
		!c.validate(["name"])
	
		when: 'the name contains stuff'
		c = new Commentator(name: VALID_NAME)
	
		then: 'validation should pass'
		c.validate(["name"])
	}
	void "Test that url can be blank"() {
		when: 'the url contains nothing'
		def c = new Commentator(url: '')
	
		then: 'validation should pass'
		c.validate(["url"])
	
		when: 'the url contains a url'
		c = new Commentator(url: VALID_URL)
	
		then: 'validation should pass'
		c.validate(["url"])
	}
	void "Test that url can be null"() {
		when: 'the name contains nothing'
		def c = new Commentator(url: null)
	
		then: 'validation should fail'
		c.validate(["url"])
	
		when: 'the url contains a url'
		c = new Commentator(url: VALID_URL)
	
		then: 'validation should pass'
		c.validate(["url"])
	}
	void "Test that url is a valid url"() {
		when: 'the url is set to a random string'
		def c = new Commentator(url: INVALID_URL)
	
		then: 'validation should fail'
		!c.validate(["url"])
	
		when: 'the url contains a url'
		c = new Commentator(url: VALID_URL)
	
		then: 'validation should pass'
		c.validate(["url"])
	}
	void "Test that email can be blank"() {
		when: 'the email contains nothing'
		def c = new Commentator(email: '')
	
		then: 'validation should pass'
		c.validate(["email"])
	
		when: 'the email contains an email'
		c = new Commentator(email: VALID_EMAIL)
	
		then: 'validation should pass'
		c.validate(["email"])
	}
	void "Test that email can be null"() {
		when: 'the email contains nothing'
		def c = new Commentator(email: null)
	
		then: 'validation should fail'
		c.validate(["email"])
	
		when: 'the email contains an email'
		c = new Commentator(email: VALID_EMAIL)
	
		then: 'validation should pass'
		c.validate(["email"])
	}
	void "Test that email is a valid email"() {
		when: 'the email is set to a random string'
		def c = new Commentator(email: INVALID_EMAIL)
	
		then: 'validation should fail'
		!c.validate(["email"])
	
		when: 'the email contains an email'
		c = new Commentator(email: VALID_EMAIL)
	
		then: 'validation should pass'
		c.validate(["email"])
	}
}
