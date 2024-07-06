package entity;

import constants.OrderStatus;
import util.InputMethods;
import util.Validate;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Orders implements Serializable {
    private int orderId;
    private String serialNumber;
    private User userId;
    private double totalPrice;
    private OrderStatus orderStatus;
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String receivePhone;
    private Date createAt;
    private Date receivedAt;

    public Orders() {
    }

    public Orders(int orderId, String serialNumber, User userId, double totalPrice, OrderStatus orderStatus, String note, String receiveName, String receiveAddress, String receivePhone, Date createAt, Date receivedAt) {
        this.orderId = orderId;
        this.serialNumber = serialNumber;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.note = note;
        this.receiveName = receiveName;
        this.receiveAddress = receiveAddress;
        this.receivePhone = receivePhone;
        this.createAt = createAt;
        this.receivedAt = receivedAt;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public void inputData(User user, Address address, Products products, double totalPrice) {
        this.serialNumber = UUID.randomUUID().toString();
        this.userId = user;
        this.totalPrice = totalPrice;
        this.receiveAddress = address.getFullAddress();
        this.receivePhone = address.getPhone();
        this.receiveName = address.getReceiveName();
        this.orderStatus = OrderStatus.WAITING;
        this.note = InputMethods.getNode();
        this.createAt = new Date();
        this.receivedAt = Validate.inputReceiveAt(this.createAt);
    }

    public void displayData() {
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("+----+---------------------------------+-----------------+---------------------+--------------------------------------+--------------+---------------+");
        System.out.println("| ID |     Tên khách hàng, Số seri     |    Tổng tiền    | Trạng thái đơn hàng |   Địa chỉ, Người nhận, Số điện thoại |   Ngày mua   |   Ngày nhân   |");
        System.out.println("+----+---------------------------------+-----------------+---------------------+--------------------------------------+--------------+---------------+");

        String formPrintFirst = "| %-3d |  %-29s  |  %-13  |   %-15s   |    %-30s   | %-12s | %-12s |";
        String formPrintNext =  "|      |  %-29s  |        |           |    %-30s   |       |       |";
        String formPrintLast =  "|      |         |        |           |    %-30s   |       |       |";
        System.out.printf(formPrintFirst, this.orderId, this.userId.getUserName(), vndFormat.format(this.totalPrice), this.orderStatus, this.receiveName, sdf.format(this.createAt), sdf.format(this.receivedAt));
        System.out.printf(formPrintNext, this.orderId, this.serialNumber, this.totalPrice, this.orderStatus, this.receiveAddress, sdf.format(this.createAt), sdf.format(this.receivedAt));
        System.out.printf(formPrintLast, this.orderId, this.userId.getUserName(), this.totalPrice, this.orderStatus, this.receivePhone, sdf.format(this.createAt), sdf.format(this.receivedAt));
        System.out.println("+----+---------------------------------+-----------------+---------------------+--------------------------------------+--------------+---------------+");
    }
}

