package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductDao;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.repository.ProductRepository;


import java.util.List;


@Service("productService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    @Transactional
    public Product createProduct(Product product, boolean useHibernate) {
        if (useHibernate) {
            return productDao.createProduct(product);
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {

    }
}

