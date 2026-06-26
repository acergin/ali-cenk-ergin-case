@api
Feature: Pet API CRUD operations

  Scenario: Create a pet successfully
    When User creates a pet with valid data
    Then Pet API response status code should be 200
    And Created pet response should contain correct pet data

  Scenario: Get an existing pet successfully
    Given User has created a pet
    When User gets the pet by id
    Then Pet API response status code should be 200
    And Pet response should contain correct pet id

  Scenario: Update an existing pet successfully
    Given User has created a pet
    When User updates the pet name and status
    Then Pet API response status code should be 200
    And Pet response should contain updated pet data

  Scenario: Delete an existing pet successfully
    Given User has created a pet
    When User deletes the pet by id
    Then Pet API response status code should be 200
    And Deleted pet should not be found

  Scenario Outline: Get pet with invalid id
    When User gets pet with id "<petId>"
    Then Pet API response status code should be <statusCode>

    Examples:
      | petId       | statusCode |
      | -1          | 404        |
      | 99999999999 | 404        |
      | abc         | 404        |

  Scenario Outline: Create pet with different payload values
    When User creates a pet with raw id '<id>', name "<name>" and status "<status>"
    Then Pet API response status code should be <statusCode>

    Examples:
      | id           | name       | status     | statusCode |
      | 123456       | QA Dog     | available  | 200        |
      | 123457       |            | available  | 200        |
      | 123458       | QA Dog     | invalid    | 200        |
      | "invalid-id" | QA Dog     | available  | 500        |