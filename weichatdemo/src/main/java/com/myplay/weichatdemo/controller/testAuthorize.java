package com.myplay.weichatdemo.controller;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMassMessageService;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class testAuthorize {

    @Autowired
    private WxMpService wxMpService;

    private String code;

    private String openId;

    private WxMpUser wxMpUser;


    @RequestMapping(path = "/wx", method = RequestMethod.GET)
    public String queryUserOrder( WxRequest request) {
        System.out.println(request);
        System.out.println("微信认证");
        return request.getEchostr();
    }


    @RequestMapping(path = "/token", method = RequestMethod.GET)
    public String token() {
        try {
            String accessToken = wxMpService.getAccessToken();

            return accessToken;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(path = "/code", method = RequestMethod.GET)
    public String index(String code,String openId){
        System.out.println(code);
        System.out.println(openId);
        this.code=code;
        this.openId=openId;
        return "/test";
    }

    @RequestMapping(path = "/userInfo", method = RequestMethod.GET)
    public String userInfo(){
        System.out.println(code);
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            WxMpUser zh_cn = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, "zh_CN");
            this.wxMpUser =zh_cn;
            System.out.println(zh_cn);
            return wxMpOAuth2AccessToken.toString();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }



    @RequestMapping(path = "/jsTicket", method = RequestMethod.GET)
    public String jsTicket(){
        System.out.println(code);
        try {
            String jsapiTicket = wxMpService.getJsapiTicket();
            System.out.println(jsapiTicket);
            WxJsapiSignature jsapiSignature = wxMpService.createJsapiSignature("http://db5fc6d2.ngrok.io/userInfo");
            return jsapiSignature.toString();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    public String uploade(){
        System.out.println(code);
        try {
            String accessToken = wxMpService.getAccessToken();
            System.out.println(accessToken);

            WxMpMaterialService materialService = wxMpService.getMaterialService();

            WxMediaUploadResult result = materialService.mediaUpload(WxConsts.MaterialType.IMAGE, new File("C:\\Users\\wangD\\Desktop\\back.jpg"));

            System.out.println(result);
            String mediaId = result.getMediaId();

            File file = materialService.mediaDownload(mediaId);

            return file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(path = "/sendMsg", method = RequestMethod.GET)
    public String sendMsg(){
        System.out.println(code);
        try {
            WxMpTemplateMsgService templateMsgService = wxMpService.getTemplateMsgService();
            WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
            WxMpTemplateData wxMpTemplateData = new WxMpTemplateData();
            wxMpTemplateData.setName("userName");
            wxMpTemplateData.setValue(wxMpUser.getNickname());
            List<WxMpTemplateData> wxMpTemplateData1 = Arrays.asList(wxMpTemplateData);
            wxMpTemplateMessage.setTemplateId("4sWDKWGUlRaUPkRg9KkdqB1d-lyS9kTXQ03VRbhOfws");
            wxMpTemplateMessage.setToUser(wxMpUser.getOpenId());
            wxMpTemplateMessage.setData(wxMpTemplateData1);

            String s = templateMsgService.sendTemplateMsg(wxMpTemplateMessage);
            System.out.println(s);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public static void main(String[] args) {
        List<String> strings = Arrays.asList("你好", "hello");
        String s = JSON.toJSONString(strings);
        System.out.println(s);
        List<String> strings1 = JSON.parseArray(s, String.class);
        System.out.println(strings1);

    }*/

    public static void main(String[] args) {
        String adateStr="2018-05-04 16:24:09.0";
        Timestamp timestamp = Timestamp.valueOf(adateStr);
        Date date = new Date(timestamp.getTime());
        System.out.println(date);
    }
}
