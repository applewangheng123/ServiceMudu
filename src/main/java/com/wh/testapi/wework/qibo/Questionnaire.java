package com.wh.testapi.wework.qibo;

import io.restassured.response.Response;

import java.util.HashMap;

public class Questionnaire extends Contact {
//actid=a67ll07e&page_num=1&page_size=15
    public Response adminInfo(String actId, String question_id)
    {
        HashMap<String, Object> map = new HashMap();
        map.put("page_num", Integer.valueOf(1));
        map.put("page_size", Integer.valueOf(10));
        map.put("actid", "a67ll07e");
       // map.put("question_id", question_id);

        Response response = getResponseFromYaml("/api/create.yaml", map);
        return response;
    }

    public Response createInfo()
    {
        HashMap<String, Object> map = new HashMap();
        map.put("_file", "/data/createquestion.json");
        Response response = getResponseFromYaml("/api/createqestionaire.yaml", map);
        return response;
    }

}
