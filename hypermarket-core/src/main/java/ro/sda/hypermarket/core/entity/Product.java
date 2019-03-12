package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products", schema = "hypermarket")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "supliers_price", length = 40, nullable = false)
    private String supliers_price;

    @Column(name = "stock", length = 40, nullable = false)
    private BigDecimal stock;

    @Column(name = "supliers_id", length = 40, nullable = false)
    private Long supliers_id;

    @Column(name = "category_id", length = 40, nullable = false)
    private Long category_id;

    @Column(name = "vending_price", length = 40, nullable = false)
    private BigDecimal vending_price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupliers_price() {
        return supliers_price;
    }

    public void setSupliers_price(String supliers_price) {
        this.supliers_price = supliers_price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public Long getSupliers_id() {
        return supliers_id;
    }

    public void setSupliers_id(Long supliers_id) {
        this.supliers_id = supliers_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public BigDecimal getVending_price() {
        return vending_price;
    }

    public void setVending_price(BigDecimal vending_price) {
        this.vending_price = vending_price;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
