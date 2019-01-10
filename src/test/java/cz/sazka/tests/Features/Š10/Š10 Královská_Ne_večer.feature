Feature: Š10 Královská_Ne_večer manual

  Scenario: S10 TC02
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 1       | 10    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC04
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 5       | 40    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC06
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 2,6     | 50    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC08
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 5       | 20    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC10
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 2       | 40    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC06
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 2,6     | 50    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC08
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 5       | 20    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC10
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 2       | 40    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC12
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 4,5     | 60    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC14
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 3,4     | 80    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC16
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 3,5,6   | 100   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC18
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 4,9,10  | 120   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC20
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers     | vklad | kralovskahra |
      | 11,12,13,19 | 140   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC22
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers     | vklad | kralovskahra |
      | 20,21,29,30 | 160   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC24
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 22,23,24,25,26 | 180   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC26
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 36,37,38,39,40 | 200   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC28
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers       | vklad | kralovskahra |
      | 9,10,11,19,20 | 20    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC30
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers           | vklad | kralovskahra |
      | 31,32,33,34,35,36 | 40    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC32
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 2,3,12,13,22,23 | 60    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC34
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers          | vklad | kralovskahra |
      | 4,40,49,50,51,52 | 80    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC36
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers           | vklad | kralovskahra |
      | 29,39,49,59,69,79 | 100   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC38
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 60,61,62,63,64,65,66 | 120   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC40
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers             | vklad | kralovskahra |
      | 1,21,22,23,24,29,30 | 140   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC42
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers            | vklad | kralovskahra |
      | 7,8,59,60,69,70,79 | 160   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC44
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 10,20,30,40,50,60,70 | 180   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC46
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                | vklad | kralovskahra |
      | 1,11,12,13,17,18,25,26 | 200   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC48
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 1,2,3,71,72,73,74,75 | 20    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC50
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers                 | vklad | kralovskahra |
      | 19,20,22,24,26,29,30,39 | 40    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC52
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                | vklad | kralovskahra |
      | 4,19,30,40,49,60,69,73 | 60    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC54
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 68,71,72,73,74,75,76,77,78 | 80    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC56
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 29,30,31,32,33,34,35,36,37 | 100   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC58
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                | vklad | kralovskahra |
      | 2,3,4,9,72,73,74,75,76 | 120   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC60
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers                     | vklad | kralovskahra |
      | 2,3,20,23,26,29,30,33,36,39 | 140   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC62
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers                  | vklad | kralovskahra |
      | 1,2,30,39,60,63,69,70,79 | 160   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC64
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 8,18,28,38,48,53,54,58,68,78 | 180   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC66
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers                       | vklad | kralovskahra |
      | 59,60,61,62,63,74,75,76,77,78 | 200   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC68
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers                       | vklad | kralovskahra |
      | 19,20,21,22,33,34,45,46,49,50 | 20    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC70
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                   | vklad | kralovskahra |
      | 5,6,7,8,29,30,39,40,49,50 | 40    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC72
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 1,10,20,30,40,50,60,70,71,72 | 60    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC74
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers                   | vklad | kralovskahra |
      | 2,3,4,9,10,19,20,29,30,39 | 80    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

