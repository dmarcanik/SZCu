Feature: Test

  Scenario: Place wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "2" column "eurojackpot" ticket with "6" numbers and "3" winning
