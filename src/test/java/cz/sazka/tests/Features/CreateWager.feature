Feature: Place wager
  Scenario: Place euromiliony wager
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "euromiliony"
    And I click on button "online-bet"
    And I click on button "btn-game-manual"
    And I create "euromiliony" wager with declared numbers
      |numbers|additional|
      |1,2,3,4,5,6,7|1|
      |8,9,10,11,12,13,14|2|
      |15,16,17,18,19,20,21|3|

    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved

  Scenario: Place S10 wager 2 columns 0 winning
    Given Im logged in as "marcanik@sazka.cz" with password "Heslo123" and situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vsadit-si-online"
    And I click on button "btn-game-manual"
    And I create "2" column stastnych 10 wager with "5" numbers, "2" winning and vklad set to "150" královska hra "ano"
    And I click on button "btn-game-send"
    And I click on button "btn-confirm-yes"
    Then wager is saved

