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
@Table(name = "Medicine")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    
    @Id
    @Column(name = "ProductID")
    private Integer productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "MedicineType", nullable = false, length = 50)
    private String medicineType;
}
