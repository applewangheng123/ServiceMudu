package com.wh.testapi.wework.qibo;

import io.restassured.response.Response;

import java.util.HashMap;

public class Questionnaire extends Contact {

    //参数化
    public Response adminInfo(String actId, String question_id)
    {
        HashMap<String, Object> map = new HashMap();
        map.put("page_num", Integer.valueOf(1));
        map.put("page_size", Integer.valueOf(10));
        map.put("actid", actId);
        Response response = getResponseFromYaml("/api/create.yaml", map);
        return response;
    }



    //get请求使用yaml格式
    public Response getExam()
    {
        HashMap<String, Object> map = new HashMap();
        map.put("page_num", Integer.valueOf(1));
        map.put("page_size", Integer.valueOf(10));
        map.put("actid", "a67ll07e");
        Response response = getResponseFromYaml("/api/create.yaml", map);
        return response;
    }

    //get请求不使用yaml格式  todo
    public Response getNoYamlExam()
    {
        HashMap<String, Object> map = new HashMap();
        map.put("page_num", Integer.valueOf(1));
        map.put("page_size", Integer.valueOf(10));
        map.put("actid", "a67ll07e");

        return  getDefaultRequestSpecification()
                .queryParam(map.toString())
                .when().get("/questionnaire/api/get_questionnaires")
                .then().log().all().extract().response();

    }

    //post使用yaml格式
    public Response createExame()
    {
        HashMap<String, Object> map = new HashMap();
        map.put("_file", "/data/crearExame.json");
        Response response = getResponseFromYaml("/api/createExame.yaml", map);
        return response;
    }

    //post 不 使用ymal格式
    public Response createExamether()
    {
        //101节课28分钟
        HashMap<String,Object>map=new HashMap<>();
        map.put("$.actid","a67ll07e");
        //读数据模板
        String mbody=template("/data/crearExame.json",map);

        return  getDefaultRequestSpecification()
                .body(mbody)
                .when().post("https://hy.hybugu.mudu.tv/examination/api/create_exam")
                .then().log().all().extract().response();
    }


}
