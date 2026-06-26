# Prompt Iteration 02 - Refine Additional UI Scenario

## Goal
Refine the generated "Get a demo" UI scenario implementation so it uses stable assertions.

## Context provided
The first AI output suggested a scenario that clicks the "Get a demo" CTA from the Insider One header and verifies navigation to the demo request page.

The implementation needs refinement because:
- the URL assertion relied on assumed path fragments
- the page validation only checked that an h1 was not blank

Current project constraints:
- Java
- Selenium
- Cucumber
- AssertJ
- Page Object Model
- BasePage helper methods
- explicit waits
- no Thread.sleep

## Output evaluation

The AI generated `DemoRequestPageConstants.java`, `DemoRequestPage.java`, `DemoRequestPageSteps.java`, added the `clickGetDemoButton()` method to `HomePage.java`, and generated the required step definitions.

Most of the generated structure was accepted because it followed the existing project architecture and significantly reduced the amount of boilerplate code that needed to be written manually.

However, some parts were refined. The AI occasionally used Selenium's native `isDisplayed()` instead of the reusable `isDisplayed(WebElement element)` method already available in the project's `BasePage`. It also preferred defining some locators with `By` objects instead of the project's existing `@FindBy` and `PageFactory` pattern. These parts were updated to keep the implementation consistent with the rest of the framework.

## Iteration notes

In the next iteration, I asked the AI to fully align the generated code with the existing framework conventions by reusing helper methods from `BasePage`, defining page elements with `@FindBy`, and avoiding direct Selenium implementations when an equivalent reusable method already existed.