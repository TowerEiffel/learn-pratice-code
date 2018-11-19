package com.myplay.codetest.testInterface;

/**
 * TODO the class description
 *
 * @author baihe
 * @Date: 2018/11/15 17:37
 */
public class OneImpl implements One<Red> {
    @Override
    public void test(Red red) {
        System.out.println(red);
    }
}
