package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductCategoryDao;
import ro.sda.hypermarket.core.entity.ProductCategory;
import ro.sda.hypermarket.core.repository.ProductCategoryRepository;
import java.util.List;

@Service("productCategoryService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory getById(Long id) {
        return productCategoryDao.getById(id);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.getAll();
    }

    @Override
    @Transactional
    public ProductCategory createProductCategory(ProductCategory productCategory, boolean useHibernate) {
        if (useHibernate) {
            return productCategoryDao.createProductCategory(productCategory);
        }
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        return productCategoryDao.updateProductCategory(productCategory);
    }

    @Override
    public void deleteProductCategory(ProductCategory productCategory) {

    }
}
