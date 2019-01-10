Feature: Š10 Královská_Ano_večer manual

  Scenario: S10 TC101
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,1,2,3,4,5,6 | 140   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC103
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,9,10,19,20,29,30 | 120   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC105
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,39,17,18,21,22,23,24 | 100   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC107
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,40,49,50,32,33,34,36 | 80   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC109
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,59,60,69,70,79,41,42 | 60   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC111
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,2,3,4,9,10,19,20 | 40   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC113
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,29,54,55,56,57,58,62,61 | 20   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC115
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,30,39,49,71,72,73,74,75 | 200   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC117
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,50,59,60,69,70,5,6,7 | 180   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC119
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,79,1,2,3,4,9,10,11 | 160   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC121
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,12,13,14,15,16,17,18,21,22 | 140   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC123
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,19,20,33,34,35,36,37,38,41 | 120   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC125
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,29,30,39,40,45,46,47,48,51 | 100   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC127
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,49,50,59,60,69,70,55,56,57 | 80   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC129
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,79,1,2,3,4,9,10,19,61 | 60   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC75
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80 | 200  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC77
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,5 | 180  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC79
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,44,12 | 160  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC81
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 2,3,4 | 140  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC83
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,9,17,18 | 120  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC85
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,9,10,19 | 100  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC87
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,20,,28,31,32 | 80  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC89
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,29,30,39,36 | 60  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC91
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,37,38,41,42,43 | 40  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC93
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,40,49,51,52,53 | 20  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC95
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,Y", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,50,59,60,69,57 | 200  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC97
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,58,61,62,63,64,65 | 180  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC99
<<<<<<< Updated upstream
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
=======
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
>>>>>>> Stashed changes
    When I Navigate to section "loterie"and game "stastnych-10"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 80,70,79,72,73,74,76 | 160  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

