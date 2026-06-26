# Prompt Iteration 01 - API CRUD Structure

## Goal
Generate a clean structure for API CRUD tests using Rest Assured within the existing Java test automation framework.

## Context provided
The project already contains:
- Java
- Selenium
- Cucumber
- AssertJ
- Page Object Model for UI tests

The API tests should be added to the same project using Rest Assured. The target API is the Pet endpoints of the Swagger Petstore. The solution should support CRUD operations and keep the code modular and maintainable.

## Prompt
Suggest a clean project structure for implementing CRUD API tests using Rest Assured. We will use PET endpoint from https://petstore.swagger.io/

Generate:
- API client class
- payload builder
- model classes

The implementation should be reusable and easy to extend.

## Output evaluation
The generated project structure was accepted as a starting point. The AI suggested separating responsibilities into API client, model classes, and payload builder, which improved readability and maintainability.

However, the generated code was refined before being committed. The payload generation was adjusted to better fit the Pet API, model classes were simplified, and the client methods were aligned with the project's coding style and assertion approach.

## Iteration notes
The generated code served as a starting point. The final implementation was manually reviewed, adapted to the project conventions, and validated by executing the CRUD scenarios successfully.