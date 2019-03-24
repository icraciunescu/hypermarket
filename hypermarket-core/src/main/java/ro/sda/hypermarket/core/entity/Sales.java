package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "hypermarket")
public class Sales extends BaseEntity {

    @Column(name = "number", length = 40, nullable = false)
    private Long number;

    @Column(name = "sale_date", length = 40, nullable = false)
    private BigDecimal sale_date;

    @Column(name = "client_id", length = 40, nullable = false)
    private Integer client_id;

    @Column(name = "employee_id", length = 40, nullable = false)
    private Integer employee_id;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getSale_date() {
        return sale_date;
    }

    public void setSale_date(BigDecimal sale_date) {
        this.sale_date = sale_date;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Objects.equals(super.getId(), sales.getId()) &&
                Objects.equals(number, sales.number) &&
                Objects.equals(sale_date, sales.sale_date) &&
                Objects.equals(client_id, sales.client_id) &&
                Objects.equals(employee_id, sales.employee_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), number, sale_date, client_id, employee_id);
    }
}
