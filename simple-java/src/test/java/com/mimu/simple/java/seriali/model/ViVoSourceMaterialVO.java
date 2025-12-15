package com.mimu.simple.java.seriali.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ViVoSourceMaterialVO implements Serializable {
    private static final long serialVersionUID = -7142009478994166873L;

    private List<ViVoSourceMaterialItemVO> itemList;


    @Setter
    @Getter
    @ToString
    public static class ViVoSourceMaterialItemVO implements Serializable {
        private static final long serialVersionUID = 1768725354011097589L;

        /**
         * 标题
         */
        private String text;
        /**
         * 热榜类型 图片地址
         */
        private String hotText;
        /**
         * 新闻链接 h5 或者 端内链接
         */
        private String url;
        /**
         * 新闻链接 h5 或者 端内链接
         */
        private String deeplink;
    }
}