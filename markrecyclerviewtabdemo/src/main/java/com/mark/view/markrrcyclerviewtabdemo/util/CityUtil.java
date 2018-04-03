package com.mark.view.markrrcyclerviewtabdemo.util;


import com.mark.view.markrrcyclerviewtabdemo.R;
import com.mark.view.markrrcyclerviewtabdemo.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin
 * Created date 17/5/31
 * Created log
 */

public class CityUtil {
    /**
     * 获取城市名
     *
     * @return
     */
    public static List<City> getCityList() {
        List<City> dataList = new ArrayList<>();
        final String FU_JIAN = "负责人";
        final int FU_JIAN_ICON = R.mipmap.city1;
        dataList.add(new City("福州", FU_JIAN, FU_JIAN_ICON));
        dataList.add(new City("厦门", FU_JIAN, FU_JIAN_ICON));
        dataList.add(new City("泉州", FU_JIAN, FU_JIAN_ICON));
        dataList.add(new City("宁德", FU_JIAN, FU_JIAN_ICON));
        dataList.add(new City("漳州", FU_JIAN, FU_JIAN_ICON));
        final String AN_HUI = "代理人";
        final int AN_HUI_ICON = R.mipmap.city2;
        dataList.add(new City("合肥", AN_HUI, AN_HUI_ICON));
        dataList.add(new City("芜湖", AN_HUI, AN_HUI_ICON));
        dataList.add(new City("蚌埠", AN_HUI, AN_HUI_ICON));
        final String ZHE_JIANG = "匠人";
        final int ZHE_JIANG_ICON = R.mipmap.city3;
        dataList.add(new City("杭州", ZHE_JIANG, ZHE_JIANG_ICON));
        dataList.add(new City("宁波", ZHE_JIANG, ZHE_JIANG_ICON));
        dataList.add(new City("温州", ZHE_JIANG, ZHE_JIANG_ICON));
        dataList.add(new City("嘉兴", ZHE_JIANG, ZHE_JIANG_ICON));
        dataList.add(new City("绍兴", ZHE_JIANG, ZHE_JIANG_ICON));
        dataList.add(new City("金华", ZHE_JIANG, ZHE_JIANG_ICON));
        dataList.add(new City("湖州", ZHE_JIANG, ZHE_JIANG_ICON));
        dataList.add(new City("舟山", ZHE_JIANG, ZHE_JIANG_ICON));
        return dataList;
    }
}
