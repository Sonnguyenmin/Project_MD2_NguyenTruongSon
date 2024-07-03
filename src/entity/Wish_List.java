package entity;

public class Wish_List {
    private int wish_list_id;
    private int user_id;
    private int product_id;

    public Wish_List() {
    }

    public Wish_List(int wish_list_id, int user_id, int product_id) {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
