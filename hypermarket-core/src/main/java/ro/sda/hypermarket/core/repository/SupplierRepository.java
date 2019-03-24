package ro.sda.hypermarket.core.repository;

import org.springframework.data.jpa.repository.Query;
import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;


public interface SupplierRepository extends EntityRepository<Supplier> {

    public Supplier findByName(String name);
}
