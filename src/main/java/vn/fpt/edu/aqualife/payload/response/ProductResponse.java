package vn.fpt.edu.aqualife.payload.response;

import lombok.Data;
import vn.fpt.edu.aqualife.enums.ProductStatus;
import vn.fpt.edu.aqualife.enums.ProductType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private String productName;
    private ProductStatus productStatus;
    private String imageUrl;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private ProductType productType;
    private LocalDateTime createdAt;
    private LocalDateTime changedAt;
}
