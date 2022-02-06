package com.wangshidai.eshopFront.pojo;

import java.sql.Timestamp;

public class GoodInfo {
    private Integer book_id; //书籍ID
    private String book_name; //书籍名称
    private String book_logo_small; //书籍logo图(小)
    private String book_logo_big; //书籍logo图(大)
    private Double book_price; //出售价
    private Double book_price_old; //原价
    private String book_author; //作者
    private String book_description; //商品详情概述
    private String book_press; //出版社
    private Integer type_id; //分类ID
    private Timestamp book_date; //添加书籍时间
    private Integer store_count; //库存
    private Integer status; //1上架 0下架
    private Integer is_new; //0非新品 其他任意正整数代表新品
    private Integer is_hot; //0非热销 其他任意正整数代表热销
    private Integer is_garbage; //0代表不是垃圾 1代表垃圾

    private Integer num; //书本数量

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_logo_small() {
        return book_logo_small;
    }

    public void setBook_logo_small(String book_logo_small) {
        this.book_logo_small = book_logo_small;
    }

    public String getBook_logo_big() {
        return book_logo_big;
    }

    public void setBook_logo_big(String book_logo_big) {
        this.book_logo_big = book_logo_big;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public Double getBook_price_old() {
        return book_price_old;
    }

    public void setBook_price_old(Double book_price_old) {
        this.book_price_old = book_price_old;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Timestamp getBook_date() {
        return book_date;
    }

    public void setBook_date(Timestamp book_date) {
        this.book_date = book_date;
    }

    public Integer getStore_count() {
        return store_count;
    }

    public void setStore_count(Integer store_count) {
        this.store_count = store_count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Integer getIs_garbage() {
        return is_garbage;
    }

    public void setIs_garbage(Integer is_garbage) {
        this.is_garbage = is_garbage;
    }

    @Override
    public String toString() {
        return "GoodInfo{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_logo_small='" + book_logo_small + '\'' +
                ", book_logo_big='" + book_logo_big + '\'' +
                ", book_price=" + book_price +
                ", book_price_old=" + book_price_old +
                ", book_author='" + book_author + '\'' +
                ", book_description='" + book_description + '\'' +
                ", book_press='" + book_press + '\'' +
                ", type_id=" + type_id +
                ", book_date=" + book_date +
                ", store_count=" + store_count +
                ", status=" + status +
                ", is_new=" + is_new +
                ", is_hot=" + is_hot +
                ", is_garbage=" + is_garbage +
                ", num=" + num +
                '}';
    }
}
