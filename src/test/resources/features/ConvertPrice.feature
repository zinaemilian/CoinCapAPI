Feature: Price Conversion
  This feature deals with the cryptocurrency or fiat currency conversion functionality of the application

  Scenario Outline: Convert successfully any currency to target currency
    Given i try to convert "<amount>" "<coinMarketId>" to "<currencyCode>"
    When  i try to convert the amount received in GBP "2791" to "DOGE"
    Then i should see the status code 200
    And i should see the quote price value is increased
    Examples:
      | amount   | coinMarketId | currencyCode |
      | 10000000 | 3541         | GBP          |




