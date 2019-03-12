package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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

    @Column(name = "dept_id", length = 40, nullable = false)
    private BigDecimal dept_id;

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    @Column(name = "manager_id", length = 40, nullable = false)
    private Integer manager_id;

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
