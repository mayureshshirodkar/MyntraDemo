Feature: Login

  Scenario: Landing page title
    Given   user is on landing page
    When    user gets title of page
    Then    page title should be ""