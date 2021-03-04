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
        requestSpecification.header("Cookie", "AnalyticSession=11036513-7a49-40fd-86a0-e33177b34b58; WTOKEN=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyaWQiOjEwLCJ1aWQiOjQwMCwiaWF0IjoxNjE0MjM4MDE3LCJ0aWQiOiJybHJhdmdkbSJ9.nUgnPGm0fP8_m26_rVXK-j3xkTVUKlAZwNdUQKqECps; Token=0af893fd6366f7800526805257c6f54c74fb54fb51326e8f26ab4fc2b744c21e");
        requestSpecification.filter((req,res,ctx)->{
            return ctx.next(req,res);
        });


        return requestSpecification;
    }
}
