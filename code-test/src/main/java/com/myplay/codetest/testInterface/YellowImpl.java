package com.myplay.codetest.testInterface;

/**
 * TODO the class description
 *
 * @author baihe
 * @Date: 2018/11/15 17:39
 */
public class YellowImpl implements One<Yellow> {
    @Override
    public void test(Yellow yellow) {
        System.out.println(yellow);
    }
}
