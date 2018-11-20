Feature: Š10 Královská_Ne_poledne manual

  Scenario: S10 TC01
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 1       | 20    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC03
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 2       | 20    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC05
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 5,10    | 40    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC07
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 2       | 10    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC09
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 20      | 30    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC11
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 3,4     | 50    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC13
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers | vklad | kralovskahra |
      | 10,15   | 70    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC15
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers  | vklad | kralovskahra |
      | 11,12,13 | 90    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC17
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers  | vklad | kralovskahra |
      | 20,21,25 | 110   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC19
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers     | vklad | kralovskahra |
      | 14,16,17,18 | 130   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC21
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers     | vklad | kralovskahra |
      | 23,24,25,30 | 150   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC23
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers     | vklad | kralovskahra |
      | 35,40,45,50 | 170   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC25
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers     | vklad | kralovskahra |
      | 51,52,53,54 | 190   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC27
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers       | vklad | kralovskahra |
      | 9,10,15,20,21 | 10    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC29
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers        | vklad | kralovskahra |
      | 10,20,30,40,50 | 30    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC31
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers          | vklad | kralovskahra |
      | 8,18,28,38,45,48 | 50    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC33
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers           | vklad | kralovskahra |
      | 30,31,40,41,50,51 | 70    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC35
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers           | vklad | kralovskahra |
      | 60,65,70,75,76,77 | 90    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC37
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 67,68,69,71,72,73,74 | 110   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC39
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers            | vklad | kralovskahra |
      | 5,8,13,22,34,48,50 | 130   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC41
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 66,67,68,70,75,78,80 | 150   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC43
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers              | vklad | kralovskahra |
      | 70,72,75,77,78,79,80 | 170   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC45
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                 | vklad | kralovskahra |
      | 31,32,41,42,51,52,61,62 | 190   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC47
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                 | vklad | kralovskahra |
      | 69,70,71,72,73,74,75,76 | 10    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC49
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers             | vklad | kralovskahra |
      | 2,3,4,6,20,30,40,60 | 30    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC51
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                 | vklad | kralovskahra |
      | 50,51,53,55,60,65,70,75 | 50    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC53
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                 | vklad | kralovskahra |
      | 35,40,55,60,70,75,77,79 | 70    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC55
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 40,41,42,43,44,46,47,48,49 | 90    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC57
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 10,20,11,21,31,41,51,61,80 | 110   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC59
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 11,22,33,44,55,65,75,77,78 | 130   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC61
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 20,35,45,55,60,65,70,71,72 | 150   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC63
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                    | vklad | kralovskahra |
      | 55,60,65,70,75,77,78,79,80 | 170   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC65
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 9,11,12,28,29,71,72,73,74,80 | 190   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC67
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                   | vklad | kralovskahra |
      | 2,3,4,5,25,50,51,52,53,54 | 10    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC69
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers                       | vklad | kralovskahra |
      | 11,21,32,43,54,55,60,65,70,75 | 30    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC71
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "1"
      | numbers                      | vklad | kralovskahra |
      | 5,15,25,35,45,55,65,67,68,74 | 50    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC73
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "1"
      | numbers                       | vklad | kralovskahra |
      | 55,60,65,70,75,76,77,78,79,80 | 70    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky









