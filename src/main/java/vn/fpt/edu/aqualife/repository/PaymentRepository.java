package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.fpt.edu.aqualife.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // List<Payment> findByOrderID(Integer orderId);
    @Query("SELECT p FROM Payment p WHERE p.order.orderId = :orderId")
    List<Payment> findByOrderID(@Param("orderId") Integer orderId);
    List<Payment> findByPaymentStatus(String paymentStatus);
}
