require 'page-object'
require 'watir-webdriver'
include PageObject::PageFactory

def get_post_title
    @browser.ol(:class, 'property-list').li(:index, 0).span(:index, 1).text
end

def go_to_blog
  on_page HomePage do |page|
    page.click_blog
  end
end

def go_to_blog_home
  visit_page HomePage
end

def go_to_post
  on_page BlogPage do |page|
    page.click_post
  end
end

def add_comment
  on_page PostPage do |page|
    page.submit
  end
end

def write_comment
  on_page PostPage do |page|
    page.type_comment
  end
end

def comment_text
  on_page PostPage do |page|
    page.get_comment
  end
end

def get_browser_url
  return @browser.url
end

def publish_post
  on_page BlogPage do |page|
    page.create_post
  end

  on_page NewPostPage do |page|
    page.post_title = "post1"
    page.post_content = "Some basic post content"
    page.submit
  end
end

def post_created?
  @browser.text.include?('created')
end

def go_to_post_list
  on_page PostSuccessPage do |page|
    page.click_post_list
  end
end

def get_first_post_title
  @browser.tr(:index, 1).td.text
end