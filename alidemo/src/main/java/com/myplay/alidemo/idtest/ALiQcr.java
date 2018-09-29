package com.myplay.alidemo.idtest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class ALiQcr {


    public void idQcr(String side, String filePath, IdMsg idMsg) throws Exception {
        String base64Code = getBase64Code(filePath);
        HttpMsg httpMsg = HttpMsg.buildIdQcrMsg(side, ALiYunConfig.appcode, base64Code);
        qcr(side, httpMsg, idMsg);
    }


    public void idQcr(String side, FileInputStream filePath, IdMsg idMsg) throws Exception {
        String base64Code = getBase64Code(filePath);
        HttpMsg httpMsg = HttpMsg.buildIdQcrMsg(ALiYunConfig.face, ALiYunConfig.appcode, base64Code);
        qcr("", httpMsg, null);
    }


    private void qcr(String side, HttpMsg httpMsg, IdMsg idMsg) throws Exception {
        HttpResponse response = HttpUtils.doPost(httpMsg.getHost(), httpMsg.getPath(), httpMsg.getMethod(), httpMsg.getHeaders(), httpMsg.getQuerys(), httpMsg.getBodys());
        int stat = response.getStatusLine().getStatusCode();
        if (stat != 200) {
            System.out.println("Http code: " + stat);
            System.out.println("http header error msg: " + response.getFirstHeader("X-Ca-Error-Message"));
            System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
            return;
        }

        String res = EntityUtils.toString(response.getEntity());
        JSONObject res_obj = JSON.parseObject(res);
        if (side.equals("face")) {
            IdFaceMsg idMsg1 = JSON.toJavaObject(res_obj, IdFaceMsg.class);
            BeanUtils.copyProperties(idMsg1, idMsg);
        } else {
            IdBackMsg idBackMsg = JSON.toJavaObject(res_obj, IdBackMsg.class);
            BeanUtils.copyProperties(idBackMsg, idMsg);
        }


    }


    private String getBase64Code(String filePath) {

        String imgBase64 = "";
        try {
            File file = new File(filePath);
            byte[] content = new byte[(int) file.length()];
            FileInputStream finputstream = new FileInputStream(file);
            finputstream.read(content);
            finputstream.close();
            imgBase64 = new String(encodeBase64(content));
        } catch (IOException e) {
            e.printStackTrace();
            return imgBase64;
        }
        return imgBase64;
    }


    private String getBase64Code(FileInputStream finputstream) {

        return null;
    }


    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\wangD\\Desktop\\id.jpg";
            String backpath = "C:\\Users\\wangD\\Desktop\\back.jpg";
            ALiQcr aLiQcr = new ALiQcr();
            IdMsg idMsg = new IdMsg();
            aLiQcr.idQcr(ALiYunConfig.face, path, idMsg);

            aLiQcr.idQcr(ALiYunConfig.back, backpath, idMsg);
            System.out.println(idMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
