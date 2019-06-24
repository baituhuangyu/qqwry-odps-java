package com.github.baituhuangyu.resolutionLocation;

import com.github.baituhuangyu.resolutionLocation.resolution.AddressResolutions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class AddressResolutionsTest {

    private static AddressResolutions addressResolutions;

    @BeforeAll
    private static void setUpBeforeClass() throws Exception {
        addressResolutions = new AddressResolutions();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addressResolution() {
        String s = "中国河南省郑州市";
//        String s = "中国";
//        String s = "河南省郑州市";
//        String s = "河南省";
//        String s = "中国河南省";
//        String s = "郑州市";
//        String s = "中国郑州市";
//        String s = "重庆市";
//        String s = "中国重庆市";
//        String s = "中国重庆市万州区";
//        String s = "中国重庆市忠县";
//        String s = "中国四川省成都市高新区";
        Map<String,String> rst = AddressResolutions.addressResolutions(s);
        rst.forEach((k, v)-> System.out.println(k+": "+v));

    }
}