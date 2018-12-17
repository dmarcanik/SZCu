Feature: Place wager

  Scenario: Place eurojackpot wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | additional |
      | 1,2,3,4,5      | 1,2        |
      | 8,9,10,11,12   | 2,3        |
      | 15,16,17,18,19 | 3,4        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


  Scenario: Place eurojackpot wager test
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "quick-two-wager"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"


  Scenario: Place S10 wager 2 columns 0 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 1,2,3,4,5,6,7,8,9,10       | 200   | ano          |
      | 11,12,13,14,15,16,17,18,19 | 200   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Place euromiliony wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "sobota" and Šance set to "none", předpladné set to "5"
      | numbers              | additional |
      | 1,2,3,4,5,6,7        | 1          |
      | 8,9,10,11,12,13,14   | 2          |
      | 15,16,17,18,19,20,21 | 3          |

    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Place Keno wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers      | vklad |
      | 1,2,3,4,5    | 30    |
      | 8,9,10,11,12 | 20    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Place Sportka wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create sportka wager with draw set to "streda" and Šance set to "Z,0", předpladné set to "1"
      | numbers           |
      | 1,2,3,4,5,6       |
      | 8,9,10,11,12,13   |
      | 15,16,17,18,19,20 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky



