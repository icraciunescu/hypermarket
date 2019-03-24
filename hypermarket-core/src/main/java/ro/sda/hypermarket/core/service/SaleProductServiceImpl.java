package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SaleProductDao;
import ro.sda.hypermarket.core.entity.SaleProduct;
import ro.sda.hypermarket.core.repository.SaleProductRepository;
import java.util.List;

@Service("saleProductService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SaleProductServiceImpl implements SaleProductService {

    @Autowired
    private SaleProductDao saleProductDao;

    @Autowired
    private SaleProductRepository saleProductRepository;

    @Override
    public SaleProduct getById(Long id) {
        return saleProductDao.getById(id);
    }

    @Override
    public List<SaleProduct> getAll() {
        return saleProductDao.getAll();
    }

    @Override
    @Transactional
    public SaleProduct createSaleProduct(SaleProduct saleProduct, boolean useHibernate) {
        if (useHibernate) {
            return saleProductDao.createSaleProduct(saleProduct);
        }
        return saleProductRepository.save(saleProduct);
    }

    @Override
    public SaleProduct updateSaleProduct(SaleProduct saleProduct) {
        return saleProductDao.updateSaleProduct(saleProduct);
    }

    @Override
    public void deleteSaleProduct(SaleProduct saleProduct) {

    }
}