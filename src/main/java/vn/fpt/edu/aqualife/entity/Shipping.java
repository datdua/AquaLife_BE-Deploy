package vn.fpt.edu.aqualife.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import vn.fpt.edu.aqualife.enums.ShippingStatus;

@Entity
@Table(name = "Shipping")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShippingID")
    private Integer shippingId;

    @ManyToOne
    @JoinColumn(name = "AccountAddID", nullable = false)
    private AccountAdd accountAdd;

    @Column(name = "Description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "ShippingStatus", nullable = false)
    private ShippingStatus shippingStatus;

    @Column(name = "DeliveryDate")
    private LocalDateTime deliveryDate;

    @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL)
    private List<Order> orders; 
}
