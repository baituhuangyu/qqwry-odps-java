package com.github.baituhuangyu.resolutionLocation.resolution;

import java.util.Map;

public class ResolutionLocationMapByIP {

    public static Map<String, String> ResolutionMap(String s) {
        String locationString = ResolutionLocationByIP.ResolutionIP(s);
        return AddressResolutions.addressResolutions(locationString);
    }
}
