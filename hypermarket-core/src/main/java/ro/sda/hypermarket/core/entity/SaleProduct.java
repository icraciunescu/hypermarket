package ro.sda.hypermarket.core.entity;

import javax.persistence.*;


@Entity
@Table(name = "sale_product", schema = "hypermarket")
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", length = 40, nullable = false)
    private String Product_Id;

    @Column(name = "quantity", length = 40, nullable = false)
    private String Quantity;

    @Column(name = "sale_id", length = 40, nullable = false)
    private String Sale_Id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
