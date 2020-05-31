package com.teacher.system.util;

import java.util.Collection;
import java.util.Map;

public class PropertyUtils {
    public static boolean isNull(Object[] objs) {
        if (objs == null || objs.length == 0) {
            return true;
        }
        return false;
    }
    public static boolean isNull(Object obj) {
        if (obj == null || isNull(obj.toString())){
            return true;
        }
        return false;
    }

    public static boolean isNull(Integer integer) {
        if (integer == null || integer == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Map map) {
        if (map == null || map.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull(String str) {
        return str == null || "".equals(str.trim())
                || "null".equals(str.toLowerCase());
    }

    public static boolean isNull(Long longs) {
        if (longs == null || longs == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(Long longs) {
        return !isNull(longs);
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    public static boolean isNotNull(Collection collection) {
        return !isNull(collection);
    }

    public static boolean isNotNull(Map map) {
        return !isNull(map);
    }

    public static boolean isNotNull(Integer integer) {
        return !isNull(integer);
    }

    public static boolean isNotNull(Object[] objs) {
        return !isNull(objs);
    }
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
}
