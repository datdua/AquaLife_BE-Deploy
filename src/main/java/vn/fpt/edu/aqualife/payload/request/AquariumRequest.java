package vn.fpt.edu.aqualife.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AquariumRequest {
    @NotNull(message = "Thông tin sản phẩm không được để trống")
    private ProductRequest product;

    @NotBlank(message = "Kích thước không được để trống")
    @Size(max = 50, message = "Kích thước không được vượt quá 50 ký tự")
    private String size;
}
