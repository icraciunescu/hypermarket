package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SalesDao;
import ro.sda.hypermarket.core.entity.Sales;
import ro.sda.hypermarket.core.repository.SalesRepository;


import java.util.List;

@Service("salesService")
@Transactional(readOnly = true, rollbackFor = Exception.class)

public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesDao salesDao;

    @Autowired
    private SalesRepository salesRepository;


    @Override
    public Sales getById(Long id) {
        return null;
    }

    @Override
    public List<Sales> getAll() {
        return null;
    }

    @Override
    @Transactional
    public Sales createSales(Sales sales, boolean useHibernate) {
        if (useHibernate) {
            return salesDao.createSales(sales);
        }
        return salesRepository.save(sales);
    }
    @Override
    public Sales updateSales(Sales sales) {
        return null;
    }

    @Override
    public void deleteSales(Sales sales) {

    }
}
