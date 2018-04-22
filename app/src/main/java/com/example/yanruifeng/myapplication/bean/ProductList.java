package com.example.yanruifeng.myapplication.bean;

import java.util.List;

/**
 * Created by yanruifeng on 2018/4/21.
 */

public class ProductList {

    /**
     * recordCount : 43
     * pageSize : 9
     * pageCount : 5
     * pno : 1
     * data : [{"lid":"1","title":"Apple MacBook Air 13.3英寸笔记本 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)","price":"6988.00","sold_count":"2968","is_onsale":"1","pic":"img/product/md/57b12a31N8f4f75a3.jpg"},{"lid":"27","title":"戴尔DELL灵越游匣15PR-5645B 15.6英寸游戏笔记本电脑(i5-7300HQ 8G 128GSSD+1T GTX1050 4G独显 FHD)黑","price":"5999.00","sold_count":"2110","is_onsale":"0","pic":"img/product/md/5913f8ffN49fa143c.jpg"},{"lid":"20","title":"戴尔DELL灵越燃7000 R1725G 14.0英寸轻薄窄边框笔记本电脑(i7-7500U 8G 128GSSD+1T 940MX 2G独显 FHD)金","price":"6599.00","sold_count":"1930","is_onsale":"1","pic":"img/product/md/57bbc38eN9def8042.jpg"},{"lid":"2","title":"Apple MacBook Air 13.3英寸笔记本 银色(Core i5 处理器/8GB内存/256GB SSD闪存 MMGG2CH/A)","price":"8268.00","sold_count":"1922","is_onsale":"0","pic":"img/product/md/57b12a31N8f4f75a3.jpg"},{"lid":"22","title":"戴尔DELL灵越游匣15PR-5745B 15.6英寸游戏笔记本电脑(i7-7700HQ 8G 128GSSD+1T GTX1050 4G独显 FHD)黑","price":"6999.00","sold_count":"1901","is_onsale":"1","pic":"img/product/md/5913f8ffN49fa143c.jpg"},{"lid":"29","title":"联想(ThinkPad)轻薄系列E470c(20H3A004CD)14英寸笔记本电脑(i5-6200U 8G 500G 2G独显 Win10)黑色","price":"4699.00","sold_count":"1862","is_onsale":"0","pic":"img/product/md/584b5678Nbc9f1e70.jpg"},{"lid":"43","title":"神舟(HASEE)战神Z6-KP7GT 15.6英寸游戏本笔记本电脑(i7-7700HQ 8G 1T+128G SSD GTX1050 1080P)黑色","price":"5699.00","sold_count":"1844","is_onsale":"1","pic":"img/product/md/58a2c667Ne2b5cb73.jpg"},{"lid":"5","title":"小米(MI)Air 13.3英寸全金属超轻薄笔记本(i5-6200U 8G 256G PCIE固态 940MX独显 FHD WIN10)银","price":"4999.00","sold_count":"1527","is_onsale":"1","pic":"img/product/md/57e3b072N661cd00d.jpg"},{"lid":"9","title":"联想(ThinkPad)轻薄系列E480c(20H3A00GCD)14英寸笔记本(i3-6006U 4G 500G 2G独显 Win10)黑色","price":"3499.00","sold_count":"1461","is_onsale":"1","pic":"img/product/md/584b5678Nbc9f1e70.jpg"}]
     */

    private int recordCount;
    private int pageSize;
    private int pageCount;
    private int pno;
    private List<DataBean> data;

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lid : 1
         * title : Apple MacBook Air 13.3英寸笔记本 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)
         * price : 6988.00
         * sold_count : 2968
         * is_onsale : 1
         * pic : img/product/md/57b12a31N8f4f75a3.jpg
         */

        private String lid;
        private String title;
        private String price;
        private String sold_count;
        private String is_onsale;
        private String pic;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSold_count() {
            return sold_count;
        }

        public void setSold_count(String sold_count) {
            this.sold_count = sold_count;
        }

        public String getIs_onsale() {
            return is_onsale;
        }

        public void setIs_onsale(String is_onsale) {
            this.is_onsale = is_onsale;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
