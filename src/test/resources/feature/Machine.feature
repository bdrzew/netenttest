Feature: Machines

  This feature verifies machines specific setting

  Background:
    Given User goes to Slot Machine page

  Scenario: Slot Machine 1 display
    When Slot Machine "1" is displayed
    Then Bet Container displays
     | LAST WIN | TOTAL SPINS | BET | BETSPIN UP | BETSPIN DOWN |
    And Win Chart has "9" combinations displayed

  Scenario: Slot Machine 2 display
    When Slot Machine "2" is displayed
    Then Bet Container displays
      | LAST WIN | TOTAL SPINS | BET | BETSPIN UP | BETSPIN DOWN |
    And Win Chart has "6" combinations displayed

  Scenario: Slot Machine 3 display
    When Slot Machine "3" is displayed
    Then Bet Container displays
      | DAY WINS | LIFETIME WINS | LAST WIN | TOTAL SPINS | BET | BETSPIN UP | BETSPIN DOWN |
    And Win Chart has "8" combinations displayed

  Scenario: Slot Machine 4 display
    When Slot Machine "4" is displayed
    Then Bet Container displays
      | LAST WIN | TOTAL SPINS | BET | BETSPIN UP | BETSPIN DOWN |
    And Win Chart has "8" combinations displayed

  Scenario: Slot Machine 5 display
    When Slot Machine "5" is displayed
    Then Bet Container displays
      | LAST WIN | TOTAL SPINS | BET | BETSPIN UP | BETSPIN DOWN |
    And Win Chart has "10" combinations displayed