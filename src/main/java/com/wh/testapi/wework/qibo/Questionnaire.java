package com.wh.testapi.wework.qibo;

import io.restassured.response.Response;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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

    //get请求不使用yaml格式
    public Response getNoYamlExam()
    {

        return  getDefaultRequestSpecification()
                .param("page_num",Integer.valueOf(1))
                .param("page_size",Integer.valueOf(10))
                .param("actid","a67ll07e")
                .when().get("https://hy.hybugu.mudu.tv/questionnaire/api/get_questionnaires")
                .then().log().all().extract().response();

    }

    //*************************post的几种类型*********************************************
    //post使用yaml和map格式
    public Response createExame()
    {
        HashMap<String, Object> map = new HashMap();
        map.put("_file", "/data/crearExame.json");
        Response response = getResponseFromYaml("/api/createExame.yaml", map);
        return response;
    }



    //post使用map格式
    public Response createExameMap()
    {
        HashMap<String, Object> map = new HashMap();
        map.put("actid","a67ll07e");
        map.put("name","eh1");
        map.put("description","");


        return  getDefaultRequestSpecification()
                .body(map)
                .when().post("https://hy.hybugu.mudu.tv/examination/api/create_exam")
                .then().assertThat().body(matchesJsonSchemaInClasspath("jsonschema/createx.json"))
                .log().all().extract().response();
    }


    //post 不 使用ymal格式
    public Response createExamether()
    {
        //101节课28分钟
        HashMap<String,Object>map=new HashMap<>();
        map.put("$.actid","a67ll07e");
        //读数据模板
        String mbody=template("/data/crearExame.json",map);
        System.out.println("胡扯"+mbody);

        return  getDefaultRequestSpecification()
                .body(mbody)
                .when().post("https://hy.hybugu.mudu.tv/examination/api/create_exam")
                .then().log().all().extract().response();
    }


}
