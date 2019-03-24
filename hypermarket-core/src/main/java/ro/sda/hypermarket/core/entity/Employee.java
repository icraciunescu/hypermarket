package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employees", schema = "hypermarket")
public class Employee extends BaseEntity {


    @Column(name = "firstName", length = 40, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 40, nullable = false)
    private String lastName;

    @Column(name = "salary", length = 20, nullable = false)
    private BigDecimal salary;

    @Column(name = "jobTitle", length = 40, nullable = false)
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates = new HashSet<>();

//fhehrshiefiehrkesheheruheruu
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(city, employee.city) &&
                Objects.equals(manager, employee.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), firstName, lastName, salary, jobTitle, department, city, manager);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + super.getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                ", department=" + department +
                ", city='" + city + '\'' +
                ", manager=" + manager +
                '}';
    }
}