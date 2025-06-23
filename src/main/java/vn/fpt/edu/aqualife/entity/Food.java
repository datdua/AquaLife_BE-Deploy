package vn.fpt.edu.aqualife.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.fpt.edu.aqualife.enums.FoodType;

@Entity
@Table(name = "Food")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
            
    @Id
    @Column(name = "ProductID")
    private Integer productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ProductID")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "FoodType", nullable = false)
    private FoodType foodType;

    @Column(name = "pH", nullable = false, length = 50)
    private String pH;
}
