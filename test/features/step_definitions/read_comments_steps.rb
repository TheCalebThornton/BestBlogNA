require "watir-webdriver"


Then /^I should see comments left by other readers$/ do
  on_page PostPage do |page|
    expect(page.commentsExist?).to be_true
  end
end