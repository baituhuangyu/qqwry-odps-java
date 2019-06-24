package com.github.baituhuangyu.resolutionLocation.udfs;


import com.aliyun.odps.udf.UDF;
import com.github.baituhuangyu.resolutionLocation.resolution.ResolutionLocationByIP;

public class ResolutionLocationUDF extends UDF{

    public String evaluate(String s) {
        return ResolutionLocationByIP.ResolutionIP(s);
    }
}
