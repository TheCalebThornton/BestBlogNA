package best.blog

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PostController)
@Mock([Post])
class PostControllerSpec extends Specification {


	
    def setup() {
		Post pMock = new Post(postName: 'Personal Post', 
							postContent: 'Stufferes', teaser: 'Teaser OP', 
							isPublished: false, lastUpdated: null, 
							comments: null)
		
		Post p2Mock = new Post(postName: 'Personal Post',
							postContent: 'Stufferes', teaser: 'Teaser OP',
							isPublished: false, lastUpdated: null,
							comments: null)

		pMock.save()
		p2Mock.save()
    }

    def cleanup() {
		
    }

    void "test edit"() {
		when:"Edit function is called"
		controller.edit()
	
		then:"View changes to edit page"
		view.toString() == '/post/edit'
		model.toString() == '[post:best.blog.Post : (unsaved)]'
    }
	//Considering not using postList function
//	void "test postList"() {
//		when:"postList function is called"
//		System.out.println (params.toString())
//	
//		then:"View changes to edit page"
//
//	}
	void "test list"() {
		when:"list function is called"
		controller.list();
	
		then:"View changes to list page"
		view.toString() == '/post/list'
		model.toString() == '[posts:[best.blog.Post : 1, best.blog.Post : 2], postCount:2, offset:0]'
	}
	void "test save"() {
		when:"save function is called with invalid params"
		Post failMock = new Post(postName: 'Personal Post',
			postContent: '', teaser: 'failure',
			isPublished: false, lastUpdated: null,
			comments: null)
		failMock.save()
		controller.params.id = failMock.id
		controller.params.postName = failMock.postName
		controller.params.postContent = failMock.postContent
		controller.params.teaser = failMock.teaser
		controller.params.isPublished = failMock.isPublished
		controller.params.lastUpdated = failMock.lastUpdated
		controller.params.comments = failMock.comments
		controller.save();
	
		then:"save fails and view remians on post edit"
		view.toString() == '/post/edit'

		when:"save function is called with valid params"
		Post passMock = new Post(postName: 'Passing Post',
			postContent: 'passing content', teaser: 'pass',
			isPublished: false, lastUpdated: null,
			comments: null)
		passMock.save()
		controller.params.id = passMock.id
		controller.params.postName = passMock.postName
		controller.params.postContent = passMock.postContent
		controller.params.teaser = passMock.teaser
		controller.params.isPublished = passMock.isPublished
		controller.params.lastUpdated = passMock.lastUpdated
		controller.params.comments = passMock.comments
		
		controller.save()
	
		then:"save succeeds and view changes to list page"
		response.redirectedUrl == '/post/list'

	}
	void "test view"() {
		when:"view function is called"
		controller.params.id = 1
		controller.view();
	
		then:"View changes to view page based on id param"	
		view.toString() == '/post/view'
		model.toString() == '[post:best.blog.Post : 1]'
	}
	void "test delete"() {
		given:"A post is added"
		Post deleteMock = new Post(postName: 'Passing Post',
			postContent: 'passing content', teaser: 'pass',
			isPublished: false, lastUpdated: null,
			comments: null)
		deleteMock.save()
		when:"delete function is called"
		controller.params.id = deleteMock.id
		controller.delete();
	
		then:"Post object should be deleted from database"
		response.redirectedUrl == '/post/list'
		deleteMock.id == null
	}
	
	
}
