@all
Feature: PassionTea TalkTeaPage Page
  As a customer, I want to view PassionTea menu page, so that I know what PassionTea's menu is

  Background: PassionTea Menu Page UI & Functional Testing

  Scenario Outline: Navigate to PassionTea's Menu Page
    Given I open PassionTea talk-to-tea page URL
    When I fill in the form with '<Name>', '<Email>', '<Subject>', '<Message>' and submit
    Then I should see successful message

    Examples:
      | Name   | Email                    | Subject     | Message        |
      | Di     | di.zhang@assurity.co.nz  | Test        | Hello, Test    |
      | Ye     | ye.wen@assurity.co.nz    | Rest        | Yello, Test    |
      | Alexis | yaqi.li@assurity.co.nz   | Labu Letter | Hi, My man     |
      | Yaqi   | jacob.jay@assurity.co.nz | Yaqi Jacob  | It smells good |
