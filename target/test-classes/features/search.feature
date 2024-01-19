Feature: Argos web
  Background:
    Given user go to argos website
    Then user accept cookies

  @Smoke
  Scenario Outline: Verify Nike product on argos web
    And user enter "<product>" product on search box
    When user click on search button
    Then user must see all "<product>"
    Examples:
      | product |
      | nike    |
      | bags    |



