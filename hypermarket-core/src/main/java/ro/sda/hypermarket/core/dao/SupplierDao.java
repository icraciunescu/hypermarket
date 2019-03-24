package ro.sda.hypermarket.core.dao;

import java.util.List;

public interface SupplierDao {

    Supplier getById(Long id);

    List<Supplier> getAll();

    Supplier createSupplier(Supplier supplier);

    Supplier updateSupplier(Supplier supplier);

    void deleteSupplier(Supplier supplier);

}