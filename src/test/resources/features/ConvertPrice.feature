Feature: Price Conversion
  This feature deals with the cryptocurrency or fiat currency conversion functionality of the application

  Scenario Outline: Convert successfully any currency to target currency
    Given i try to convert "<amount>" "<coinMarketId>" to "<currencyCode>"
    Then i should see the status code 200
    Examples:
      |amount   |coinMarketId|currencyCode     |
      | 10000000|3541         |GBP             |

    Scenario: Convert successfully Guatemalan Quetzal currency to GBP than Dogecoin cryptocurrency
      Given i try to convert "10000000" Guatemalan Quetzal currency "3541" to British pounds "GBP"
      When  i try to convert the amount received in GBP "2791" to "DOGE"
      Then i should see the status code 200

