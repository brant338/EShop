package com.wangshidai.eshopFront.entity;

import java.io.Serializable;
import java.util.List;

public class Province implements Serializable {

    private Integer id;
    private String provinceid;
    private String province;

    /*private List<City> citys;

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /*@Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceid='" + provinceid + '\'' +
                ", province='" + province + '\'' +
                ", citys=" + citys +
                '}';
    }*/
}
