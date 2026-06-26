QA Automation Case Study

Project Description

This repository contains my solution for the Insider QA Automation Case Study.

The solution consists of three independent parts:

* UI Automation using Selenium, Cucumber, and the Page Object Model
* API Automation using Rest Assured against the Swagger Petstore API
* Load Testing using Locust for the n11.com search functionality

The project was designed with maintainability, readability, and reusability in mind. Common functionality is extracted into reusable helper classes, while UI and API layers are separated to keep responsibilities clear.

⸻

Technologies

* Java 24
* Maven
* Selenium WebDriver
* Cucumber
* JUnit 4
* AssertJ
* Rest Assured
* Jackson
* Python 3
* Locust

⸻

Prerequisites

Before running the project, make sure the following tools are installed:

* Java 24
* Maven
* Google Chrome
* Python 3 (required only for the Load Test section)

⸻

Setup

Clone the repository and install the Maven dependencies.

mvn clean install

For the Load Test, install Locust:

python3 -m pip install locust

⸻

Running the Tests

Run all UI and API tests

mvn test

or

mvn install

Run the Load Test

Navigate to the load-tests directory and execute:

python3 -m locust -f locustfile.py

Then open:

http://localhost:8089

Recommended configuration:

* Host: https://www.n11.com
* Number of Users: 1
* Ramp up: 1

⸻

Project Structure

## Project Structure

```text
.
├── src
│   └── test
│       ├── java
│       │   ├── api
│       │   │   ├── clients
│       │   │   ├── models
│       │   │   └── payloads
│       │   ├── constants
│       │   ├── hooks
│       │   ├── pages
│       │   ├── runners
│       │   ├── stepdefinitions
│       │   └── utils
│       │
│       └── resources
│           └── features
│               ├── ui.feature
│               └── api.feature
│
├── load-tests
│   └── locustfile.py
│
├── prompts
│   ├── prompt-01-generate-ui-scenario.md
│   ├── prompt-02-refine-ui-scenario.md
│   ├── prompt-03-final-review.md
│   ├── api-prompt-01-crud-structure.md
│   └── loadtest-prompt-01-locust.md
│
├── AI_USAGE.md
├── README.md
└── pom.xml
```

⸻

Project Notes

UI Automation

The UI framework follows the Page Object Model (POM). Browser interactions are encapsulated inside page classes, while synchronization is handled using reusable explicit wait methods instead of Thread.sleep().

UI and API executions are separated using tagged hooks, preventing unnecessary browser initialization during API execution.

The QA jobs count on the Careers page is loaded asynchronously. The test waits until the displayed open jobs count becomes greater than zero before clicking the QA jobs CTA.

⸻

API Automation

CRUD scenarios were implemented for the Swagger Pet endpoints.

The API layer is separated into:

* API Client
* Model classes
* Payload Builder
* Step Definitions

This structure keeps the implementation modular and easy to extend.

⸻

Load Testing

The load test was implemented using Locust.

The test simulates a user performing a product search on n11.com by sending a request to the search endpoint.

During execution, the public website may respond with HTTP 403 Forbidden due to anti-bot/CDN protection. The search endpoint and request flow were manually verified using browser developer tools before implementing the Locust scenario.

The script therefore represents the intended load test flow even if execution is limited by the target website’s protection mechanisms.

⸻

AI Usage

AI coding assistants were used as development assistants throughout this project.

AI was primarily used for:

* generating additional UI test ideas
* generating an initial API project structure
* generating boilerplate code
* learning and implementing the initial Locust structure

All generated code was manually reviewed before being committed.

Suggestions that introduced brittle locators, duplicated existing helper methods, conflicted with the existing framework conventions, or reduced maintainability were either rejected or refined manually.

The complete prompt history, evaluations, and refinements are available under the prompts/ directory.

Additional reflections regarding AI collaboration can be found in AI_USAGE.md.