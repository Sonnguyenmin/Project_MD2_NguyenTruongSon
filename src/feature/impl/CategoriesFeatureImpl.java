package feature.impl;


import entity.Category;
import entity.Products;
import feature.ICategory;
import util.IOFiles;
import util.Messages;

import java.util.ArrayList;
import java.util.List;

import static util.Colors.*;

public class CategoriesFeatureImpl implements ICategory {

    public static List<Category> categoryList;

    public CategoriesFeatureImpl() {
        List<Category> categories = (List<Category>) IOFiles.readFromFile(IOFiles.CATEGORY_PATH);
        if (categories == null) {
            // Nếu không đọc được dữ liệu từ file, khởi tạo danh sách categoryList trống
            categories = new ArrayList<>();
        }
        categoryList = categories;
    }

    @Override
    public List<Category> getAll() {
        return categoryList;
    }

    @Override
    public void save(Category element) {
        if (findById(element.getCategory_id()) == null) {
            categoryList.add(element);
        }
        else {
            categoryList.set(categoryList.indexOf(findById(element.getCategory_id())), element);
        }
        IOFiles.writeToFile(categoryList, IOFiles.CATEGORY_PATH);
    }

    @Override
    public void delete(Integer id) {
//        Category indexDelete = findById(id);
//        if (indexDelete != null) {
//            boolean isExist = ProductsFeatureImpl.productList.stream().anyMatch(item -> item.getCategory_id().getCategory_id() == id);
//            if (isExist) {
//                System.err.println("Không được xóa danh mục khi có sản phẩm");
//            } else {
//                categoryList.remove(indexDelete);
//            }
//        }else {
//            System.err.println(RED + "Không có danh mục nào như vậy");
//        }
//        IOFiles.writeToFile(categoryList, IOFiles.CATEGORY_PATH);
        Category indexDelete = findById(id);
        if (indexDelete != null) {
            boolean isExist = false;
            for (int i = 0; i< ProductsFeatureImpl.productList.size(); i++){
                if (ProductsFeatureImpl.productList.get(i).getCategory_id().getCategory_id() == id){
                    isExist = true;
                    break;
                }
            }
            if (isExist){
                System.err.println(RED + "Không được xóa danh mục khi có sản phẩm" + RESET);
            }else {
                categoryList.remove(indexDelete);
                System.out.println(GREEN + "Đã xóa thành công danh mục " + RESET);
            }
        }else {
            System.err.println(RED + "Không có danh mục nào như vậy");
        }
        IOFiles.writeToFile(categoryList, IOFiles.CATEGORY_PATH);
    }

    @Override
    public Category findById(Integer id) {
       for (Category category : categoryList) {
           if (category.getCategory_id() == id) {
               return category;
           }
       }
       return null;
    }

    @Override
    public Integer getNewId() {
        int maxId = 0;
        for (Category category : categoryList) {
            if (category.getCategory_id() > maxId) {
                maxId = category.getCategory_id();
            }
        }
        return maxId + 1;
    }
}
