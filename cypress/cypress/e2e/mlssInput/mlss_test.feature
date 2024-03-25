Feature: input data into input fields for mlss analysis

Scenario: user input data into input fields for mlss analysis
    Given on mlss page
    When Jack sumbits MLSS data: "<name>", <power>, <weight>, <lactateone>, <lactatetwo>
    Then Message should have text "<message>"

Examples:
    | name | power | weight | lactateone | lactatetwo | message |
    | wes  | 300   | 60 | 3.0 | 3.2 | Please input next measurement |
    | wes  | 320   | 60 | 3.5 | 3.7 | Please input next measurement |
    | wes  | 340   | 60 | 4.0 | 6.2 | Your MLSS power lies between : 320 watt and 340 watt. With an average of 330watt, or 5,5 watt/kg |