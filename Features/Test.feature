Feature: Login

  Scenario Outline: Checking login
    Given Launching browser
    When Opening URL "<url>"
    And Enter "<username>" click continue and enter "<password>"
    Then Pagetitle "<title>" should be verified
    And close browser
    
    Examples:
    
    | url | username | password |
  | |  |  |