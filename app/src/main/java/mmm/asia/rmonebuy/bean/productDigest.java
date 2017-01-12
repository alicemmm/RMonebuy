package mmm.asia.rmonebuy.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by asia on 12/01/2017.
 */

public class ProductDigest extends BmobObject {
    private Integer productId;
    private BmobFile icon;
    private String title;
    private String subTitle;
    private String introduce;
    private String price;
    private String typeContent; //类型
    private String productType; //商品类别
    private String fromMarket; // 来源
    private String canBuyPoint; //推荐指数

    private String couponUrl; //领券地址
    private String buyUrl; // 购买地址
    private String quickBuy; //快速购买代码

    private BmobFile slidePicOne;// 预留轮播图
    private BmobFile slidePicTwo;

    private String reserved; //预留参数

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BmobFile getIcon() {
        return icon;
    }

    public void setIcon(BmobFile icon) {
        this.icon = icon;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getFromMarket() {
        return fromMarket;
    }

    public void setFromMarket(String fromMarket) {
        this.fromMarket = fromMarket;
    }

    public String getCanBuyPoint() {
        return canBuyPoint;
    }

    public void setCanBuyPoint(String canBuyPoint) {
        this.canBuyPoint = canBuyPoint;
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

    public BmobFile getSlidePicOne() {
        return slidePicOne;
    }

    public void setSlidePicOne(BmobFile slidePicOne) {
        this.slidePicOne = slidePicOne;
    }

    public BmobFile getSlidePicTwo() {
        return slidePicTwo;
    }

    public void setSlidePicTwo(BmobFile slidePicTwo) {
        this.slidePicTwo = slidePicTwo;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
}
