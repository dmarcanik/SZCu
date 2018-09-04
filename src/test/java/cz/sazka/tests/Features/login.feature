Feature: Test

  Scenario: Place wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "euromiliony" wager with "7" numbers, "4" winning and "1" extra numbers set to "lose"

  Scenario: Place wager2
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "euromiliony" wager with "7" numbers, "4" winning and "1" extra numbers set to "lose"

