package presentation.users;

import entity.Products;
import entity.ShoppingCart;
import entity.User;
import feature.impl.ProductsFeatureImpl;
import feature.impl.ShoppingCartFeatureImpl;
import presentation.run.MenuManagement;
import util.IOFiles;
import util.InputMethods;
import util.Messages;

import static feature.impl.ShoppingCartFeatureImpl.shoppingCartsList;
import static util.Colors.*;

public class ShoppingCartManagement {
    public ProductsFeatureImpl productsFeature = new ProductsFeatureImpl();
    public ShoppingCartFeatureImpl shoppingCartFeature = new ShoppingCartFeatureImpl();

    public ShoppingCartManagement() {
        boolean isExist = true;
        do {
            System.out.println();
            System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ GIỎ HÀNG ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                                                                                    ┃");
            System.out.println("┃         " + PURPLE + "1. Xem danh sách sản phẩm                                                  " + BLUE + "┃");
            System.out.println("┃         " + PURPLE + "2. Thêm vào giỏ hàng                                                       " + BLUE + "┃");
            System.out.println("┃         " + PURPLE + "3. Xem tất cả sản phẩm giỏ hàng                                            " + BLUE + "┃");
            System.out.println("┃         " + PURPLE + "4. Xóa 1 sản phẩm trong giỏ hàng                                           " + BLUE + "┃");
            System.out.println("┃         " + PURPLE + "5. Xóa toàn bộ sản phẩm trong giỏ hàng                                     " + BLUE + "┃");
            System.out.println("┃         " + PURPLE + "6. Đặt hàng                                                                " + BLUE + "┃");
            System.out.println("┃         " + PURPLE + "7. Quay lại                                                                " + BLUE + "┃");
            System.out.println("┃                                                                                    ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println(Messages.CHOICE);
            int choice = InputMethods.getInteger();
            System.out.println();
            switch (choice) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    inputAddProductToCart();
                    break;
                case 3:
                    showAllCart();
                    break;
                case 4:
                    deleteProductInCartByShoppingCart();
                    break;
                case 5:
                    clearAllProductInCart();
                    break;
                case 6:
                    new OrderManagement();
                    break;
                case 7:
                    isExist = false;
                    break;
                default:
                    System.err.println(RED + "Vui lòng nhập lại từ 1 -> 7" + RESET);
            }
        } while (isExist);
    }

    public void showAllProducts() {
        if (productsFeature.getAll().isEmpty()) {
            System.out.println(Messages.IS_EMPTY);
            return;
        }
        System.out.println("+----+------------------+--------------------------------------+----------------------------------+--------------+----------+------------------+----------------+------------+-------------------+");
        System.out.println("| ID |   Tên sản phẩm   |              sku                     |        Mô tả sản phẩm            | Giá sản phẩm | Số lượng |       image      |  danh mục      |  Ngày tạo  |   Ngày cập nhật   |");
        System.out.println("+----+------------------+--------------------------------------+----------------------------------+--------------+----------+------------------+----------------+------------+-------------------+");
        for (Products products : productsFeature.getAll()) {
            if(products.getStockQuantity() > 0) {
                products.displayData();
            }
        }
    }


    public void showAllCart() {
        User user = MenuManagement.userLogin;
        if (user == null) {
            System.err.println("Vui lòng đăng nhập để xem giỏ hàng!");
            return;
        }
        if (shoppingCartFeature.getAll().stream().filter(item-> item.getUserId().getUserId() == user.getUserId()).count() <= 0) {
            System.out.println(Messages.IS_EMPTY);
            return;
        }
        System.out.println("+----+----------------+------------------+-------------------+");
        System.out.println("| ID | Tên người dùng |   Tên sản phẩm   | Số lượng sản phẩm |");
        System.out.println("+----+----------------+------------------+-------------------+");
        for (ShoppingCart shoppingCart : shoppingCartFeature.getAll()) {
            if (shoppingCart.getUserId().getUserId() == user.getUserId()) {
                shoppingCart.displayData();
            }
        }
    }

    public void inputAddProductToCart() {
        showAllCart();
        User user = MenuManagement.userLogin;
        Products addProduct = null;
        System.out.println(BLUE + "Mời bạn nhập vào mã sản phẩm: " + RESET);
        int number = InputMethods.getInteger();
        boolean isExist = false;
        for (Products products : productsFeature.getAll()) {
            if (products.getProductId() == number) {
                addProduct = products;
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.err.println(RED + "Mã sản phẩm này không tồn tại!" + RESET);
        } else {
            ShoppingCart shoppingCart = shoppingCartFeature.getByUserAndProduct(user, addProduct);
            if (shoppingCart != null) {
                System.out.println(BLUE + "Mời bạn nhập vào số lượng muốn thêm: " + RESET);
                int countQuantity = InputMethods.getInteger();
                shoppingCart.setOrderQuantity(shoppingCart.getOrderQuantity() + countQuantity);
                shoppingCartFeature.save(shoppingCart);
            } else {
                ShoppingCart newCartItem = new ShoppingCart();
                newCartItem.inputData(user, addProduct);
                shoppingCartFeature.save(newCartItem);
            }
            System.out.println(GREEN + "Đã thêm sản phẩm vào giỏ hàng..." + RESET);
        }
    }

    public void deleteProductInCartByShoppingCart() {
        System.out.println(BLUE + "Mời nhập mã sản phẩm muốn xóa có trong giỏ hàng: "+ RESET);
        int IdShoppingCart = InputMethods.getInteger();
        shoppingCartFeature.delete(IdShoppingCart);
        System.out.println(GREEN + "Đã xóa thành công sản phẩm trong giỏ hàng!" + RESET);
//        User user = MenuManagement.userLogin;
//        System.out.println(BLUE + "Mời nhập mã sản phẩm muốn xóa có trong giỏ hàng: " + RESET);
//        int shoppingCartId = InputMethods.getInteger();
//        ShoppingCart shoppingCartToRemove = null;
//        for (ShoppingCart shoppingCart : shoppingCartFeature.getAll()) {
//            if (shoppingCart.getShoppingCartId() == shoppingCartId && shoppingCart.getUserId().getUserId() == user.getUserId()) {
//                shoppingCartToRemove = shoppingCart;
//                break;
//            }
//        }
//
//        if (shoppingCartToRemove != null) {
//            shoppingCartFeature.delete(shoppingCartToRemove);
//            System.out.println(GREEN + "Đã xóa thành công sản phẩm trong giỏ hàng!" + RESET);
//        } else {
//            System.err.println(RED + "Không tìm thấy sản phẩm với mã số đã nhập trong giỏ hàng!" + RESET);
//        }
    }

    public void clearAllProductInCart() {
        User user = MenuManagement.userLogin;
        shoppingCartsList = shoppingCartFeature.getAll().stream().filter(item -> item.getUserId().getUserId() != user.getUserId()).toList();
        IOFiles.writeToFile(shoppingCartsList, IOFiles.SHOPPING_CART_PATH);
        System.out.println(GREEN + "Đã xóa thành công tất cả sản phẩm trong giỏ hàng!" + RESET);
    }
}
