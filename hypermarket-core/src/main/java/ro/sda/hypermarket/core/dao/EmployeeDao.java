package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Session getCurrentSession();

    Department getById(Long id);

    List<Department> getAll();

    Department createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}
