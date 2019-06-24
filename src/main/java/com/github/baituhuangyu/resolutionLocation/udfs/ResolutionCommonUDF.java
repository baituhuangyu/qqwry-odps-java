package com.github.baituhuangyu.resolutionLocation.udfs;

import com.aliyun.odps.udf.UDF;
import com.github.baituhuangyu.resolutionLocation.resolution.ResolutionLocationMapByIP;

import java.util.Map;


public class ResolutionCommonUDF extends UDF {

    public String evaluate(String s, String key) {
        Map<String, String> locationMap = ResolutionLocationMapByIP.ResolutionMap(s);
        return locationMap.get(key);
    }
}
