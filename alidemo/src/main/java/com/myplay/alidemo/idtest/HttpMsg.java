package com.myplay.alidemo.idtest;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class HttpMsg {
    private Map<String, String> headers;
    private String bodys;
    private String host;
    private String path;
    private String method;
    private Map querys;


    public static HttpMsg buildIdQcrMsg(String side, String appCode, String base64Code) {
        HttpMsg httpMsg = new HttpMsg();
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + ALiYunConfig.appcode);
        httpMsg.setHeaders(headers);
        JSONObject configObj = new JSONObject();
        configObj.put("side", side);
        String config = configObj.toString();
        JSONObject requestObj = new JSONObject();
        requestObj.put("image", base64Code);

        if (config.length() > 0) {
            requestObj.put("configure", config);
        }
        httpMsg.setBodys(requestObj.toString());
        httpMsg.setHost(ALiYunConfig.host);
        httpMsg.setPath(ALiYunConfig.path);
        httpMsg.setMethod(ALiYunConfig.post);
        return httpMsg;
    }

}
