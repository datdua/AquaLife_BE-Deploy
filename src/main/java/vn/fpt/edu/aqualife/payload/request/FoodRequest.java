package vn.fpt.edu.aqualife.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import vn.fpt.edu.aqualife.enums.FoodType;

@Data
public class FoodRequest {
    @NotNull(message = "Thông tin sản phẩm không được để trống")
    private ProductRequest product;

    @NotNull(message = "Loại thức ăn không được để trống")
    private FoodType foodType;

    @NotBlank(message = "Độ pH không được để trống")
    @Size(max = 50, message = "Độ pH không được vượt quá 50 ký tự")
    private String pH;
}
