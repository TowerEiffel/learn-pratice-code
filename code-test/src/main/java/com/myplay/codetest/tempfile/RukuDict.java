package com.myplay.codetest.tempfile;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

/**
 * TODO the class description
 *
 * @author baihe
 * @Date: 2018/10/17 10:40
 */
public class RukuDict {

    /*生产入库	0701
    购买入库	0702
    退货入库	0704
    期初入库	0706
    增溢入库	0707
    进口入库	0705
    移库入库	0709
    使用回库	0710
    特殊销售入库	0711
    其它	0712*/

    public static void main(String[] args) {
        String str = "0506";
        String substring = str.substring(1, 2);
        System.out.println(substring);
        Timestamp timestamp= new Timestamp(1539532800000L);
        long time = new Date().getTime();
        System.out.println(time);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear()+"-"+now.getMonth()+"-"+now.getDayOfMonth()+"-"+now.getHour()+"-"+now.getMinute()+"-"+now.getSecond());
        System.out.println(now.getYear()+"-"+now.getMonthValue()+"-"+now.getDayOfMonth()+"-"+now.getHour()+"-"+now.getMinute()+"-"+now.getSecond());
        String seqNo="WI"+now.getYear()+now.getMonthValue()+now.getDayOfMonth()+now.getHour()+now.getMinute()+now.getSecond();
        System.out.println(seqNo);
        BigDecimal bigDecimal = new BigDecimal("0.05");
        System.out.println(bigDecimal.toString());
        /*1539930396548
        * 1539532800000
        * */
        System.out.println(now.getSecond()<10?"0"+now.getSecond():now.getSecond());
    }

}
