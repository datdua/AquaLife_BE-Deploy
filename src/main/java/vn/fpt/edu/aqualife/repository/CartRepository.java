package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(Integer userId);
    List<Cart> findByStatus(String status);
}
