package presentation.admin;

import entity.User;
import feature.impl.UserFeatureImpl;
import util.InputMethods;
import util.Messages;

import static util.Colors.BLUE;
import static util.Colors.PURPLE;

public class MenuAdminManagement {
    private static User admin;
    private static UserFeatureImpl userFeature;

    public MenuAdminManagement() {
        boolean isExist = true;
        do {
            System.out.println();
            System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ADMIN ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                                                                                    ┃");
            System.out.println("┃          " + PURPLE + "1. QUẢN LÝ DANH MỤC                    3. QUẢN LÝ NGƯỜI DÙNG              " + BLUE + "┃");
            System.out.println("┃          " + PURPLE + "2. QUẢN LÝ SẢN PHẨM                    4. QUẢN LÝ ĐƠN HÀNG                " + BLUE + "┃");
            System.out.println("┃          " + PURPLE + "5. THỐNG KÊ                            6. ĐĂNG XUẤT                       " + BLUE + "┃");
            System.out.println("┃                                                                                    ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println(Messages.CHOICE);
            int choice = InputMethods.getInteger();
            System.out.println();
            switch (choice) {
                case 1:
                    new CategoryManagement();
                    break;
                case 2:
                    new ProductManagement();
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");

            }
        }while (isExist);
    }
}
