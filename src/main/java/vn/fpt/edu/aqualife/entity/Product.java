package vn.fpt.edu.aqualife.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import vn.fpt.edu.aqualife.enums.ProductStatus;
import vn.fpt.edu.aqualife.enums.ProductType;

@Entity
@Table(name = "Product")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ProductType", nullable = false)
    private ProductType productType;

    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ProductStatus", nullable = false)
    private ProductStatus productStatus;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @Column(name = "Description")
    private String description;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Fish fish;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Food food;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Medicine medicine;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Aquarium aquarium;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
