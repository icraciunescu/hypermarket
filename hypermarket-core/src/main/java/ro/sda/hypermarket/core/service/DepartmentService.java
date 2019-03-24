package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department getById(Long id);
    List<Department> getAll();
    Department createDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Department department);

}
