package entity;

import java.io.Serializable;

public class Wish_List implements Serializable  {
    private int wish_list_id;
    private User user_id;
    private Products product_id;

    public Wish_List() {
    }

    public Wish_List(int wish_list_id, User user_id, Products product_id) {
        this.wish_list_id = wish_list_id;
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public int getWish_list_id() {
        return wish_list_id;
    }

    public void setWish_list_id(int wish_list_id) {
        this.wish_list_id = wish_list_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    public void inputData(User user, Products product) {
        this.user_id = user;
        this.product_id = product;
    }

    public void displayData() {
//        System.out.println("+----+---------------------+--------------------+");
//        System.out.println("| ID |    Tên Người dùng   |    Tên sản phẩm    |");
//        System.out.println("+----+---------------------+--------------------+");
        System.out.printf("| %-2d |   %-15s   |  %-16s  |\n"
                ,this.wish_list_id, this.user_id.getUserName(), this.product_id.getProduct_name());
        System.out.println("+----+---------------------+--------------------+");

    }

}
