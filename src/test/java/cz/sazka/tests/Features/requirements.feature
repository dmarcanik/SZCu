Feature: requirements
  Scenario: Test
    Given Im not logged as any user and I am situated on Dashboard
    When I Navigate to section "loterie"and game "stastnych-10/vysledky-a-vyhry/kontrola-sazky"
    And I select drawdate
    And  I create Stastnych 10 wager with draw set to "poledne" and Šance set to "Z,0", předpladné set to "1"
      | numbers         | vklad | kralovskahra |
      | 1,5,10,15,2,3,4 | 150   | ano          |
    And I click on button "p_lt_ctl10_pageplaceholder_p_lt_ctl02_Sazka_S10TicketChecker_LocalizedLinkButton1"
    Then offline check with correct price is displayed

    Scenario: TC:41475 Registrace-Nový hráč - české občanství, vstupní bonus 200Kč
      Given Im not logged as any user and I am situated on Dashboard. Registration launched from special link https://uat.sazka.cz/kurzove-sazky?mmi=45559.
      When  I create new account with valid name and ID and select welcome bonus 200 Kč during registration
      And  I click on button "userName"
      And I click on my account
      And I click on my bonuses
      Then bonus is correctly added to the account


    Scenario: TC:41690 Verifikace osobních údajů
      Given Im logged in as "<string>" with password "<string>" and situated on Dashboard
      And  I click on button "userName"
      And I click on my account
      Then Personal data is verified

  Scenario:TC:41698 Verifikace-Ověřit email adresu
      Given Im logged in as "<string>" with password "<string>" and situated on Dashboard
      And I click on button "userName"
    And I click on my account
    And I click on "overit" next to email address
    Then I click on resend verification email
    Given Im logged in as "<string>" with password "<string>" and situated on https://backend.uat.sazka.cz/ and I verified email address
    Then email address is verified
    Given Im logged in as "<string>" with password "<string>" and situated on Dashboard
    And I click on button "userName"
    And I click on my account
    Then email address is verified  ( ? stačí to dat všetko do predošleho "email is verified" ? ja neviem)





