@All
Feature: PassionTea Menu Page
  As a customer, I want to view PassionTea menu page, so that I know what PassionTea's menu is

  Background: PassionTea Menu Page UI & Functional Testing
    Given I open PassionTea menu page URL

  @Checkout
  Scenario: Check out Green Tea
    And I check out "Green Tea"
    Then I should land at check out page

  @Checkout
  Scenario: Check out Red Tea
    And I check out "Red Tea"
    Then I should land at check out page

  @Checkout
  Scenario: Check out Oolong Tea
    And I check out "Oolong Tea"
    Then I should land at check out page
