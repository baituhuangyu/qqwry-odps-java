package com.github.baituhuangyu.resolutionLocation.udfs;


import com.aliyun.odps.udf.annotation.Resolve;
import com.github.baituhuangyu.resolutionLocation.resolution.ResolutionLocationMapByIP;

import java.util.Map;

@Resolve("string->map<string,string>")
public class ResolutionMapUDF {

    public Map<String, String> evaluate(String s) {
        Map<String, String> locationMap = ResolutionLocationMapByIP.ResolutionMap(s);
        return locationMap;
    }
}
