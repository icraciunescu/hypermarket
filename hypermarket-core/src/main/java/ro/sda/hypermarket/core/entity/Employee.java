package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employees", schema = "hypermarket")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 40, nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 40, nullable = false)
    private String last_name;

    @Column(name = "salary", length = 40, nullable = false)
    private BigDecimal salary;

    @Column(name = "job_title", length = 40, nullable = false)
    private String job_title;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Column(name = "dept_id", length = 40, nullable = false)
    private BigDecimal dept_id;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates = new HashSet<>();

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    @Column(name = "manager_id", length = 40, nullable = false)
    private Integer manager_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getDept_id() {
        return dept_id;
    }

    public void setDept_id(BigDecimal dept_id) {
        this.dept_id = dept_id;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(first_name, employee.first_name) &&
                Objects.equals(last_name, employee.last_name) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(job_title, employee.job_title) &&
                Objects.equals(dept_id, employee.dept_id) &&
                Objects.equals(city, employee.city) &&
                Objects.equals(manager_id, employee.manager_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, salary, job_title, dept_id, city, manager_id);
    }
}
