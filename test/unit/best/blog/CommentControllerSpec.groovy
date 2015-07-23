package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CommentController)
class CommentControllerSpec extends Specification {

    def setup() {
		
//		Commentator authorMock = new Commentator(email: 'gg@wp.com',
//			name: 'DR. Who', url: 'https://www.google.com/')	
//		authorMock.save()
//		Comment cMock = new Comment(commentContent: 'This is a test comment',
//			dateCreated: new Date(), who: authorMock)
//		cMock.save()
//		def commentsList = [cMock]
//		Post pMock = new Post(postName: 'Personal Post',
//			postContent: 'Stufferes', teaser: 'Teaser OP',
//			isPublished: false, lastUpdated: null,
//			comments: commentsList)
//		pMock.save()
    }

    def cleanup() {
    }

    void "test edit"() {
		when:"Edit function is called"
		CommentController.edit()
		System.out.println(view.toString() + model.toString())
		
		then:"View changes to edit page"
//		view.toString() == '/post/edit'
//		model.toString() == '[post:best.blog.Post : (unsaved)]'
    }
}
