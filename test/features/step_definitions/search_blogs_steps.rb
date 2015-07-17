require "watir-webdriver"

When /^I search for a blog post$/ do
  on_page BlogPage do |page|
    page.searchPosts('free stuff')
  end
end

Then /^I should see posts with that value in the title$/ do
  on_page BlogPage do |page|
    expect(page.postTitles).to include('free stuff')
  end
end
