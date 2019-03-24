package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliers", schema = "hypermarket")
public class Supplier {



    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "contact_no", length = 40, nullable = false)
    private String contact_no;

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id.equals(supplier.id) &&
                name.equals(supplier.name) &&
                contact_no.equals(supplier.contact_no) &&
                city.equals(supplier.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contact_no, city);
    }
}
