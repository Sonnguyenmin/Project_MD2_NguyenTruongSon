package entity;

import util.InputMethods;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static util.Colors.*;

public class Products implements Serializable {
    private int product_id;
    private String sku;
    private String product_name;
    private String description;
    private double unit_price;
    private int stock_quantity;
    private String image;
    private Category category_id;
    private Date created_at;
    private Date updated_at;

    public Products() {
    }

    public Products(int product_id, String sku, String product_name, String description, double unit_price, int stock_quantity, String image, Category category_id, Date created_at, Date updated_at) {
        this.product_id = product_id;
        this.sku = sku;
        this.product_name = product_name;
        this.description = description;
        this.unit_price = unit_price;
        this.stock_quantity = stock_quantity;
        this.image = image;
        this.category_id = category_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
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

    public void inputData(List<Category> list) {
        this.sku = UUID.randomUUID().toString();
        System.out.println(BLUE + "Mời bạn nhập vào tên sản phẩm: " + RESET);
        this.product_name = InputMethods.getString();
        System.out.println(BLUE + "Mời bạn nhập vào mô tả sản phẩm: " + RESET);
        this.description = InputMethods.getString();
        System.out.println(BLUE + "Mời bạn nhập vào giá của sản phẩm: " + RESET);
        this.unit_price = InputMethods.getDoublePrice();
        System.out.println(BLUE + "Mời bạn nhập vào số lượng sản phẩm trong kho: " + RESET);
        this.stock_quantity = InputMethods.getIntegerStock();
        System.out.println(BLUE + "Mời nhập vào hình ảnh sản phẩm: " + RESET);
        this.image = InputMethods.getString();
        for (Category category : list) {
            category.displayData();
        }
        while (true) {
            boolean isExist = false;
            System.out.println(BLUE + "Mời bạn chon mã danh mục: "+ RESET);
            int idCategory = InputMethods.getInteger();
            for (Category category : list) {
                if (category.getCategory_id() == idCategory) {
                    this.category_id = category;
                    isExist =  true;
                    break;
                }
            }
            if (isExist) {
                break;
            } else {
                System.err.println(RED + "Không tồn tại danh mục, vui lòng nhâp lại..." + RESET);
            }
        }
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    public void displayData() {
        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
//
        System.out.printf("| %-2d | %-16s | %-12s | %-30s | %-10s   | %-3d      | %-15s  | %-14s | %-10s | %-10s  |\n"
                ,this.product_id, this.product_name, this.sku, this.description, vndFormat.format(this.unit_price), this.stock_quantity, this.image, this.category_id.getCategory_name(), this.created_at, this.updated_at);
        System.out.println("+----+------------------+--------------------------------------+--------------------------------+--------------+----------+------------------+----------------+------------------------------+-------------------------------+");
    }
}
