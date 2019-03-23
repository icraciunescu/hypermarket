package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;

import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Session getCurrentSession();

    Employee getById(Long id);

    List<Employee> getAll();

    Employee createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}
