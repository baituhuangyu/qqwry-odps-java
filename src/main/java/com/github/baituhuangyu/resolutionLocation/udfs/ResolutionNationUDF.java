package com.github.baituhuangyu.resolutionLocation.udfs;


public class ResolutionNationUDF extends ResolutionCommonUDF {

    public String evaluate(String s) {
        return super.evaluate(s, "nation");
    }
}
