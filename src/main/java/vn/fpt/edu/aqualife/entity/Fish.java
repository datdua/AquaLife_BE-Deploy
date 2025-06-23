package vn.fpt.edu.aqualife.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity
@Table(name = "Fish")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fish {
    
    @Id
    @Column(name = "ProductID")
    private Integer productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "FishType", nullable = false, length = 50)
    private String fishType;

    @Column(name = "FishFood", nullable = false)
    private String fishFood;

    @Column(name = "Color", nullable = false, length = 50)
    private String color;

    @Column(name = "Behavior", nullable = false)
    private String behavior;

    @Column(name = "Temperature", nullable = false, length = 50)
    private String temperature;

    @Column(name = "pH", nullable = false, length = 50)
    private String pH;
}
