package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Sales;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {

    private List<Sales> sales = new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Sales getById(Long id) {
        return getCurrentSession().byId(Sales.class).getReference(id);
    }

    @Override
    public List<Sales> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Sales> criteriaQuery = session.getCriteriaBuilder().createQuery(Sales.class);
        criteriaQuery.from(Sales.class);
        List<Sales> allSales = session.createQuery(criteriaQuery).getResultList();
        return allSales;
    }

    @Override
    public Sales createSales(Sales sales) {
        getCurrentSession().save(sales);
        return sales;
    }

    @Override
    public Sales updateSales(Sales sales) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Sales sales1 = getById(sales.getId());
        sessionFactory.getCurrentSession().merge(sales1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return sales1;
    }

    @Override
    public void deleteSales(Sales sales) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Sales sales1 = getById(sales.getId());
        sessionFactory.getCurrentSession().delete(sales1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}



