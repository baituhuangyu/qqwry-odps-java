package com.github.baituhuangyu.resolutionLocation.udfs;



public class ResolutionDistrictUDF extends ResolutionCommonUDF {

    public String evaluate(String s) {
        return super.evaluate(s, "district");
    }
}
