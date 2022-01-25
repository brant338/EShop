package com.wangshidai.eshop_front.entity;

import java.io.Serializable;

/**
 * @author brant
 * @version V1.0
 * @Package cn.brant.entity
 * @date 2021/9/5 19:13
 * @Copyright © 暂无
 */
public class ResultBean implements Serializable {
    //服务器端是否出现异常
    private Boolean flag;
    //服务器端处理请求之后要响应的数据
    private Object data;
    //服务器端的异常信息
    private String errorMessage;

    public ResultBean(Boolean flag) {
        this.flag = flag;
    }

    public ResultBean(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
