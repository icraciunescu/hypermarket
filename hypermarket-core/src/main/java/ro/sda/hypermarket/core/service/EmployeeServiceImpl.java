package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.EmployeeDao;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.repository.EmployeeRepository;
import java.util.List;

@Service("supplierService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getById(Long id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee, boolean useHibernate) {
        if (useHibernate) {
            return employeeDao.createEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {

    }
}
