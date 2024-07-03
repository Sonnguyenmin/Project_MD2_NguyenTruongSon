package entity;

public class Order_Details {
    private int order_id;
    private int product_id;
    private String name;
    private double unit_price;
    private int order_quantity;

    public Order_Details() {
    }

    public Order_Details(int order_id, int product_id, String name, double unit_price, int order_quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.name = name;
        this.unit_price = unit_price;
        this.order_quantity = order_quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }


}
