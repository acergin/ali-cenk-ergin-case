@ui
Feature: Insider One UI

  Scenario: Verify Insider One home page
    Given User is on the Insider One home page
    Then Insider home page should be displayed
    And Verify header is displayed
    And Verify all home page sections are displayed
    And Verify footer is displayed

  Scenario: Verify Quality Assurance Jobs
    Given User is on the Insider One Open Roles page
    And Click on See All Teams button on Open Roles page
    When Click on Quality Assurance button on Open Roles page
    Then Verify QA Jobs List is displayed
    And Verify all jobs' department is "Quality Assurance"
    When Open first job and click on Apply For This Job button
    Then Verify user is redirected to Lever Application form page

  Scenario: Verify Get a demo CTA navigates to demo request page (AI-Augmented)
    Given User is on the Insider One home page
    When User clicks on Get a demo in the header
    Then Demo request page should be displayed