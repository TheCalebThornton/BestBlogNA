class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		//"/post/view/$postName?" (controller:"post", action:"view")
		"/post/$postName" {
			controller="post"
			action = "view"
		}
        "/"(controller:'post', action:'/list')
		 "/"(controller:'post')
        "500"(view:'/error')
	}
}
