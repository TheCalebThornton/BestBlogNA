package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CommentController)
@Mock([Post, Comment, Commentator])
class CommentControllerSpec extends Specification {

    def setup() {
		Post pMock = new Post(postName: 'Personal Post',
			postContent: 'Stufferes', teaser: 'Teaser OP',
			isPublished: false, lastUpdated: null,
			comments: null)
		pMock.save()
    }

    def cleanup() {
    }

    void "test edit"() {
		when:"Edit function is called"
		controller.params.id = 1
		controller.edit()
		System.out.println(view.toString() + model.toString())
		
		then:"View edit page with the selected comment"
		view.toString() == '/comment/edit'
		model.toString() == '[comment:best.blog.Comment : (unsaved), postId:1]'
    }
	void "test save"() {
		when:"Save function is called with invalid params"
		def commentList = [];
		Post p2Mock = new Post(postName: 'Personal Post',
			postContent: 'Stufferes', teaser: 'Teaser OP',
			isPublished: false, lastUpdated: null,
			comments: commentList)
		p2Mock.save()
		Comment failMock = new Comment(commentContent: '',
			dateCreated: new Date(), post: p2Mock,
			who: null)
		failMock.save()
		commentList.add(failMock);
		controller.params.id = failMock.id
		controller.params.commentContent = failMock.commentContent
		controller.params.dateCreated = failMock.dateCreated
		controller.params.post = failMock.post
		controller.save();
	
		then:"save fails and view remians on comment edit"
		view.toString() == '/comment/edit'

		when:"save function is called with valid params"
		commentList.clear();
		p2Mock = new Post(postName: 'Personal Post',
			postContent: 'Stufferes', teaser: 'Teaser OP',
			isPublished: false, lastUpdated: null,
			comments: commentList)
		p2Mock.save()
		Commentator authorMock = new Commentator(email: 'gg@wp.com',
			name: 'DR. Who', url: 'https://www.google.com/')
		authorMock.save()
		Comment passMock = new Comment(commentContent: 'There is valid content now',
			dateCreated: new Date(), post: p2Mock,
			who: authorMock)
		passMock.save()
		//commentList.add(passMock);
		System.out.println("Size of list: "+commentList.size().toString())
		controller.params.id = passMock.id
		controller.params.commentContent = passMock.commentContent
		controller.params.dateCreated = passMock.dateCreated
		controller.params.post = passMock.post
		controller.save();
		
		then:"save succeeds and view changes to list page"
		response.redirectedUrl == '/post/view'
	}
}
