Feature: Keno Manual

  Scenario: Keno TC01
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers | vklad |
      | 50,60   | 5     |

    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC02
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers | vklad |
      | 59,60   | 10    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC03
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers | vklad |
      | 58,59   | 15    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC04
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers  | vklad |
      | 45.50.60 | 20    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC05
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers  | vklad |
      | 35,40,57 | 25    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC06
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers  | vklad |
      | 30,55,56 | 30    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC07
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers | vklad |
      | 2,11,21 | 35    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


  Scenario: Keno TC08
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers     | vklad |
      | 15,20,25,60 | 40    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC09
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers   | vklad |
      | 1,5,10,59 | 45    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC10
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers    | vklad |
      | 3,33,50,60 | 50    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC11
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers    | vklad |
      | 4,14,24,50 | 60    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC12
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers     | vklad |
      | 51,52,53,54 | 70    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


  Scenario: Keno TC13
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers        | vklad |
      | 20,30,40,50,60 | 80    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC14
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers       | vklad |
      | 1,10,20,21,60 | 90    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC15
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers     | vklad |
      | 30,35,40,41 | 100   |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC16
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers        | vklad |
      | 42,43,44,45,50 | 50    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC17
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers        | vklad |
      | 16,26,36,46,60 | 10    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC18
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers       | vklad |
      | 7,17,27,37,47 | 15    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC19
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers         | vklad |
      | 1,5,20,25,50,60 | 20    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC20
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers           | vklad |
      | 10,15,30,35,50,59 | 25    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC21
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers           | vklad |
      | 20,25,30,35,49,59 | 30    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky


  Scenario: Keno TC22
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers         | vklad |
      | 5,6,25,28,45,48 | 35    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC23
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers          | vklad |
      | 1,10,12,13,38,39 | 40    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC24
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers          | vklad |
      | 8,23,29,31,58,60 | 45    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC25
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers          | vklad |
      | 9,19,55,56,57,59 | 50    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC26
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers             | vklad |
      | 1,10,20,30,40,50,60 | 60    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC27
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers             | vklad |
      | 5,15,25,35,45,55,60 | 70    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC28
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers           | vklad |
      | 1,5,9,10,15,44,60 | 80    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC29
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers              | vklad |
      | 18,20,22,25,30,32,35 | 90    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC30
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers            | vklad |
      | 2,9,40,45,50,52,59 | 100   |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC31
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers             | vklad |
      | 4,14,24,34,50,59,60 | 5     |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC32
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers             | vklad |
      | 3,42,45,46,55,58,59 | 50    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC33
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers            | vklad |
      | 6,7,16,17,27,37,57 | 15    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC34
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers            | vklad |
      | 1,2,3,4,45,50,60   | 20    |
      | 3,8,30,35,50,51,58 | 25    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC35
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers          | vklad |
      | 1,60             | 30    |
      | 6,16,23,33,57,58 | 35    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC36
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers          | vklad |
      | 2,11,21        | 40    |
      | 5,10,12,13,33,38 | 45    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Keno TC37
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "keno/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create Keno wager
      | numbers          | vklad |
      | 2,19,53,56,57,59         | 50    |
      | 57,58| 60    |
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky















