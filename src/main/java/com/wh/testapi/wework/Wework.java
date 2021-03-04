package com.wh.testapi.wework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class Wework {
    private static String token;

    @Test
    public static String getWeworkToken(String secret)
    {
        return null;

                //(String)((((Response) RestAssured.given().queryParam("corpid", new Object[] { WeworkConfig.getInstance().corpId }).queryParam("corpsecret", new Object[] { secret }).when().get("https://qyapi.weixin.qq.com/cgi-bin/gettoken", new Object[0])).then()).log().all()).statusCode(200)).extract().path("access_token", new String[0]);
    }

    public static String getToken()
    {
        if (token == null) {
            token = getWeworkToken(WeworkConfig.getInstance().contactSecret);
        }
        return token;
    }
}
