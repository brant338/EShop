package com.wangshidai.eshop_front.pojo;

public class GoodsInfo {
    private Integer book_id;
    private String book_name;
    private String book_logo_small;
    private String book_logo_big;
    private Double book_price;
    private Double book_price_old;
    private String book_author;

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

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_logo_small='" + book_logo_small + '\'' +
                ", book_logo_big='" + book_logo_big + '\'' +
                ", book_price=" + book_price +
                ", book_price_old=" + book_price_old +
                ", book_author='" + book_author + '\'' +
                '}';
    }
}
