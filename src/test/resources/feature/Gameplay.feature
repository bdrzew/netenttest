Feature: Gameplay

  This feature verifies behavior of slot machine during playtime

  Background:
    Given User goes to Slot Machine page

  Scenario: Cannot click spin button twice in single game
    When Spin button is clicked
    Then Spin button is disabled

  Scenario: Spin button is enabled when spin ends
    When Spin button is clicked
    And Spin is finished
    Then Spin button is enabled

  Scenario: Reel spin stop order is from 1 to 3
    When Spin button is clicked
    Then Reel "1" stops spinning before Reel "2"
    And Reel "2" stops spinning before Reel "3"

  Scenario: Win state layout
    When Slot Machine spin response returns prize number "41"
    Then Slot Machine is lighted up
    And Win Chart winning position "41" is lighted up

  Scenario: Win state LastWin
    When Slot Machine spin response returns Last Win "10"
    Then Last Win should be set to "10"

  Scenario: Win state Credits
    When Slot Machine spin response returns credits "10"
    Then Credits should be set to "10"
