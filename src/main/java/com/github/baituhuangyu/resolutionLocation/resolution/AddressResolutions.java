package com.github.baituhuangyu.resolutionLocation.resolution;


import com.github.baituhuangyu.resolutionLocation.helper.fileHelper.RWTxt;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  从地址串中解析提取省市区
 */
public class AddressResolutions {
    private static String allNation;
    private static ArrayList<Pattern> PatternArr = new ArrayList<>();
    private static String[] regexGroupName = {"nation", "province", "city", "district", "village"};
    private static List<String> keyList = Arrays.asList(regexGroupName);
    private static String[] provinceList = {"北京市", "上海市", "天津市", "重庆市"};

    static {
        readData();
        String regex1 = allNation + "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<district>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        String regex2 = allNation + "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县|.*?区)?(?<district>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";

        String[] patternString = {regex1, regex2};
        List<String> patternStringList = Arrays.asList(patternString);
        patternStringList.forEach(
                s->PatternArr.add(Pattern.compile(s))
        );
    }

    public static void readData() {
        try {
            ArrayList<String> arr = RWTxt.ReadResourceStringLine("all_nation.txt");
            allNation = StringUtils
                    .join(arr, "|")
                    .replace("(", "（")
                    .replace(")", "）");

            allNation = String.format("(?<nation>%s)?", allNation);
//            arr.forEach(System.out::print);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Map<String, String> addressResolutions(String address){
        Map<String, String> addressMap = new HashMap<>(20);
        List<Pattern> PatternArrCopy;


        // 初始化，后面可能会覆盖
        PatternArrCopy = PatternArr;
        for (int i = 0; i < provinceList.length; i ++){
            PatternArrCopy = PatternArr.subList(1, 2);
            if (address.contains(provinceList[i])){
                PatternArrCopy = PatternArr.subList(1, 2);
            }
        }

        PatternArrCopy.forEach(p->{
            Matcher m = p.matcher(address);
            while (m.find()) {
                keyList.forEach(key->{
                    String value = m.group(key);
                    System.out.println(key);
                    System.out.println(value);
                    addressMap.computeIfAbsent(key, k -> value == null ? "": value.trim());
                });
            }
        });

        return addressMap;
    }
}