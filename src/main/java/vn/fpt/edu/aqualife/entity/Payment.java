package vn.fpt.edu.aqualife.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"Payment\"")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"PaymentID\"")
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "\"OrderID\"", nullable = false)
    private Order order;

    @Column(name = "\"Amount\"", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "\"PaymentDate\"", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "\"PaymentStatus\"", nullable = false, length = 50)
    private String paymentStatus;
}
