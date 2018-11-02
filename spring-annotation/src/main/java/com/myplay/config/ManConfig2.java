package com.myplay.config;

import com.myplay.domain.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 配置类2
 *
 * @author baihe
 * @Date: 2018/11/2 14:55
 */
@Configuration
public class ManConfig2 {

    @Bean
    @Scope()//制定bean的作用范围
    /* 可选的总用范围
     *  ConfigurableBeanFactory#SCOPE_PROTOTYPE 多例
     *  ConfigurableBeanFactory#SCOPE_SINGLETON 单例
     *  org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     *  org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     *
     * */
    @Lazy
    /*
    * 懒加载：
     *      单例的bean：默认在容器启动的时候创建
     *      懒加载：容器启动时不创建对象，在第一次使用的时候创建
     *      懒加载：是针对单例bean的
     **/
    public Person person(){
        return new Person("zhangsan",25);
    }
}
