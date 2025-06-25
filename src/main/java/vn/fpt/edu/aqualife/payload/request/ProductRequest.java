package vn.fpt.edu.aqualife.payload.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import vn.fpt.edu.aqualife.enums.ProductStatus;
import vn.fpt.edu.aqualife.enums.ProductType;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(max = 100, message = "Tên sản phẩm không được vượt quá 100 ký tự")
    private String productName;

    @NotNull(message = "Trạng thái sản phẩm không được để trống")
    private ProductStatus productStatus;

    private String imageUrl;

    private String description;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng phải lớn hơn hoặc bằng 0")
    private Integer quantity;

    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "0.0", inclusive = true, message = "Giá phải lớn hơn hoặc bằng 0")
    private BigDecimal price;

    @NotNull(message = "Loại sản phẩm không được để trống")
    private ProductType productType;
}
