package com.github.baituhuangyu.resolutionLocation.udfs;



public class ResolutionCityUDF extends ResolutionCommonUDF {

    public String evaluate(String s) {
        return super.evaluate(s, "city");
    }
}
