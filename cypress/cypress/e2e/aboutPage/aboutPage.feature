Feature: navigation to about page

Scenario: Successful navigation to about page
    Given I am on the home page
    When I click on about button in navigationbar
    Then I should be redirected to the about page