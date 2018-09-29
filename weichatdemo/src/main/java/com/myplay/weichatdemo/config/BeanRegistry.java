package com.myplay.weichatdemo.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInRedisConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanRegistry {


    @Autowired
    private WxMpInMemoryConfigStorage configStorage;

    @Bean
    public WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage(){

        WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId("wx3bd3daca39ba0bdd");
        configStorage.setSecret("0588f0a163da95d9d5ba1cabfa2f065c");
        configStorage.setToken("123456");
        configStorage.setAesKey("");

        return configStorage;
    }


    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);
        return wxMpService;
    }
}
