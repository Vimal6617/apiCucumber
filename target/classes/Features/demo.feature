@ringcentral
Feature: Automating Ring Central Api Test

  Scenario Outline: Api Automation for Get ALL Users
    Given api endpoint for "userApi"
    And set Query Param for "page" as "<pagevalue>"
    And set Query Param for "size" as "<sizevalue>"
    And set Query Param for "sort" as "<sortvalue>"
    When method is "get"
    Then validate status code "<statusCode>"
    Then validate result for size as "<sizevalue>"
    Then validate result for Totalpage as "<pagevalue>" where size is "<sizevalue>"
    Examples:
      | pagevalue | sizevalue | sortvalue  | statusCode |
      | 1         | 10         | firstName,asc | 200        |
      | 2         | 5          | lasttName,asc | 200        |
      | 3         | 4          | firstName,desc | 200        |


  Scenario: Get Detail for any User
    Given api endpoint for "userApi"
    When method is "get"
    Then Save user Details
    And Validate user Field Details
    Then validate status code "200"

  Scenario: Get Detail for a particular User
    Given api endpoint for "userApi"
    And Add endpoint "/id"
    When method is "get"
    Then validate status code "200"
    Then validate user Details

  Scenario: Delete Particular User
    Given api endpoint for "userApi"
    And Add endpoint "/id"
    When method is "delete"
    Then validate status code "204"

  Scenario: Validate Deleted User
    Given api endpoint for "userApi"
    And Add endpoint "/id"
    When method is "get"
    Then validate status code "404"
