package com.wangshidai.eshopFront.pojo;

public class GoodPicInfo {
    private Integer pic_id;
    private String pic_name;

    public Integer getPic_id() {
        return pic_id;
    }

    public void setPic_id(Integer pic_id) {
        this.pic_id = pic_id;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    @Override
    public String toString() {
        return "GoodPicInfo{" +
                "pic_id=" + pic_id +
                ", pic_name='" + pic_name + '\'' +
                '}';
    }
}
