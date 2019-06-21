package com.github.baituhuangyu.qqwry;

import com.aliyun.odps.udf.UDF;
import java.io.IOException;


public class ParseLocationByIP extends UDF {
    private static QQWry qqwry;

    private static void initClass()  {
        try {
            qqwry = new QQWry();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static {
        initClass();
    }

    public String evaluate(String s) {
        if (s == null || s.equals("")) {
            return null;
        }

        final IPZone zone = qqwry.findIP(s);

        return zone.getMainInfo();
        // return zone.getSubInfo();
    }
}
