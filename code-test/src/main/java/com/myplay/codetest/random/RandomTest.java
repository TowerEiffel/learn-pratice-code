package com.myplay.codetest.random;

import java.util.Random;

/**
 * random test
 *
 * @author baihe
 * @Date: 2018/10/31 18:17
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i <10 ; i++) {
            int j = random.nextInt(9);
            System.out.println(j);
        }


    }

}
