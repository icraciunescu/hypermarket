package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.SaleProduct;
import java.util.List;

public interface SaleProductService {

    SaleProduct getById(Long id);
    List<SaleProduct> getAll();
    SaleProduct createSaleProduct(SaleProduct saleProduct);
    SaleProduct updateSaleProduct(SaleProduct saleProduct);
    void deleteSaleProduct(SaleProduct saleProduct);

}
