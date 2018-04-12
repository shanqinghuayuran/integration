package com.example.yanruifeng.myapplication.bean;

import java.util.List;

/**
 * Created by yanruifeng on 2018/4/11.
 * @author yanruifeng
 */

public class Product{

    private List<CarouselItemsBean> carouselItems;

    public List<CarouselItemsBean> getCarouselItems() {
        return carouselItems;
    }

    public void setCarouselItems(List<CarouselItemsBean> carouselItems) {
        this.carouselItems = carouselItems;
    }

    public static class CarouselItemsBean {
        /**
         * cid : 1
         * img : img/index/banner1.png
         * title : 轮播广告商品1
         * href : product_details.html?lid=28
         */

        private String cid;
        private String img;
        private String title;
        private String href;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}
