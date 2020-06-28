package com.yunmi.app.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuyw
 */
public class MapUtil {

    /**
     * 从 map 获取Integer值
     * @param map
     * @param key
     * @return
     */
    public static int getValueInt(Map<String, Object> map, String key) {
        int value = 0;
        if (CollectionUtils.isNotEmpty(map)) {
            if (map.containsKey(key)) {
                Object obj = map.get(key);
                if (obj != null) {
                    value = Integer.parseInt(String.valueOf(obj));
                }
            }
        }
        return value;
    }

    /**
     * 从 map 获取字符串值
     * @param map
     * @param key
     * @return
     */
    public static String getValueStr(Map<String, Object> map, String key) {
        String value = "";
        if (CollectionUtils.isNotEmpty(map)) {
            if (map.containsKey(key)) {
                Object obj = map.get(key);
                if (obj != null) {
                    value = String.valueOf(obj);
                }
            }
        }
        return value;
    }

    /**
     * 从 map 获取key值
     * @param map
     * @return
     */
    public static String[] getKeyArr(Map<String, Object> map) {
        List<String> keys = new ArrayList<>();
        for (String key : map.keySet()) {
            keys.add(key);
        }
        return keys.toArray(new String[keys.size()]);
    }
}
