package com.myplay.config;

import com.myplay.annotation.componentscan.MyTypeFilter;
import com.myplay.domain.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

/**
 * 配置类  代替 之前xml文件
 *
 * @author baihe
 * @Date: 2018/11/2 11:50
 */
@Configuration  //声明这是一个配置类
//@ComponentScan(value = "com.myplay")
@ComponentScan(value = "com.myplay",useDefaultFilters = false,includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class}),

})
/*@ComponentScans(@ComponentScan(value = "com.myplay",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
}))
*/
/*
 * //指定过滤规则的包扫描，排除controller，和service 标注的类
 * 也可以有includefilter  写法一样的 但是如果要使用includeFilter 如果不是自定义的过滤规则  必须要禁用掉默认的过滤规则，即，useDefaultFilters = false
 * @ComponentScan 在jdk8之后可以使用重复注解 多次使用，在8之前可以使用@ComponentScans()  也是为了可以写多个过滤规则
 *
 * @ComponentScan 中可以自定义过滤规则，需要实现 TypeFilter即可
 * 使用 @ComponentScan(value = "com.myplay",excludeFilters = {
 *         @ComponentScan.Filter(type =FilterType.CUSTOM,classes = {MyTypeFilter.class})
 * })
 * 注意：
 * 这些过滤规则按照书写的顺序执行，意味着，后面的filter拿到的结果是前面的filter过滤后的结果的处理
 * 在使用@ComponentScan 注解时 会扫描所有的类,是否注册进context中取决于过滤规则
 */
public class MainConfig {



    /*给容器中注册一个bean 类型为返回值类型，id为方法名
     还有其他的属性  可以选择制定
    Autowire autowire() default Autowire.NO;

    String initMethod() default "";

    String destroyMethod() default "(inferred)";
    */
    @Bean(name="person")
    public Person person(){
        return new Person("lisi",20);
    }
}
