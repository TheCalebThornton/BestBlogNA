require 'page-object'

class PostSuccessPage
  include PageObject

  page_url 'http://localhost:8080/grails-blog/post/show/#{number}'

  link(:click_post_list, :text => "Post List")

end