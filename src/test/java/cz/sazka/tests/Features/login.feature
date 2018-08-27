Feature: Test

  Scenario: Place wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "5" column "eurojackpot" ticket with "5" numbers, "3" winning and "2" extra numbers set to "lose"

  