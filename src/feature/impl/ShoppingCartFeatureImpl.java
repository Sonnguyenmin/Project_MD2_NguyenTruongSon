package feature.impl;

import entity.Products;
import entity.ShoppingCart;
import entity.User;
import feature.IShoppingCart;
import util.IOFiles;
import util.Messages;

import java.util.ArrayList;
import java.util.List;

import static util.Colors.*;

public class ShoppingCartFeatureImpl implements IShoppingCart {
    public static List<ShoppingCart> shoppingCartsList = (List<ShoppingCart>) IOFiles.readFromFile(IOFiles.SHOPPING_CART_PATH);

    public ShoppingCartFeatureImpl() {
    List<ShoppingCart> shoppingCarts = (List<ShoppingCart>) IOFiles.readFromFile(IOFiles.SHOPPING_CART_PATH);
    if (shoppingCarts == null) {
       // Nếu không đọc được dữ liệu từ file, khởi tạo danh sách shoppingCartsList trống
            shoppingCarts = new ArrayList<>();
        }
        shoppingCartsList = shoppingCarts;
    }

    @Override
    public List<ShoppingCart> getAll() {
        return shoppingCartsList;
    }

    @Override
    public void save(ShoppingCart element) {
        ShoppingCart shoppingCart = getByUserAndProduct(element.getUserId(), element.getProductId());
        if (findById(element.getShoppingCartId()) == null) {
            element.setShoppingCartId(getNewId());
            shoppingCartsList.add(element);
        }
        else {
            shoppingCart.setOrderQuantity(element.getOrderQuantity());
            shoppingCartsList.set(shoppingCartsList.indexOf(findById(element.getShoppingCartId())), element);
        }
        IOFiles.writeToFile(shoppingCartsList, IOFiles.SHOPPING_CART_PATH);
    }

    @Override
    public void delete(Integer id) {
        if (findById(id) == null) {
            System.out.println(Messages.NOT_FOUND);
        }
        shoppingCartsList.remove(findById(id));
        IOFiles.writeToFile(shoppingCartsList, IOFiles.SHOPPING_CART_PATH);
    }

    @Override
    public ShoppingCart findById(Integer id) {
        for (ShoppingCart shoppingCart : shoppingCartsList) {
            if (shoppingCart.getShoppingCartId() == id) {
                return shoppingCart;
            }
        }
        return null;
    }

    @Override
    public Integer getNewId() {
        int maxId = 0;
        for (ShoppingCart shoppingCart : shoppingCartsList) {
            if (shoppingCart.getShoppingCartId() > maxId) {
                maxId = shoppingCart.getShoppingCartId();
            }
        }
        return maxId + 1;
    }

    public ShoppingCart getByUserAndProduct(User user, Products product) {
        for (ShoppingCart shoppingCart : shoppingCartsList) {
            if (shoppingCart.getUserId().getUserId() == user.getUserId() && shoppingCart.getProductId().getProductId() == product.getProductId()) {
                return shoppingCart;
            }
        }
        return null;
    }


    // Giỏ hàng tăng
    public void productIncreases (Products product) {
        product.setStockQuantity(product.getStockQuantity() + 1);
    }

    // Giỏ hàng giảm
    public void productDecreases (Products product) {
        product.setStockQuantity(product.getStockQuantity() - 1);
    }

    //Giỏ hàng tăng theo số lượng
    public void ProductIncreasesByNumber (Products product, int number) {
        product.setStockQuantity(product.getStockQuantity() + number);
    }

    //Giỏ hàng giảm theo số lượng
    public void ProductDecreasesByNumber (Products product, int number) {
        product.setStockQuantity(product.getStockQuantity() - number);
    }
}
