Feature: Eurojackpot manual

  Scenario: Eurojackpot TC01
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "none", předpladné set to "1"
      | numbers   | additional |
      | 1,2,3,4,5 | 1,2        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC02
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,0", předpladné set to "1"
      | numbers      | additional |
      | 1,10,11,12,3 | 1,3        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC03
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | additional |
      | 10,20,30,49,50 | 1,10       |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC04
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "none", předpladné set to "2"
      | numbers     | additional |
      | 2,3,4,5,6   | 3,4        |
      | 7,8,9,11,12 | 1,5        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC05
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,0", předpladné set to "1"
      | numbers       | additional |
      | 1,10,20,30,50 | 6,7        |
      | 1,2,3,4,5     | 8,9        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC06
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,Y", předpladné set to "2"
      | numbers        | additional |
      | 1,10,20,30,31  | 1,10       |
      | 20,30,50,21,22 | 3,4        |
      | 41,42,43,44,45 | 5,6        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC07
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "none", předpladné set to "1"
      | numbers        | additional |
      | 1,10,20,30,50  | 1,10       |
      | 1,10,2,3,4     | 1,10       |
      | 21,22,23,24,25 | 5,6        |
      | 31,32,33,34,35 | 7,8        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC08
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "none", předpladné set to "1"
      | numbers        | additional |
      | 41,42,43,44,45 | 8,9        |
      | 1,2,3,4,5      | 1,2        |
      | 1,10,11,12,13  | 1,3        |
      | 1,10,20,13,14  | 1,4        |
      | 1,10,20,50,15  | 1,10       |
      | 1,10,20,30,50  | 2,4        |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC09
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | additional |
      | 10,20,30,31,32 | 1,10       |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC10
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "none", předpladné set to "1"
      | numbers        | additional |
      | 2,3,20,22,23 | 1,10       |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC11
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,0", předpladné set to "1"
      | numbers        | additional |
      | 1,10,20,50,16| 1,8       |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC12
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | additional |
      | 1,10,20,30,50 | 1,6       |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Eurojackpot TC13
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "eurojackpot"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create Eurojackpot wager with draw set to "patek" and Šance set to "none", předpladné set to "1"
      | numbers        | additional |
      | 1,10,30,50,17| 2,3       |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

