require "watir-webdriver"

Given /^I am logged in as (.*)$/ do |active_user|
	go_to_blog_home
  go_to_blog
end

When /^I publish a new blog post$/ do 
	publish_post
end

Then /^I am notified that the blog post was successfully added$/ do
		expect(post_created?).to be true
end

And /^the newly added blog post is at the top of the recent posts list$/ do
	go_to_post_list
  expect(get_first_post_title).to eq("post1")
end