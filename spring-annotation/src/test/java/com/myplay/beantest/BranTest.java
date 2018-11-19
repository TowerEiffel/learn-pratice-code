package com.myplay.beantest;

import com.myplay.config.MainConfig;
import com.myplay.domain.bean.Person;
import com.myplay.domain.configurable.ConfigurableBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * test
 *
 * @author baihe
 * @Date: 2018/11/2 13:38
 */
public class BranTest {
    @Test
    public void testBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        ConfigurableBean bean = new ConfigurableBean();
        System.out.println(bean.isConfigurable());
    }


    @Test
    public void testCondition(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();
        //todo  获取系统的环境
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment);
    }
}
