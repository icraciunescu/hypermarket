package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryDao {

    Session getCurrentSession();
    ProductCategory getById(Long id);
    List<ProductCategory> getAll();
    ProductCategory createProductCategory(ProductCategory productCategory);
    ProductCategory updateProductCategory(ProductCategory productCategory);
    void deleteProductCategory(ProductCategory productCategory);

}
