package entity;

import java.util.Date;

public class Orders {
    private int order_id;
    private String serial_number;
    private int user_id;
    private double total_price;
    private boolean status;
    private String note;
    private String receive_name;
    private String receive_address;
    private String receive_phone;
    private Date create_at;
    private Date update_at;

    public Orders() {
    }

    public Orders(int order_id, String serial_number, int user_id, double total_price, boolean status, String note, String receive_name, String receive_address, String receive_phone, Date create_at, Date update_at) {
        this.order_id = order_id;
        this.serial_number = serial_number;
        this.user_id = user_id;
        this.total_price = total_price;
        this.status = status;
        this.note = note;
        this.receive_name = receive_name;
        this.receive_address = receive_address;
        this.receive_phone = receive_phone;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getReceive_address() {
        return receive_address;
    }

    public void setReceive_address(String receive_address) {
        this.receive_address = receive_address;
    }

    public String getReceive_phone() {
        return receive_phone;
    }

    public void setReceive_phone(String receive_phone) {
        this.receive_phone = receive_phone;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }



}
