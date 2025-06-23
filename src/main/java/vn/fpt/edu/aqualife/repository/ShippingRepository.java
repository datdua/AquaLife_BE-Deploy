package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.fpt.edu.aqualife.entity.Shipping;
import vn.fpt.edu.aqualife.enums.ShippingStatus;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
    // List<Shipping> findByUserAddID(Integer userAddId);
    @Query("SELECT s FROM Shipping s WHERE s.accountAdd.accountAddId = :accountAddId")
    List<Shipping> findByUserAddID(@Param("accountAddId") Integer accountAddId);
    List<Shipping> findByShippingStatus(ShippingStatus shippingStatus);
}
