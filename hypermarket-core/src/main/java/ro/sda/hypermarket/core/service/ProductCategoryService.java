package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryService {

    ProductCategory getById(Long id);
    List<ProductCategory> getAll();
    ProductCategory createProductCategory(ProductCategory productCategory);
    ProductCategory updateProductCategory(ProductCategory productCategory);
    void deleteProductCategory(ProductCategory productCategory);

}
