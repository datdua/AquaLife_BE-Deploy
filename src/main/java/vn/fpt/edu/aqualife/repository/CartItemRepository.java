package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUserId(Integer userId);
    List<CartItem> findByProductId(Integer productId);
    
}
