package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.ProductCategory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoImpl  implements ProductCategoryDao {

    private List<ProductCategory> productCategory = new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Employee getById(Long id) {
        return getCurrentSession().byId(Employee.class).getReference(id);
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Employee> criteriaQuery = session.getCriteriaBuilder().createQuery(Employee.class);
        criteriaQuery.from(Department.class);
        List<Employee> allEmployees = session.createQuery(criteriaQuery).getResultList();
        return allEmployees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        getCurrentSession().save(employees);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Employee employee1 = getById(employee.getId());
        sessionFactory.getCurrentSession().merge(employee1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return employee1;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Employee employee1 = getById(employee.getId());
        sessionFactory.getCurrentSession().delete(employee1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}


