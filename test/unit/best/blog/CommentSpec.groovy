package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Comment)
class CommentSpec extends Specification {

	
	void 'test valid command object'(){
		given:
		def comment = new Comment(name: 'Hugh')
		simpleCommand.validate()
		
		when:
		controller.handleCommand(simpleCommand)
		
		then:
		response.text =='Good'
	}
	
	
	
	
    void 'testing invalid Comment'() {
		given:
		def simpleCommand = new simpleCommand(name: '')
		simpleCommand.validate()
		
		when:
		controller.handleCommand(simpleCommand)
		
		then:
		response.text == 'Bad'
		
		
			}
}
}
