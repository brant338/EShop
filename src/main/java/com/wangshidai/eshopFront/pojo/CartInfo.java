package com.wangshidai.eshopFront.pojo;

public class CartInfo {
    private int book_id; //书ID
    private int num;     //书的数量
    private int user_id; //用户ID

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "book_id='" + book_id + '\'' +
                ", num='" + num + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
