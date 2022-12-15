package com.Step_Definitions;


import com.POJO.CurrencyCoinMarket;
import com.Utilities.BaseUtils;
import com.Utilities.ConvertPriceUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

public class Steps {

    BaseUtils baseUtils;
    ConvertPriceUtils convertPriceUtils;
    Response response = null;


    @Given("i try to convert {string} {string} to {string}")
    public void iTryToConvertTo(String amount, String coinMarketId, String currencyCode) {
      response= ConvertPriceUtils.getGTQtoGBPConversion(amount,coinMarketId,currencyCode);
       System.out.println(response.getBody().prettyPrint().toString());
        System.out.println("--------------////////////---------");

        CurrencyCoinMarket currencyCoinMarket = response.getBody().as(CurrencyCoinMarket.class);

        Map<String, CurrencyCoinMarket.Data.Quote> quote = currencyCoinMarket.getData().getQuote();

        double price = quote.get("GBP").getPrice();

        System.out.println("Price: " + price);

        String lastUpdated = quote.get("GBP").getLast_updated();

        System.out.println("GBP last updated: " + lastUpdated);
        String symbol = currencyCoinMarket.getData().getSymbol();

        System.out.println("Symbol: " + symbol);

        String name = currencyCoinMarket.getData().getName();

        System.out.println("Name: " + name);



    }

    @Then("i should see the status code {int}")
    public void iShouldSeeTheSatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Given("i try to convert {string} Guatemalan Quetzal currency {string} to British pounds {string}")
    public void iTryToConvertGuatemalanQuetzalCurrencyToBritishPounds(String amount, String copCurrency, String currencyCode) {
        response=ConvertPriceUtils.getGTQtoGBPConversion(amount,copCurrency,currencyCode);

    }

    @When("i try to convert the amount received in GBP {string} to {string}")
    public void iTryToConvertTheAmountReceivedInGBPTo(String coinMarketId, String currencyCode) {



    }


}
