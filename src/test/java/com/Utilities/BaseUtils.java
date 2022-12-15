package com.Utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;


import static org.hamcrest.Matchers.equalTo;


public class BaseUtils {
    public static final int SUCCESS_STATUS_CODE = 200;

    public static final int POST = 1;
    public static final int GET = 2;
    public static final int DELETE = 3;
    public static final int PUT = 4;

    public static String getBaseUri(){
        return ConfigurationReader.get("baseUri");
    }

    public static String getBaseUri(String resourcePath){
        return ConfigurationReader.get("baseUri") + resourcePath;
    }

    public static JSONObject createJSONPayload(Object object) {
        return new JSONObject(object);
    }

    public static RequestSpecification createRequestSpecification() {
        RequestSpecification requestSpecification = RestAssured.given();

       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.accept(ContentType.JSON);
       requestSpecification.header("Content-Type", "application/json");
        requestSpecification.header("Accept", "*/*");
        requestSpecification .header("X-CMC_PRO_API_KEY","f2082379-807d-4fe7-81e6-ad629ed223af");
        requestSpecification .header("User-Agent", "PostmanRuntime/7.29.2");
       requestSpecification .header("Accept-Encoding", "deflate, gzip, br");
       requestSpecification .header("Connection", "keep-alive");

        return requestSpecification;
    }



    public static Response sendRequest(int httpRequestType, String requestUri, String payLoad) {
        RequestSpecification requestSpecification= null;
        Response response = null;
        switch (httpRequestType) {
            case BaseUtils.POST:
                response = createRequestSpecification().body(payLoad).post(requestUri);
                break;
            case BaseUtils.GET:
                response = createRequestSpecification() .get(requestUri);
                break;
            case BaseUtils.DELETE:
                response = createRequestSpecification().delete(requestUri);
                break;
            case BaseUtils.PUT:
                response = createRequestSpecification().body(payLoad).post(requestUri);
            default:
                response = requestSpecification.post(requestUri);
                break;
        }
        return response;
    }

//    public static void assertEquals(Object objExpected, Object objActual) {
//        try {
//            SoftAssert sAssert = new SoftAssert();
//            sAssert.assertEquals(objActual.toString().trim(), objExpected.toString().trim());
//            sAssert.assertAll();
//        } catch (Exception | AssertionError var3) {
//            throw var3;
//        }
//    }

    public static void verifyMessage(Response response, String errorMessage) {
        response.then().assertThat().body("message", equalTo(errorMessage));
    }

}
