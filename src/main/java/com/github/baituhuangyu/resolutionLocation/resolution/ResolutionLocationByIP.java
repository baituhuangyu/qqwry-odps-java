package com.github.baituhuangyu.resolutionLocation.resolution;


import java.io.IOException;


public class ResolutionLocationByIP {
    private static QQWry qqwry;

    private static void initClass()  {
        try {
            qqwry = new QQWry();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static {
        initClass();
    }

    public static String ResolutionIP(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        final IPZone zone = qqwry.findIP(s);
        return zone.getMainInfo();
//         return zone.getSubInfo();
    }
}
