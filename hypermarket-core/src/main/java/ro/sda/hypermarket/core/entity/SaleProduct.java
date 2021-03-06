package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sale_product", schema = "hypermarket")
public class SaleProduct extends BaseEntity {

    @Column(name = "product_id", length = 40, nullable = false)
    private String Product_Id;

    @Column(name = "quantity", length = 40, nullable = false)
    private String Quantity;

    @Column(name = "sale_id", length = 40, nullable = false)
    private String Sale_Id;

    public String getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(String product_Id) {
        Product_Id = product_Id;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getSale_Id() {
        return Sale_Id;
    }

    public void setSale_Id(String sale_Id) {
        Sale_Id = sale_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleProduct that = (SaleProduct) o;
        return Objects.equals(super.getId(), that.getId()) &&
                Objects.equals(Product_Id, that.Product_Id) &&
                Objects.equals(Quantity, that.Quantity) &&
                Objects.equals(Sale_Id, that.Sale_Id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), Product_Id, Quantity, Sale_Id);
    }

}