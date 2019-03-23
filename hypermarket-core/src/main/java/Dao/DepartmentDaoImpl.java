package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

    private List<Department> departments= new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Department getById(Long id) {
        return getCurrentSession().byId(Department.class).getReference(id);
    }

    @Override
    public List<Department> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Department> criteriaQuery = session.getCriteriaBuilder().createQuery(Department.class);
        criteriaQuery.from(Department.class);
        List<Department> allDepartment = session.createQuery(criteriaQuery).getResultList();
        return allDepartment;
    }

//    @Override
//    public Department createDeparment(Department department) {
//        return Department;
//    }

    @Override
    public Department createDepartment(Department department) {
        getCurrentSession().save(department);
        return department;
    }

    @Override
    public void updateDepartment(Department department) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department supplier1 = getById(department.getId());
        sessionFactory.getCurrentSession().merge(supplier1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void deleteDepartment(Department supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department supplier1 = getById(supplier.getId());
        sessionFactory.getCurrentSession().delete(supplier1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}