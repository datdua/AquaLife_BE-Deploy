package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.fpt.edu.aqualife.entity.Order;
import vn.fpt.edu.aqualife.enums.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.account.accountId = :accountId")
    List<Order> findByUserID(@Param("accountId") Integer accountId);
    @Query("SELECT o FROM Order o WHERE o.cart.cartId = :cartId")
    List<Order> findByCartID(@Param("cartId") Integer cartId);
    List<Order> findByOrderStatus(OrderStatus orderStatus);
}