package com.myplay.config;

import com.myplay.annotation.ImportSelector.MyImportSelector;
import com.myplay.domain.bean.Person;
import com.myplay.domain.importbean.Color;
import org.springframework.context.annotation.*;

/**
 * 配置类2
 *
 * @author baihe
 * @Date: 2018/11/2 14:55
 */
@Configuration
//@Import(Color.class)//更快的导入组件的方式 可以是做个class，id为类的权限定名，这种方式无法指定一些属性，使用无参的构造方法
@Import(MyImportSelector.class)//也可以通过这种方式导入多个组件
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



    /*
    * @Conditional 按照一定的条件进行判断，满足条件给容积中注册bean springboot中大量使用
    * */

    @Bean
    @Conditional({})
    public Person person01(){
        return new Person("bill",60);
    }

    @Bean
    public Person person02(){
        return new Person("linus",48);
    }

}
