package com.billies_works.javaweb.chapter17.util;

import java.util.List;

import com.billies_works.javaweb.chapter17.bean.ItemBean;

public class Cast {

    @SuppressWarnings("unchecked")
    public static List<ItemBean> castList(Object object) {
        return (List<ItemBean>)object;
    }
}
