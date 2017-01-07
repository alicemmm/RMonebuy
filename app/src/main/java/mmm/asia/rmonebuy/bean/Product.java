package mmm.asia.rmonebuy.bean;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by asia on 07/01/2017.
 */

public class Product extends BmobObject {
    private Integer id;
    private Integer type;
    private Float price;
    private String title;
    private String subTitle;
    private List<String> picList;
    private String introduce;
    private String couponUrl;
    private String buyUrl;
    private String quickBuy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getCouponUrl() {
        return couponUrl;
    }

    public void setCouponUrl(String couponUrl) {
        this.couponUrl = couponUrl;
    }

    public String getBuyUrl() {
        return buyUrl;
    }

    public void setBuyUrl(String buyUrl) {
        this.buyUrl = buyUrl;
    }

    public String getQuickBuy() {
        return quickBuy;
    }

    public void setQuickBuy(String quickBuy) {
        this.quickBuy = quickBuy;
    }
}
