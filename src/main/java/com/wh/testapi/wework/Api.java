package com.wh.testapi.wework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.Har;
import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class Api {


    public RequestSpecification getDefaultRequestSpecification(){
        return  given().log().all();
    }


    public  String template(String path,HashMap<String,Object>map){
        DocumentContext documentContext= JsonPath.parse(Api.class.getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });

        System.out.println("输出jsonstring的数据"+documentContext.jsonString());
        return documentContext.jsonString();
    }



    public Restful getApiFromYaml(String path){

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            return   objectMapper.readValue(WeworkConfig.class.getResourceAsStream(path), Restful.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    //103节课30分钟
    public Restful updateApiFromMap(Restful restful, HashMap<String, Object> map){
        if(map==null){
            return restful;
        }

        //获取map的值，并赋值
        if (restful.method.toLowerCase().contains("get")) {
            map.entrySet().forEach(entry -> {
                restful.query.put(entry.getKey(), entry.getValue().toString());
               // restful.query.replace(entry.getKey(), entry.getValue().toString());
            });
        }
        //post方法
        if (restful.method.toLowerCase().contains("post")) {
            if(map.containsKey("_body")){
                restful.body=map.get("_body").toString();

            }
            if(map.containsKey("_file")){
                String filePath=map.get("_file").toString();
                map.remove("_file");
                restful.body=template(filePath,map);
            }

        }
        return restful;

    }

    //90节课35分钟  todo  支持从yaml文件  Done
    public  Response getResponseFromYaml(String path, HashMap<String, Object> map)  {

        Restful restful=getApiFromYaml(path);
        restful=updateApiFromMap(restful,map);

        RequestSpecification requestSpecification=getDefaultRequestSpecification();
        //读取query的值,并获取赋值
        if(restful.query!=null){
            restful.query.entrySet().forEach(entry -> {
                requestSpecification.queryParam(entry.getKey(), entry.getValue());
            });
        }

        if(restful.body!=null){
            requestSpecification.body(restful.body);
        }


        return requestSpecification.log().all()
                .when().request(restful.method, restful.url)
                .then().log().all().extract().response();


    }



}
