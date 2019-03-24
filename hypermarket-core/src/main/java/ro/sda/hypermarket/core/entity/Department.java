package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "hypermarket")
public class Department extends BaseEntity {


    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "manager_id", length = 40, nullable = false)
    private String manager_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(super.getId(), that.getId()) &&
                Objects.equals(name, that.name) &&
                Objects.equals(manager_id, that.manager_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name, manager_id);
    }
}
