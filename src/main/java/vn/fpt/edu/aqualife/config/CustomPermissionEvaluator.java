package vn.fpt.edu.aqualife.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import vn.fpt.edu.aqualife.entity.Account;
import vn.fpt.edu.aqualife.repository.AccountRepository;

import java.io.Serializable;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomPermissionEvaluator implements PermissionEvaluator {
    private final AccountRepository accountRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetObject, Object permission) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        String phoneNumber = authentication.getName();
        Optional<Account> accountOpt = accountRepository.findByPhoneNumber(phoneNumber);

        if (accountOpt.isEmpty()) {
            return false;
        }

        Account account = accountOpt.get();
        return hasCorrectRoles(account, targetObject, permission);
    }

    private boolean hasCorrectRoles(Account account, Object targetRole, Object requiredRole) {
        if (account.getRole() == null) {
            return false;
        }

        boolean hasRequiredRole = account.getRole().name().equals(requiredRole.toString());
        return hasRequiredRole;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}