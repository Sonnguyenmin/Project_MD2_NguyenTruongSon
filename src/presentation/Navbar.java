package presentation;

import static util.Colors.*;

public class Navbar {
    public static void main(String[] args) {
        MenuAdmin();
    }
    public static void MenuAdmin() {
        System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ADMIN ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                                                                                    ┃");
        System.out.println("┃          " + PURPLE + "1. QUẢN LÝ DANH MỤC                    2. QUẢN LÝ NGƯỜI DÙNG              " + BLUE + "┃");
        System.out.println("┃          " + PURPLE + "3. QUẢN LÝ SẢN PHẨM                    4. QUẢN LÝ ĐƠN HÀNG                " + BLUE + "┃");
        System.out.println("┃          " + PURPLE + "5. THỐNG KÊ                            6. ĐĂNG XUẤT                       " + BLUE + "┃");
        System.out.println("┃                                                                                    ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
