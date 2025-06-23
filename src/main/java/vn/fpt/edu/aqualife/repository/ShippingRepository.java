package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Shipping;
import vn.fpt.edu.aqualife.enums.ShippingStatus;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
    List<Shipping> findByUserAddId(Integer userAddId);
    List<Shipping> findByShippingStatus(ShippingStatus shippingStatus);
}
