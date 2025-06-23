package vn.fpt.edu.aqualife.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private int status;
    private String message;
    private Object data;

    public ApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public ApiResponse() {
    }
}
