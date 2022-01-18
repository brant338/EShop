package com.wangshidai.eshop_front.pojo;

public class TypeInfo {
    private Integer type_id;
    private String type_name;
    private Integer parent_id;

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "productType{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                ", parent_id=" + parent_id +
                '}';
    }
}
