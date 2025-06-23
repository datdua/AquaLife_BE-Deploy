package vn.fpt.edu.aqualife.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import vn.fpt.edu.aqualife.entity.Account;
import vn.fpt.edu.aqualife.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Optional<Account> accountOpt = accountRepository.findByPhoneNumber(phoneNumber);
        if (accountOpt.isEmpty()) {
            throw new UsernameNotFoundException("User not found with phone number: " + phoneNumber);
        }

        Account account = accountOpt.get();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getRole() != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + account.getRole().name()));
        }

        return new org.springframework.security.core.userdetails.User(
                account.getPhoneNumber(),
                account.getPasswordHash(),
                authorities);
    }

    public Account findByPhoneNumber(String phoneNumber) {
        Optional<Account> accountOpt = accountRepository.findByPhoneNumber(phoneNumber);
        return accountOpt.orElse(null);
    }

    public ResponseEntity<?> findAccountByAccountID(Integer accountID) {
        Optional<Account> accountOpt = accountRepository.findById(accountID);
        if (accountOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Account not found with accountID: " + accountID);
        }
        return ResponseEntity.ok(accountOpt.get());
    }
}