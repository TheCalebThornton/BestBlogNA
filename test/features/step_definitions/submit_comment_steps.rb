require "watir-webdriver"
require 'rspec'


Given (/^I am reading a blog post from my favorite blogger$/) do
  go_to_blog_home
  go_to_blog
  go_to_post
end

When /^I add my genius comment to the blog post$/ do
  write_comment
  add_comment
end

Then /^my genius comment is at the top of the blog post comments$/ do
  expect(comment_text).to be eq("test comment")
end