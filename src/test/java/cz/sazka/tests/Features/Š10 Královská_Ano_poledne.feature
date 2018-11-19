Feature: Š10 Královská_Ano_poledne manual

  Scenario: S10 TC100
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 1,5,10,15,2,3,4 | 150   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC102
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers            | vklad | kralovskahra |
      | 1,20,25,30,35,40,7 | 130   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC104
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 1,8,9,11,12,13,14,16 | 110   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC106
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                | vklad | kralovskahra |
      | 1,45,50,26,27,28,29,31 | 190   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC108
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                | vklad | kralovskahra |
      | 1,55,60,65,70,37,38,39 | 140   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC110
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 1,75,77,78,79,80,5,4 | 50    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC112
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                   | vklad | kralovskahra |
      | 1,44,46,47,48,49,51,52,53 | 30    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC114
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                  | vklad | kralovskahra |
      | 1,5,10,62,63,64,66,67,68 | 10    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC116
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                | vklad | kralovskahra |
      | 1,15,20,25,30,76,2,3,4 | 190   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC118
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                 | vklad | kralovskahra |
      | 1,35,40,45,50,55,60,8,9 | 170   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC120
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                  | vklad | kralovskahra |
      | 1,65,70,75,77,78,79,80,5 | 150   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC122
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 1,10,23,24,26,27,28,29,31,32 | 130   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC124
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 1,15,20,25,19,29,39,42,43,44 | 110   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC126
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 1,30,35,40,45,50,49,52,53,54 | 90    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC128
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 1,55,60,65,70,75,77,78,58,59 | 70    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC130
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                     | vklad | kralovskahra |
      | 1,80,5,10,15,20,25,30,35,40 | 50    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC76
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 1       | 190   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC78
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 1,10    | 170   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC80
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,5,8     | 150  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC82
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,11,13,14     | 130  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC84
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,15,20,22     | 110  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC86
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,23,24,26,27     | 90  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC88
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,25,30,33,34     | 70  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC90
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,35,40,45,50     | 50  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC92
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,55,44,46,47,48     | 30  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC94
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,60,65,70,54,56     | 10  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC96
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,75,77,78,79,80     | 190  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC98
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 1,5,66,67,68,69,71     | 170  | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky