Feature: input data into input fields for mlss analysis

Scenario: user input data into input fields for mlss analysis
    Given on mlss page
    When user types "<name>" and <power>
    Then Message should have text "<message>"

Examples:
    | name | power | message |
    | wes  | 300     | Please input next measurement |
    | wes  | 320     | Please input next measurement |