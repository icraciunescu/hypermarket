package Dao;


import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierDaoImpl {

    Session getCurrentSession();

    Supplier getById(Long id);
    List<Supplier> getAll();
    Supplier createSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Supplier supplier);

}