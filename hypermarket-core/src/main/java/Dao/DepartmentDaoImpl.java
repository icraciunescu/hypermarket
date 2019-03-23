package Dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface DepartmentDaoImpl {
    Session getCurrentSession();

    Supplier getById(Long id);
    List<Department> getAll();
    Supplier createDeparment(Department department);
    void updateDepartment(Department department);
    void deleteSupplier(Department department);
}
