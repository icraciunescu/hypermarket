package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Supplier;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Supplier getById(Long id) {
        return getCurrentSession().byId(Supplier.class).getReference(id);
    }

    @Override
    public List<Supplier> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Supplier> criteriaQuery = session.getCriteriaBuilder().createQuery(Supplier.class);
        criteriaQuery.from(Supplier.class);
        List<Supplier> allSuppliers = session.createQuery(criteriaQuery).getResultList();
        return allSuppliers;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        getCurrentSession().save(supplier);
        return supplier;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier supplier1 = getById(supplier.getId());
        sessionFactory.getCurrentSession().merge(supplier1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return supplier1;
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier supplier1 = getById(supplier.getId());
        sessionFactory.getCurrentSession().delete(supplier1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}