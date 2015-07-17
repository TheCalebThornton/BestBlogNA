require 'page-object'

class BlogPage
  include PageObject

  link(:click_post, :text => "post1")
  link(:create_post, :text => "New Post")



 # OLD prefedined things
  links(:post_links, :class => 'postLink')
  text_field(:search_field, :class => 'search')
  button(:search_btn, :class => 'searchButton')
  h2(:postTitles, :class => 'postTitles')
  #button(:create_post, :id=> 'create_post')
  div(:posts, :class => 'posts')

  def goToBlogger (blogger)
    visit_page 'http://localhost:8080/grails-blog/' + blogger
  end

  def searchPosts (search)
    search_field.value = search
    clickSearch
  end
  def clickSearch
    search_btn.click()
  end

  def postsOrdered
    dates = getPostDates
    compareDates(dates)
  end
  def getPostDates
    dates = []
    post_links.each do |i|
      dates[i] = getDate(links[i])
    end
    return dates
  end
  def getDate (link)
    date = link.html.scan("\d{2}/\d{2}/\d{4}")
  end
  def compareDates (dates)
    valid = false
    dates.each do |i=1|
      valid = (dates[i].jd < dates[i-1].jd)
    end
    return valid
  end
end
