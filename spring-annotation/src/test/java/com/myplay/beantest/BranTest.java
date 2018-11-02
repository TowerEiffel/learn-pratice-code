package com.myplay.beantest;

import com.myplay.config.MainConfig;
import com.myplay.domain.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    }
}
