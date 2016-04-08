@all
Feature: PassionTea Menu Page
  As a customer, I want to view PassionTea menu page, so that I know what PassionTea's menu is

  Background: PassionTea Menu Page UI & Functional Testing

  Scenario: Navigate to PassionTea's Menu Page
    Given I open PassionTea menu page URL
    And I check out "Oolong Tea"
    Then I should land at check out page
