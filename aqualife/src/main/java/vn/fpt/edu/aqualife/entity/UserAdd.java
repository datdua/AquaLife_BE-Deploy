package vn.fpt.edu.aqualife.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserAdd")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAdd {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserAddID")
    private Integer userAddId;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "ShippingAddress", nullable = false)
    private String shippingAddress;

    @Column(name = "isDefault", nullable = false)
    private Boolean isDefault;

    @Column(name = "ShippingPhone", nullable = false, length = 20)
    private String shippingPhone;

    @OneToMany(mappedBy = "userAdd", cascade = CascadeType.ALL)
    private List<Shipping> shippings;
}
