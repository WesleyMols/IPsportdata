Feature: navigation to about page
When a user is on the website, page should not matter,
 then navigation to the about page via the navigation bar should be possible.

Scenario: Successful navigation to about page
    Given Jack is on a "<page>"
    When Jack navigates to the about page
    Then the about page should be loaded
Examples:
    |page|
    | / |
    | http://localhost:5173/Ramptest |