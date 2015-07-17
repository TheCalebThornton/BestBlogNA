require 'rspec'

Given (/^I visit the blog for my favorite blogger$/) do
  go_to_blog_home
  go_to_blog
end

When (/^I choose a blog post$/) do
  go_to_post
end

Then (/^I should see the blog post$/) do
  expect(get_post_title).to eq('post1')
end
