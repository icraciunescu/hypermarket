package ro.sda.hypermarket.core.dao;


import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierDao {

    Supplier getById(Long id);
    List<Supplier> getAll();
    Supplier createSupplier(Supplier supplier);
    Supplier updateSupplier(Supplier supplier);
    void deleteSupplier(Supplier supplier);

}