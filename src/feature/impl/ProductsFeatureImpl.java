package feature.impl;

import entity.Products;

import entity.ShoppingCart;
import feature.IProduct;
import util.IOFiles;
import util.Messages;

import java.util.ArrayList;
import java.util.List;

import static util.Colors.GREEN;
import static util.Colors.RESET;

public class ProductsFeatureImpl implements IProduct {

    public static List<Products> productList = (List<Products>) IOFiles.readFromFile(IOFiles.PRODUCT_PATH);

    public ProductsFeatureImpl() {
        List<Products> products = (List<Products>) IOFiles.readFromFile(IOFiles.PRODUCT_PATH);
        if (products == null) {
            // Nếu không đọc được dữ liệu từ file, khởi tạo danh sách productList trống
            products = new ArrayList<>();
        }
        productList = products;
    }

    @Override
    public List<Products> getAll() {
        return productList;
    }

    @Override
    public void save(Products element) {
        if (findById(element.getProductId()) == null) {
            productList.add(element);
        }
        else {
            productList.set(productList.indexOf(findById(element.getProductId())), element);
        }
        IOFiles.writeToFile(productList, IOFiles.PRODUCT_PATH);
    }

    @Override
    public void delete(Integer id) {
        if (findById(id) == null) {
            System.out.println(Messages.NOT_FOUND);
        }
        productList.remove(findById(id));
        IOFiles.writeToFile(productList, IOFiles.PRODUCT_PATH);
    }

    @Override
    public Products findById(Integer id) {
        for (Products product : productList) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Integer getNewId() {
        int maxId = 0;
        for (Products product : productList) {
            if (product.getProductId() > maxId) {
                maxId = product.getProductId();
            }
        }
        return maxId + 1;
    }


    // Giỏ hàng tăng
    public void shoppingCartIncreases (ShoppingCart shoppingCart) {
        shoppingCart.setOrderQuantity(shoppingCart.getOrderQuantity() + 1);
    }
    // Giỏ hàng giảm
    public void shoppingCartReduce (ShoppingCart shoppingCart) {
        shoppingCart.setOrderQuantity(shoppingCart.getOrderQuantity() - 1);
    }
    // Tăng Giỏ hàng theo số lượng
    public void shoppingCartIncreasesByNumber (ShoppingCart shoppingCart, int number) {
        shoppingCart.setOrderQuantity(shoppingCart.getOrderQuantity() + number);
    }
    //Giảm Giỏ hàng theo số lượng
    public void shoppingCartDecreasesByNumber (ShoppingCart shoppingCart, int number) {
        shoppingCart.setOrderQuantity(shoppingCart.getOrderQuantity() - number);
    }

}
