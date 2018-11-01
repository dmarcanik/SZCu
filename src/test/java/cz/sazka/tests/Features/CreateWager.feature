Feature: Place wager

  Scenario: Place euromiliony wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "sobota"
      | numbers              | additional |
      | 1,2,3,4,5,6,7        | 1          |
      | 8,9,10,11,12,13,14   | 2          |
      | 15,16,17,18,19,20,21 | 3          |

    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved
    Then wager is correctly displayed in Moje sázky

  Scenario: Place eurojackpot wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek"
      | numbers        | additional |
      | 1,2,3,4,5      | 1,2        |
      | 8,9,10,11,12   | 2,3        |
      | 15,16,17,18,19 | 3,4        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved
    Then wager is correctly displayed in Moje sázky


  Scenario: Place S10 wager 2 columns 0 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with vklad set to "100" královska hra "ano" draw set to "poledne,vecer"
      | numbers        | vklad | kralovskahra |
      | 1,2,3,4,5      | 100   | ano          |
      | 8,9,10,11,12   | 20    | ne           |
      | 15,16,17,18,19 | 50    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved
    Then wager is correctly displayed in Moje sázky

