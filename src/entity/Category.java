package entity;

import util.InputMethods;

import java.io.Serializable;

public class Category implements Serializable {
    private int category_id;
    private String category_name;
    private String description;
    private boolean status;

    public Category() {
    }

    public Category(int category_id, String category_name, String description, boolean status) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.description = description;
        this.status = status;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData() {
        System.out.println("Mời bạn nhập vào tên danh mục: ");
        this.category_name = InputMethods.getString();
        System.out.println("Mời bạn nhập vào mô tả danh mục: ");
        this.description = InputMethods.getString();
        System.out.println("Mời bạn nhập vào trạng thái danh mục: ");
        this.status = InputMethods.getBoolean();
    }


    public void displayData() {
//        System.out.println("+----+--------------+----------------------------------------------+--------------------+");
//        System.out.println("| ID | Tên danh mục |               Mô tả danh mục                 |     Trạng thái     |");
//        System.out.println("+----+--------------+----------------------------------------------+--------------------+");
        System.out.printf("| %-2d | %-16s     | %-36s         | %-16s   |\n"
                ,this.category_id,this.category_name, this.description,this.status  ? "Hiển thị" : "Không hiển thị");
        System.out.println("+----+----------------------+----------------------------------------------+--------------------+");
    }
}

