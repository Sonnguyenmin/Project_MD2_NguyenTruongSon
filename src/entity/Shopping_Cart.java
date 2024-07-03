package entity;

public class Shopping_Cart {
    private int shopping_cart_id;
    private int product_id;
    private int user_id;
    private int order_quantity;

    public Shopping_Cart() {
    }

    public Shopping_Cart(int shopping_cart_id, int product_id, int user_id, int order_quantity) {
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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }
}
