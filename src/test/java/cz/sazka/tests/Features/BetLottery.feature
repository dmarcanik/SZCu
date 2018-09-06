Feature: Test

  Scenario: Do Euromiliony bet
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "euromiliony" wager with "7" numbers, "4" winning and "1" extra numbers set to "lose"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then Logout user

  Scenario: Do Eurojackpot bet
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "eurojackpot" wager with "5" numbers, "2" winning and "2" extra numbers set to "win"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then Logout user
  Scenario: Do Sportka bet
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "sportka" wager with "6" numbers, "5" winning and "0" extra numbers set to "none"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then Logout user