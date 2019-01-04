Feature: Sportka_Manual

  Scenario: Sportka - TC01
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "streda" and Šance set to "none", předpladné set to "1"
      | numbers          |
      | 1,10,19,21,31,33 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


  Scenario: Sportka - TC02
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "nedele" and Šance set to "Z,0", předpladné set to "1"
      | numbers          |
      | 8,29,31,39,41,42 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Sportka - TC03
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "streda,nedele" and Šance set to "Z,Y", předpladné set to "2"
      | numbers           |
      | 10,20,30,19,21,22 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Sportka - TC04
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "streda" and Šance set to "none", předpladné set to "2"
      | numbers          |
      | 1,18,20,30,32,48 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Sportka - TC05
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "streda,nedele" and Šance set to "Z,0", předpladné set to "3"
      | numbers       |
      | 1,18,32,5,6,7 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Sportka - TC06
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "nedele" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         |
      | 2,10,28,20,5,6  |
      | 8,9,11,12,13,14 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Sportka - TC07
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "streda" and Šance set to "none", předpladné set to "1"
      | numbers           |
      | 32,5,6,7,8,9      |
      | 10,20,11,12,13,14 |
      | 1,10,21,20,22,23  |
      | 1,10,18,20,19,21  |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Sportka - TC08
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "nedele" and Šance set to "Z,0", předpladné set to "1"
      | numbers          |
      | 3,4,5,6,7,9      |
      | 8,28,21,22,23,24 |
      | 2,10,3,4,5,6     |
      | 2,10,28,3,4,5   |
      | 2,10,28,20,30,3  |
      | 2,10,28,20,4,3   |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Sportka - TC09
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I create sportka wager with draw set to "streda" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        |
      | 3,4,5,6,7,8    |
      | 3,4,5,6,7,8    |
      | 3,4,5,6,7,8    |
      | 3,4,5,6,7,8    |
      | 1,4,5,6,7,8    |
      | 1,10,4,5,6,7   |
      | 1,10,18,4,5,6  |
      | 1,10,18,32,4,5 |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


    Scenario: Sportka - TC11
      Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
      When I Navigate to section "loterie"and game "sportka"
      And I click on button "online-bet"
      And I create sportka wager with draw set to "nedele" and Šance set to "Z,0", předpladné set to "1"
        | numbers             |
        | 2,10,28,20,30,38,49 |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
        | 3,4,5,6,7,9         |
      And I click on button "btn-game-send"
      And I click on button "btn-confirm-yes"
      Then wager is saved with correct price
      Then wager is correctly displayed in Moje sázky

    Scenario: Sportka - TC13
      Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
      When I Navigate to section "loterie"and game "sportka"
      And I click on button "online-bet"
      And I create sportka wager with draw set to "nedele" and Šance set to "Z,Y", předpladné set to "1"
        | numbers        |
        | 2,10,28,20,30,38 |
      And I click on button "btn-game-send"
      And I click on button "btn-confirm-yes"
      Then wager is saved with correct price
      Then wager is correctly displayed in Moje sázky

    Scenario: Sportka - TC10
      Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
      When I Navigate to section "loterie"and game "sportka"
      And I click on button "online-bet"
      And I create sportka wager with draw set to "patek" and Šance set to "none", předpladné set to "1"
        | numbers        |
        | 2,3,4,5,6,7|
      And I click on button "btn-game-send"
      And I click on button "btn-confirm-yes"
      Then wager is saved with correct price
      Then wager is correctly displayed in Moje sázky


