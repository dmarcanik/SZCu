Feature: Test

  Scenario: Create Euromiliony wager 1 column 4 wining
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "euromiliony" wager with "7" numbers, "4" winning and "1" extra numbers set to "lose"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved

  Scenario: Do Euromiliony wager 2 columns 2 wining
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "euromiliony" wager with "7" numbers, "2" winning and "1" extra numbers set to "lose"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved

  Scenario: Do Euromiliony wager 5 columns 0 wining
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "1" column "euromiliony" wager with "7" numbers, "0" winning and "1" extra numbers set to "lose"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved

  Scenario: Do Eurojackpot wager 4 columns 5 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "4" column "eurojackpot" wager with "5" numbers, "2" winning and "2" extra numbers set to "win"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved


  Scenario: Do Eurojackpot wager 2 columns 0 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "2" column "eurojackpot" wager with "5" numbers, "0" winning and "2" extra numbers set to "win"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved


  Scenario: Do Sportka wager 4 columns 6 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "4" column "sportka" wager with "6" numbers, "6" winning and "0" extra numbers set to "none"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved

  Scenario: Do Eurojackpot wager 4 columns 5 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "4" column "eurojackpot" wager with "5" numbers, "2" winning and "2" extra numbers set to "win"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved


  Scenario: Do Eurojackpot wager 2 columns 0 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "2" column "eurojackpot" wager with "5" numbers, "0" winning and "2" extra numbers set to "win"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved


  Scenario: Do Sportka wager 4 columns 6 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "4" column "sportka" wager with "6" numbers, "6" winning and "0" extra numbers set to "none"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved

  Scenario: Do Eurojackpot wager 4 columns 5 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "4" column "eurojackpot" wager with "5" numbers, "2" winning and "2" extra numbers set to "win"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved


  Scenario: Do Eurojackpot wager 2 columns 0 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "2" column "eurojackpot" wager with "5" numbers, "0" winning and "2" extra numbers set to "win"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved


  Scenario: Do Sportka wager 4 columns 6 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "quick-three-wager"
    And I create "4" column "sportka" wager with "6" numbers, "6" winning and "0" extra numbers set to "none"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved
