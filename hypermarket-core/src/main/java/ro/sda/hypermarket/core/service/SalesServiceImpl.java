package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Sales;
import ro.sda.hypermarket.core.repository.SupplierRepository;

import java.util.List;

@Service("salesService")
@Transactional(readOnly = true, rollbackFor = Exception.class)

public class SalesServiceImpl implements SalesService {

    @Override
    public Sales getById(Long id) {
        return null;
    }

    @Override
    public List<Sales> getAll() {
        return null;
    }

    @Override
    public Sales createSales(Sales sales) {

        return null;
    }

    @Override
    public Sales updateSales(Sales sales) {
        return null;
    }

    @Override
    public void deleteSales(Sales sales) {

    }
}
