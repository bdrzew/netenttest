Feature: Slot Machine Witcher

  This feaature verifies behavior of slot machine when customization options are triggered

  Background:
    Given User goes to Slot Machine page

  Scenario Outline: Customize Background
    When Change Background button is clicked "<number>" time(s) in customization bar
    Then Background image is changed to "<background_number>"

    Examples:
    | number | background_number |
    | 1      | 2                 |
    | 2      | 3                 |
    | 3      | 4                 |
    | 4      | 1                 |

  Scenario Outline: Customize Icons
    When Change Icons button is clicked "<number>" time(s) in customization bar
    Then Reel prize icons are changed to "<icon_number>" in Win Chart
    And Reel icons are changed to "<icon_number>" in Slot Machine

    Examples:
    | number | icon_number |
    | 1      | 2           |
    | 2      | 3           |
    | 3      | 1           |

  Scenario Outline: Change Machine
    When Change Machine button is clicked "<number>" time(s) in customization bar
    Then Slot Machine is changed to "<machine_number>"
    And Win Chart is changed to Machines "<machine_number>"

    Examples:
    | number | machine_number |
    | 1      | 2              |
    | 2      | 3              |
    | 3      | 4              |
    | 4      | 5              |
    | 5      | 1              |

