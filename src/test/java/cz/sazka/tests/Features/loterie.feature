Feature: Loterie

  Scenario: Do Sportka wager 1 columns 0 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "<string>" column sportka wager with "<string>" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 1 columns 1 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "1" column sportka wager with "1" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 1 columns 2 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "1" column sportka wager with "2" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 1 columns 3 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "1" column sportka wager with "3" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 1 columns 4 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "1" column sportka wager with "4" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 1 columns 5 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "1" column sportka wager with "5" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 1 columns 6 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "1" column sportka wager with "6" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 2 columns 0 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "0" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 2 columns 1 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "1" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 2 columns 2 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "2" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 2 columns 3 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "3" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 2 columns 4 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "4" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 2 columns 5 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "5" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky

  Scenario: Do Sportka wager 2 columns 6 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "6" winning numbers and Šance set to "X,X" with draw set to "streda", předpladné set to "1"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved with correct price
    Then wager is correctly displayed in Moje sázky