package com.github.baituhuangyu.resolutionLocation.udfs;


public class ResolutionProvinceUDF extends ResolutionCommonUDF {

    public String evaluate(String s) {
        return super.evaluate(s, "province");
    }
}
