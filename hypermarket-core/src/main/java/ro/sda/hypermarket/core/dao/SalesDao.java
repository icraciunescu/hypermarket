package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Sales;

import java.util.List;

public interface SalesDao {

    Session getCurrentSession();

    Sales getById(Long id);

    List<Sales> getAll();

    Sales createSales(Sales sales);

    Sales updateSales(Sales sales);

    void deleteSales(Sales sales);

}

