package ro.sda.hypermarket.core.repository;

import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Sales;

public interface SalesRepository extends EntityRepository<Sales> {

    public Sales findByName(String name);

}
