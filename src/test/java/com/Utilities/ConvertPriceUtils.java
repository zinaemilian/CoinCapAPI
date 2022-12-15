package com.Utilities;

import io.restassured.response.Response;

public class ConvertPriceUtils extends BaseUtils{


    public static Response getGTQtoGBPConversion(String amount,String coinMarketCapId, String currencyCode) {

        String url = ConfigurationReader.get("baseUri") +
                ConfigurationReader.get("price_conversion") +
                "?amount=" +amount+"&id="+coinMarketCapId+"&convert="+currencyCode;
                //+"&"+
               /* ConfigurationReader.get("api_key_name")+ "="+
                ConfigurationReader.get("api_key_value");*/
        System.out.println( url);

        return sendRequest(BaseUtils.GET, url, null);
    }

}
