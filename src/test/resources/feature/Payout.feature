Feature: Payout

  This feature validates how payout is calculated and displayed

  Background:
    Given User goes to Slot Machine page

  Scenario: Win Chart initial payout
    Then Every payout in Win Chart is equal to base payout multiplied by "1"
    And  Bet ratio displayed in Bet Container is equal to "1"

  Scenario: Bet is increased
    When Bet Spin Up is clicked "1" time(s)
    Then Every payout in Win Chart is equal to base payout multiplied by "2"
    And Bet ratio displayed in Bet Container is equal to "2"

  Scenario: Bet is decreased
    Given Bet Spin Up is clicked "3" time(s)
    When Bet Spin Down is clicked "1" time(s)
    Then Every payout in Win Chart is equal to base payout multiplied by "3"
    And Bet ratio displayed in Bet Container is equal to "3"

  Scenario: Bet is decreased when already set to 1
    When Bet Spin Down is clicked "1" time(s)
    Then Every payout in Win Chart is equal to base payout multiplied by "1"
    And Bet ratio displayed in Bet Container is equal to "1"