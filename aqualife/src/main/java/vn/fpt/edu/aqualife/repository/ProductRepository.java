package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Product;
import vn.fpt.edu.aqualife.enums.ProductStatus;
import vn.fpt.edu.aqualife.enums.ProductType;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductType(ProductType productType);
    List<Product> findByProductStatus(ProductStatus productStatus);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
