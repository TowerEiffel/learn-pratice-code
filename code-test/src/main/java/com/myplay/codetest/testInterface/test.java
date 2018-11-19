package com.myplay.codetest.testInterface;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * TODO the class description
 *
 * @author baihe
 * @Date: 2018/11/15 17:40
 */
public class test {
    public static void main(String[] args) {
        One one= new OneImpl();
        Red red = new Red();
        red.setName("red");
        Yellow yellow = new Yellow();
        yellow.setName("yellow");
        One yellow1 = new YellowImpl();
        one.test(red);
        yellow1.test(yellow);
        Class<?> superclass = one.getClass().getSuperclass();
        System.out.println(superclass.getCanonicalName());
        //one.test(yellow);
    }
}
