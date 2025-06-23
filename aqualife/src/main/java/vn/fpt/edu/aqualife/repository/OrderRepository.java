package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Order;
import vn.fpt.edu.aqualife.enums.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);
    List<Order> findByCartId(Integer cartId);
    List<Order> findByOrderStatus(OrderStatus orderStatus);
}