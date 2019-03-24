package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(Long id);
    List<Employee> getAll();
    Employee createEmployee(Employee employee, boolean useHibernate);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

}
