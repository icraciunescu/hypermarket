package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Department;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

    private List<Department> departments = new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
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
        List<Department> allDepartments = session.createQuery(criteriaQuery).getResultList();
        return allDepartments;
    }

    @Override
    public Department createDepartment(Department department) {
        getCurrentSession().save(departments);
        return department;
    }

    @Override
    public void updateDepartment(Department department) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department department1 = getById(department.getId());
        sessionFactory.getCurrentSession().merge(department1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void deleteDepartment(Department department) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department department1 = getById(department.getId());
        sessionFactory.getCurrentSession().delete(department1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
