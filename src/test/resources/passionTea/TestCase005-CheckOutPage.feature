@all
Feature: PassionTea CheckOut Page
  As a customer, I want to view PassionTea checkout page, so that I know what PassionTea's check out is

  Background: PassionTea Check Out Page UI & Functional Testing

  Scenario Outline: Navigate to PassionTea's Check Out Page
    Given I open PassionTea checkout page URL
    When I fill in the customer form with '<Email>', '<Name>' and '<Address>'
    And I fill in the payment form with '<Card Type>', '<Card Number>', '<Cardholder Name>' and '<Verification Code>'
    Then I should go back to menu page

    Examples:
      | Email                         | Name     | Address       | Card Type        | Card Number | Cardholder Name | Verification Code |
      | di.zhang@assurity.co.nz       | Di Zhang | Lower Hutt    | Visa             | 1234567890  | Di Zhang        | v56ae46f1a6       |
      | yuwen.ji@barclays.com         | Yuwen Ji | Auckland      | Mastercard       | 1234567890  | Yuwen Ji        | 56v1a5e           |
      | di.li@standardchartered.co.hk | Di Li    | Tiwari Street | American Express | 1234567890  | Di Li           | fa513fa1          |
      | bei.pei@sap.cn                | Bei Pei  | Brisbane      | Diners Club      | 1234567890  | Bei Pei         | 56asdf81a         |
