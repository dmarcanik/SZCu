Feature: Loterie
  Scenario: Place Sportka wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka/vsadit-si-online"
    And I create sportka wager with draw set to "streda" and Šance set to "X,X", předpladné set to "5"
      | numbers           |
      | 1,2,3,4,5,6       |
      | 8,9,10,11,12,13   |
      | 15,16,17,18,19,20 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky
