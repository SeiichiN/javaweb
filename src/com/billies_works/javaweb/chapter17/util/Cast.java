package com.billies_works.javaweb.chapter17.util;

import java.util.List;

import com.billies_works.javaweb.chapter17.bean.ItemBean;

public class Cast {

    @SuppressWarnings("unchecked")
    public static List<ItemBean> castList(Object object) {
        return (List<ItemBean>)object;
    }

    @SuppressWarnings("unchecked")
    public static String castString(Object object) {
        return (String)object;
    }

    @SuppressWarnings("unchecked")
    public static int castInt(Object object) {
        return (int)object;
    }

    @SuppressWarnings("unchecked")
    public static boolean castBoolean(Object object) {
        return (boolean)object;
    }
    
}

// 修正時刻： Wed Mar 25 07:15:25 2020
