package ro.sda.hypermarket.core.service;

import java.util.List;

public interface SalesService {


    Sales getById(Long id);
    List<Sales> getAll();
    Sales createSales(Sales sales);
    Sales updateSales(Sales sales);
    void deleteSales(Sales sales);

}
