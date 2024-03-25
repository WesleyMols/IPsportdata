Feature: a user can interact with the Ramptest page
Background:
    Given Jack is on the ramptest page
    


Scenario Outline: Jack can fill in the input fields
    When Jack submits his data <x>, <y>
    Then the data should be stored
Examples:
    | x | y |
    | 20| 100|
    |30| 150|

Scenario Outline: Jack submits his data and gets a plot
    When Jack submits his data <x>, <y>
    And a plot is generated
    Then it is shown in desktop
Examples:
    | x | y |
    | 20| 100|
    |30| 150|