package entity;

public class Address {
    private int address_id;
    private int user_id;
    private String full_address;
    private String phone;
    private String receive_name;

    public Address() {
    }

    public Address(int address_id, int user_id, String full_address, String phone, String receive_name) {
        this.address_id = address_id;
        this.user_id = user_id;
        this.full_address = full_address;
        this.phone = phone;
        this.receive_name = receive_name;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }
}
