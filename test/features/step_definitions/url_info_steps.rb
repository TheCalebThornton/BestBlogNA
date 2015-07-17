require 'rspec'

Then /^the url should contain information about the post$/ do
  expect(get_browser_url).to be eq("http://localhost:8080/grails-blog/user/post1")
  end
