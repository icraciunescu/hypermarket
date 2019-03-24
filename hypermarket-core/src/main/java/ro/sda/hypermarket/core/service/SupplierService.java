package ro.sda.hypermarket.core.service;

import java.util.List;

public interface SupplierService {

    Supplier getById(Long id);
    List<Supplier> getAll();
    Supplier createSupplier(Supplier supplier);
    Supplier updateSupplier(Supplier supplier);
    void deleteSupplier(Supplier supplier);

}