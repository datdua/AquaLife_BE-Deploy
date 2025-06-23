package vn.fpt.edu.aqualife.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FishRequest {
    @NotNull(message = "Thông tin sản phẩm không được để trống")
    private ProductRequest product;

    @NotBlank(message = "Loại cá không được để trống")
    @Size(max = 50, message = "Loại cá không được vượt quá 50 ký tự")
    private String fishType;

    @NotBlank(message = "Thức ăn cho cá không được để trống")
    private String fishFood;

    @NotBlank(message = "Màu sắc không được để trống")
    @Size(max = 50, message = "Màu sắc không được vượt quá 50 ký tự")
    private String color;

    @NotBlank(message = "Hành vi không được để trống")
    private String behavior;

    @NotBlank(message = "Nhiệt độ không được để trống")
    @Size(max = 50, message = "Nhiệt độ không được vượt quá 50 ký tự")
    private String temperature;

    @NotBlank(message = "Độ pH không được để trống")
    @Size(max = 50, message = "Độ pH không được vượt quá 50 ký tự")
    private String pH;
}
