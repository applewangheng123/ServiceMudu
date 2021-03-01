package com.wh.testapi.wework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;

public class WeworkConfig {
    public String agentId = "1000003";
    public String secret = "N3v8m00XaeO_zn7jVEt6uU337SGBsWSY7989fPJ5dy4";
    public String corpId = "ww45b859895b3a9f7b";
    public String contactSecret = "Lsdg-5kJGjRWm_HkhixRKoHWH0zMdHtLnK86MS8pShw";
    public String current = "test";
    public HashMap<String, HashMap<String, String>> env;
    private static WeworkConfig weworkConfig;

    public static WeworkConfig getInstance()
    {
        if (weworkConfig == null)
        {
            weworkConfig = load("/conf/WeworkConfig.yaml");
        }
        return weworkConfig;
    }

    public static WeworkConfig load(String path)
    {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try
        {
            return (WeworkConfig)objectMapper.readValue(WeworkConfig.class.getResourceAsStream(path), WeworkConfig.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
