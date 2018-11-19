Feature: Euromiliony_manual

  Scenario: Euromiliony TC01
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "utery" and Šance set to "none", předpladné set to "5"
      | numbers       | additional |
      | 2,3,4,5,6,7,8 | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC02
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "sobota" and Šance set to "Z,0", předpladné set to "1"
      | numbers       | additional |
      | 2,3,4,5,6,7,8 | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


  Scenario: Euromiliony TC03
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "utery" and Šance set to "Z,Y", předpladné set to "1"
      | numbers             | additional |
      | 1,10,18,20,21,22,23 | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC04
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "utery" and Šance set to "none", předpladné set to "2"
      | numbers             | additional |
      | 1,15,19,20,25,26,27 | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC05
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "utery" and Šance set to "Z,0", předpladné set to "1"
      | numbers             | additional |
      | 1,10,18,20,28,30,35 | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


  Scenario: Euromiliony TC06
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "sobota" and Šance set to "Z,Y", předpladné set to "1"
      | numbers          | additional |
      | 25,29,35,2,3,4,6 | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC07
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "utery" and Šance set to "none", předpladné set to "2"
      | numbers              | additional |
      | 21,22,23,24,26,27,31 | 2          |
      | 21,22,23,24,26,27,31 | 2          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC08
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "sobota" and Šance set to "Z,0", předpladné set to "1"
      | numbers              | additional |
      | 1,5,19,20,25,29      | 1          |
      | 1,5,19,2,3,4,6       | 1          |
      | 20,25,26,27,28,30,31 | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC09
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "utery" and Šance set to "Z,Y", předpladné set to "1"
      | numbers              | additional |
      | 10,18,28,30,35,11,12 | 2          |
      | 21,22,23,24,25,26,27 | 3          |
      | 35,34,33,32,31,29,27 | 5          |
      | 1,10,2,4,5,6,7       | 5          |
      | 10,18,20,28,30,35,33 | 4          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC10
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "sobota" and Šance set to "none", předpladné set to "1"
      | numbers              | additional |
      | 1,5,19,20,21,22,23 | 2          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Euromiliony TC11
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Euromiliony wager with draw set to "utery" and Šance set to "Z,0", předpladné set to "1"
      | numbers              | additional |
      | 1,10,18,20,28,30,35      | 1          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

