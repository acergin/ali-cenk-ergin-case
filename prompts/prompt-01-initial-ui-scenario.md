# Prompt Iteration 01 - Generate Additional UI Scenario

## Goal
Generate one additional Selenium + Cucumber UI test scenario for the Insider One website.

## Context provided
The project uses Java, Selenium, Cucumber, Page Object Model, and AssertJ.

The existing UI tests already cover the Insider Careers / QA jobs flow. The new scenario should target the same Insider One site but should not duplicate the existing scenario.

The implementation should follow the current framework structure:
- Page Object Model
- reusable page methods
- explicit waits
- no Thread.sleep
- no direct driver usage inside step definitions

## Prompt
Generate one additional Selenium + Cucumber UI test scenario for https://insiderone.com/.

The project uses Java, Selenium, Cucumber, Page Object Model, and AssertJ.

Please suggest:
- a Gherkin scenario
- required page methods
- step definitions

Avoid Thread.sleep and use explicit waits.

## Output evaluation
The AI suggested a scenario that verifies the "Get a demo" CTA in the header navigates to the demo request page.

I accepted the scenario idea because it covers a meaningful user journey and does not duplicate the existing Careers / QA jobs scenario.

I did not accept the generated implementation as-is. The generated URL validation also relied on assumed path fragments, so I manually verified the actual navigation behavior before finalizing the assertion.

I also adjusted the generated code to match the actual project structure, package names, existing BasePage methods, and Page Object conventions.

## Iteration notes
In the next iteration, I will ask the AI to refine the implementation using verified URL behavior, and stronger page validation.