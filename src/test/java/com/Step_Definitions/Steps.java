package com.Step_Definitions;


import com.POJO.CurrencyCoinMarket;
import com.Utilities.BaseUtils;
import com.Utilities.ConvertPriceUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class Steps {

    BaseUtils baseUtils;
    ConvertPriceUtils convertPriceUtils;
    Response response = null;
    Response responseDoge = null;

    private Map<String, CurrencyCoinMarket.Data.Quote> quote;
    private CurrencyCoinMarket currencyCoinMarket;
   private double quotePrice;



    @Given("i try to convert {string} {string} to {string}")
    public void iTryToConvertTo(String amount, String coinMarketId, String currencyCode) {
      response= ConvertPriceUtils.getGTQtoGBPConversion(amount,coinMarketId,currencyCode);
       System.out.println(response.getBody().prettyPrint().toString());
        System.out.println("--------------////////////---------");

        currencyCoinMarket = response.getBody().as(CurrencyCoinMarket.class);

        quote = currencyCoinMarket.getData().getQuote();

         quotePrice = quote.get("GBP").getPrice();

        System.out.println("Price: " + quotePrice);

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

    @When("i try to convert the amount received in GBP {string} to {string}")
    public void iTryToConvertTheAmountReceivedInGBPTo(String coinMarketId, String currencyCode) {
        String amount=String.valueOf(quotePrice);
        System.out.println(amount);
        String amountOverall=amount.substring(0,7);
       responseDoge=ConvertPriceUtils.getGTQtoGBPConversion(amountOverall,coinMarketId,currencyCode);
        System.out.println("Doge quote     "+responseDoge.prettyPrint().toString());


    }


    @Then("i should see the quote price value is increased")
    public void iShouldSeeTheQuotePriceValueIsDecreased() {
        CurrencyCoinMarket  currencyCoinMarketDoge = responseDoge.getBody().as(CurrencyCoinMarket.class);


        Map<String, CurrencyCoinMarket.Data.Quote>  quoteDoge=currencyCoinMarketDoge.getData().getQuote();


       double quotePriceDoge = quoteDoge.get("DOGE").getPrice();
        System.out.println(quotePriceDoge+" Doge Price");
        System.out.println("Price: GBP " + quotePrice);
        boolean check=quotePriceDoge<quotePrice;
        System.out.println(check);
        Assert.assertTrue(quotePriceDoge>quotePrice);
    }
}
