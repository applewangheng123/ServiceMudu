package com.wh.testapi.wework.qibo;

import com.wh.testapi.wework.Api;
import com.wh.testapi.wework.Config;
import com.wh.testapi.wework.Wework;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Contact extends Api {


    String random=String.valueOf(System.currentTimeMillis());

    @Override
    public RequestSpecification getDefaultRequestSpecification() {

        RequestSpecification requestSpecification=super.getDefaultRequestSpecification();
        requestSpecification.header("Cookie", "AnalyticSession=11036513-7a49-40fd-86a0-e33177b34b58; Token=68841b6b4fd877900d9d215d879ad9e53a74b9965950e5238c7b142cfe41d540");
        requestSpecification.header("content-type","application/json");

        requestSpecification.filter((req,res,ctx)->{
            return ctx.next(req,res);
        });


        return requestSpecification;
    }
}
