package vn.fpt.edu.aqualife.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.edu.aqualife.payload.request.LoginRequest;
import vn.fpt.edu.aqualife.payload.request.RegisterRequest;
import vn.fpt.edu.aqualife.payload.response.ApiResponse;
import vn.fpt.edu.aqualife.payload.response.AuthResponse;
import vn.fpt.edu.aqualife.service.impl.IAuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ApiResponse.builder().message("Account registered successfully").
                        status(HttpStatus.CREATED.value()).build());
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        var response = authService.login(request);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("Login successful")
                        .data(AuthResponse.builder()
                                .accessToken(response.getAccessToken())
                                .refreshToken(response.getRefreshToken())
                                .build())
                        .build());
    }
}