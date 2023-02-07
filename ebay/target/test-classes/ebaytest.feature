#Author: Himanicherry@gmail.com
# Himani Aggarwal
#Automation and Validation engineer
@Execute
Feature: search access feature
 
  Scenario: access a product via search
    Given Go to www.ebay.com
    And Type any search string in the search bar
    Then Change the Search category
    And click Search
    And Verify that the page loads completely
    Then Verify that the first result name matches with the search string
    
  Scenario: access a product via category
    Given Go to www.ebay.com
    And navigate to search by category and electronics
    Then click cellphone and smart phone
    And cclick on see all
    And check fillters
    Then apply filters
      
    
