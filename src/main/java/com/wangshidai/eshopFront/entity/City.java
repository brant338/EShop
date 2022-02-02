package com.wangshidai.eshopFront.entity;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {

    private Integer id;
    private String cityid;
    private String city;
    private String provinceid;

    private List<Area> areas;

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityid='" + cityid + '\'' +
                ", city='" + city + '\'' +
                ", provinceid='" + provinceid + '\'' +
                ", areas=" + areas +
                '}';
    }
}
