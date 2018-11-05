Feature: Loterie
  Scenario: Do Sportka wager 2 columns 0 winning
    Given Im logged in as "kolodejnik1@seznam.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "sportka"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I generate "2" column sportka wager with "0" winning numbers
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved
    Then wager is correctly displayed in Moje sázky