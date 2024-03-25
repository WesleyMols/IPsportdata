Feature: visit ramptest page from navbar

Scenario: Jack can visit the ramptest page
    Given Jack is on a "<page>"
    When Jack navigates to the ramptest page
    Then the ramptest page should be loaded
Examples:
    |page|
    | / |
    | http://localhost:5173/About |