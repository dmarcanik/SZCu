Feature: Š10_predplatné

  Scenario: S10 TC131
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "2"
      | numbers       | vklad | kralovskahra |
      | 1,25,40,65,80 | 10    | ano          |
      | 80,2,3,39,60  | 10    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC132
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "none", předpladné set to "2"
      | numbers                    | vklad | kralovskahra |
      | 1,15,79,70,20,2,3,61,32,33 | 30    | ne           |
      | 1,40,77,78,45,50,55,60,6,7 | 30    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC133
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "Z,0", předpladné set to "2"
      | numbers  | vklad | kralovskahra |
      | 76,78,41 | 100   | ne           |
      | 10,19,25 | 100   | ne           |
      | 29,9,39  | 100   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC134
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "3"
      | numbers                 | vklad | kralovskahra |
      | 74,73,72,71,69,68,67,66 | 150   | ne           |
      | 64,63,62,61,59,58,57    | 150   | ne           |
      | 56,55,54,53,52,51       | 150   | ne           |
      | 1                       | 150   | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC135
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "7"
      | numbers                   | vklad | kralovskahra |
      | 1,79,70,69,60,59,50,11,78 | 200   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC136
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,Y", předpladné set to "14"
      | numbers     | vklad | kralovskahra |
      | 45,40,35,30 | 70    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC137
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "21"
      | numbers                      | vklad | kralovskahra |
      | 80,2,3,4,9,10,19,20,29,30    | 10    | ne           |
      | 39,40,50,59,60,69,70,79,1,29 | 10    | ne           |
      | 30,20,39,19,40,10,49,9,50,4  | 10    | ne           |
      | 59,3,60,2,70,80,79,1,29,30   | 10    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC138
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "48"
      | numbers     | vklad | kralovskahra |
      | 55,60,65,70 | 110   | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC139
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "vecer" and Šance set to "none", předpladné set to "48"
      | numbers    | vklad | kralovskahra |
      | 80,19,10,9 | 90    | ano          |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: S10 TC140
    Given Im logged in as "sazka200@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "online-bet"
    And I create Stastnych 10 wager with draw set to "poledne,vecer" and Šance set to "none", předpladné set to "96"
      | numbers                       | vklad | kralovskahra |
      | 5,78,65,55,45,79,15,77,35,75  | 90    | ne           |
      | 2,3,4,9,19,29,39,49,69        | 90    | ne           |
      | 80,78,65,55,45,79,15,77,35,75 | 90    | ano          |
      | 2,3,4,9,19,29,39,49,69        | 90    | ne           |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky