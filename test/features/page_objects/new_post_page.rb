require 'page-object'

class NewPostPage
  include PageObject

  text_field(:post_title, :id => 'postName')
  text_field(:post_content, :id => 'postContent')
  button(:submit, :id => 'create')

end