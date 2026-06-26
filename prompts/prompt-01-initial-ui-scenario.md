# Prompt Iteration 01

## Goal
Generate one additional UI test scenario for the Insider website.

## Context provided
- Java
- Selenium
- Cucumber
- AssertJ
- Page Object Model
- Existing scenario already verifies QA job listings.

## Prompt

Generate one additional UI automation scenario for https://useinsider.com/.
Do not repeat the existing QA jobs scenario.
The scenario should be meaningful, stable and suitable for Selenium automation.
Provide only the scenario idea without implementation.

## Output evaluation

The AI suggested verifying the "Platform Tour" page opened successfully after clicking the Platform Tour button in the header.

I accepted this scenario because:
- it validates another important user journey
- it is independent from the existing Careers flow
- it is unlikely to become flaky

## Iteration notes

Next prompt will ask for implementation using the existing Page Object framework.