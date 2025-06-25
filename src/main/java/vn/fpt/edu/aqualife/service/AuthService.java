package vn.fpt.edu.aqualife.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.fpt.edu.aqualife.config.JwtService;
import vn.fpt.edu.aqualife.entity.Account;
import vn.fpt.edu.aqualife.enums.RoleType;
import vn.fpt.edu.aqualife.payload.request.LoginRequest;
import vn.fpt.edu.aqualife.payload.request.RegisterRequest;
import vn.fpt.edu.aqualife.payload.response.AuthResponse;
import vn.fpt.edu.aqualife.repository.AccountRepository;
import vn.fpt.edu.aqualife.service.impl.IAuthService;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (accountRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number already exists");
        }

        if (request.getEmail() != null && !request.getEmail().isEmpty() &&
                accountRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        Account account = new Account();
        account.setFullName(request.getFullName());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setEmail(request.getEmail());
        account.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        account.setRole(RoleType.CUSTOMER);
        account.setIsActive(true);
        account.setCreatedAt(LocalDateTime.now());
        account.setChangedAt(LocalDateTime.now());

        accountRepository.save(account);

        UserDetails userDetails = User.builder()
                .username(account.getPhoneNumber())
                .password(account.getPasswordHash())
                .authorities(account.getRole().name())
                .build();

        String accessToken = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPhoneNumber(),
                        request.getPassword()
                )
        );

        Account account = accountRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new IllegalArgumentException("Invalid phone number or password"));

        // Check if the account is active
        if (!account.getIsActive()) {
            throw new IllegalArgumentException("Account is not active");
        }

        UserDetails userDetails = User.builder()
                .username(account.getPhoneNumber())
                .password(account.getPasswordHash())
                .authorities(account.getRole().name())
                .build();

        String accessToken = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}