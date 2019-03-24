package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Product;
import java.util.List;

public interface ProductService {

    Product getById(Long id);
    List<Product> getAll();
    Product createProduct(Product product, boolean useHibernate);
    Product updateProduct(Product product);
    void deleteProduct(Product product);

}
