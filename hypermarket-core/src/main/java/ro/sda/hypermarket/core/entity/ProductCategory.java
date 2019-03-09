package ro.sda.hypermarket.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_category", schema = "hypermarket")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;
@Column
    private Long ProductId;

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

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }
}
