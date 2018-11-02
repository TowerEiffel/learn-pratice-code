package com.myplay.codetest.time;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 时间测试
 *
 * @author baihe
 * @Date: 2018/11/1 10:44
 */
public class TimeTest {

    public static void main(String[] args) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = now.toLocalDateTime();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getYear()+"-"+localDateTime.getMonth()+"-"+localDateTime.getDayOfMonth()+"-"+localDateTime.getHour()+"-"+localDateTime.getMinute()+"-"+localDateTime.getSecond());
        System.out.println(localDateTime.getYear()+"-"+localDateTime.getMonthValue()+"-"+localDateTime.getDayOfMonth()+"-"+localDateTime.getHour()+"-"+localDateTime.getMinute()+"-"+localDateTime.getSecond());
        String seqNo="WI"+localDateTime.getYear()+localDateTime.getMonthValue()+localDateTime.getDayOfMonth()+localDateTime.getHour()+localDateTime.getMinute()+localDateTime.getSecond();
        System.out.println(seqNo);
        System.out.println("==============");

        BigDecimal bigDecimal = new BigDecimal("0.05");
        System.out.println(bigDecimal.toString());

        System.out.println("============");

        String num="15";
        BigDecimal decimal = new BigDecimal("-" + num);
        System.out.println(decimal);

    }


}
