package entity;

import util.InputMethods;

import java.io.Serializable;

import static util.Colors.*;

public class Shopping_Cart implements Serializable {
    private int shopping_cart_id;
    private Products product_id;
    private User user_id;
    private int order_quantity;

    public Shopping_Cart() {
    }

    public Shopping_Cart(int shopping_cart_id, Products product_id, User user_id, int order_quantity) {
        this.shopping_cart_id = shopping_cart_id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.order_quantity = order_quantity;
    }

    public int getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public void inputData(User user, Products product) {
        this.user_id = user;
        this.product_id = product;
        System.out.println(BLUE + "Mời bạn nhập vào số lượng muốn mua: " + RESET);
        this.order_quantity = InputMethods.getIntegerQuantity(product);
    }

    public void displayData() {
//        System.out.println("+----+----------------+------------------+-------------------+");
//        System.out.println("| ID | Tên người dùng |   Tên sản phẩm   | Số lượng sản phẩm |");
//        System.out.println("+----+----------------+------------------+-------------------+");
        System.out.printf("| %-2d |   %-10s   |  %-14s  |       %-5d       |\n"
                ,this.shopping_cart_id ,this.getUser_id().getUserName(),this.getProduct_id().getProduct_name(), this.order_quantity);
        System.out.println("+----+----------------+------------------+-------------------+");
    }
}
