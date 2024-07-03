package entity;

import constants.Roles;
import util.InputMethods;

import java.io.Serializable;
import java.util.Date;

import static util.Colors.*;

public class User implements Serializable {
    private int user_id;
    private String fullName, userName, password, email, phone, address, avatar;
    private Date created_at, updated_at;
    private boolean gender;
    private Roles roles;
    private boolean status;

    public User() {
    }

    public User(int user_id, String fullName, String userName, String password, String email, String phone, String address, String avatar, Date created_at, Date updated_at, boolean gender, Roles roles, boolean status) {
        this.user_id = user_id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.gender = gender;
        this.roles = roles;
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData() {
        System.out.println("Mời nhập vào tên của bạn: ");
        this.fullName = InputMethods.getString();
        System.out.println("Mời nhập vào tên đăng nhập của bạn (Không được có dấu cách): ");
        this.userName = InputMethods.getString();
        System.out.print("Mời nhập vào mật khẩu của bạn (Không được có dấu cách và lớn hơn 6): ");
        this.password = InputMethods.getString();
        this.status = true;
        this.roles = Roles.ROLE_USER;
    }

    public void displayData() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Tên đăng nhập |   Vai trò  |              Email              |           Địa chỉ          | Số điện thoại | Trạng thái |       Ngày tạo               |  ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2d |    %-8s   | %-7s |          %-16s       |     %-16s    |  %-10s   |   %-8s | %-15s |\n"
                ,this.getUser_id(),this.getUserName(), this.getRoles(),this.getEmail(), this.getAddress(),this.getPhone()
                ,this.status  ? "Block" : "UnBlock", this.getCreated_at());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}


