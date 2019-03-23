package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;


@Service("supplierService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public Supplier getById(Long id) {
        return supplierDao.getById(id);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDao.getAll();
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierDao.createSupplier(supplier);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierDao.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(Supplier supplier) {

    }
}