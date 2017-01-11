package mmm.asia.rmonebuy.bean;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by asia on 07/01/2017.
 */

public class TestProduct extends BmobObject {
    private Integer id;
    private Integer type;
    private Float price;
    private String title;
    private List<BmobFile> picFiles;

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

    public List<BmobFile> getPicFiles() {
        return picFiles;
    }

    public void setPicFiles(List<BmobFile> picFiles) {
        this.picFiles = picFiles;
    }
}
