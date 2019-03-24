package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Sales;
import java.util.List;

public interface SalesService {


    Sales getById(Long id);
    List<Sales> getAll();
    Sales createSales(Sales sales);
    Sales updateSales(Sales sales);
    void deleteSales(Sales sales);

}
