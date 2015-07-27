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
		Post p2Mock = new Post(postName: 'Personal Post',
			postContent: 'Stufferes', teaser: 'Teaser OP',
			isPublished: false, lastUpdated: null)
		p2Mock.save()
		Comment failMock = new Comment(commentContent: '',
			post: p2Mock, who: null)
		failMock.save()
		p2Mock.addToComments(failMock)
		controller.params.id = failMock.id
		controller.params.commentContent = failMock.commentContent
		controller.params.dateCreated = failMock.dateCreated
		controller.params.post = failMock.post
		controller.params.who = failMock.who
		controller.save();
	
		then:"save fails and view remians on comment edit"
		view.toString() == '/comment/edit'

		when:"save function is called with valid params"
		if(!p2Mock.save()){
			println(p2Mock.errors)
		}
		Commentator authorMock = new Commentator(email: 'gg@wp.com',
			name: 'Bloo', url: 'https://www.google.com/')
		authorMock.save()
		Comment passMock = new Comment(commentContent: 'There is valid content now',
			post: p2Mock, who: authorMock)
		passMock.save()
		p2Mock.addToComments(passMock)
		controller.params.id = passMock.id
		controller.params.commentContent = passMock.commentContent
		controller.params.dateCreated = passMock.dateCreated
		controller.params.postId = passMock.post.id
		controller.params.who = passMock.who
		controller.save();
		then:"save succeeds and view changes to list page"
		response.redirectedUrl.contains('/post/view/')
	}
	void "test delete"() {
		given:"A comment is added"
		Post p2Mock = new Post(postName: 'Personal Post',
			postContent: 'Stufferes', teaser: 'Teaser OP',
			isPublished: false, lastUpdated: null)
		p2Mock.save()
		Commentator authorMock = new Commentator(email: 'gg@wp.com',
			name: 'Bloo', url: 'https://www.google.com/')
		authorMock.save()
		Comment deleteMock = new Comment(commentContent: 'There is valid content now',
			post: p2Mock, who: authorMock)
		deleteMock.save()
		when:"delete function is called"
		controller.params.id = deleteMock.id
		controller.params.postId = deleteMock.post.id
		controller.delete();
	
		then:"Post object should be deleted from database"
		response.redirectedUrl.contains('/post/view')
	}
}
