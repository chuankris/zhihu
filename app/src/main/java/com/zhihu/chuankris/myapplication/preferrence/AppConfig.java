package com.zhihu.chuankris.myapplication.preferrence;

/**
 * Created by qiuxuechuan on 2016/2/3.
 */
public class AppConfig {

/*
    *//**
     * 首页
     *//*
    public static final String URL_HOME = "http://rest.wufazhuce.com/OneForWeb/one/getHp_N";
    *//**
     * 文章
     *//*
    public static final String URL_ARTICLE = "http://rest.wufazhuce.com/OneForWeb/one/getC_N";
    *//**
     * 问题
     *//*
    public static final String URL_QUESTION = "http://rest.wufazhuce.com/OneForWeb/one/getQ_N";
    *//**
     * 东西
     *//*
    public static final String URL_THING = "http://rest.wufazhuce.com/OneForWeb/one/o_f";
    */
    /**
     * 喜欢/取消喜欢
     *//*
    public static final String URL_LIKE_OR_CANCLELIKE = "http://bea.wufazhuce.com/OneForWeb/onest/praiseAppItemSomeId";
    */





    private static String ONE_URL_BASE = "http://rest.wufazhuce.com/OneForWeb/one/";

    public static String getOneUrl() {
        return ONE_URL_BASE;
    }

    private static String ZHIHU_URL_BASE = "http://news-at.zhihu.com/api/4";

    public static String getZhihuUrl() {
        return ZHIHU_URL_BASE;
    }
}
