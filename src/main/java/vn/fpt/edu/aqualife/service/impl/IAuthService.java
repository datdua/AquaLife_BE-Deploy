package vn.fpt.edu.aqualife.service.impl;

import vn.fpt.edu.aqualife.payload.request.LoginRequest;
import vn.fpt.edu.aqualife.payload.request.RegisterRequest;
import vn.fpt.edu.aqualife.payload.response.AuthResponse;

public interface IAuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}