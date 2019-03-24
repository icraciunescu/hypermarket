package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;

import java.util.List;

public interface SaleProductDao {

    Session getCurrentSession();

    SaleProduct getById(Long id);

    List<SaleProduct> getAll();

    SaleProduct createSaleProduct(SaleProduct saleProduct);

    SaleProduct updateSaleProduct(SaleProduct saleProduct);

    void deleteSaleProduct(SaleProduct saleProduct);

}
