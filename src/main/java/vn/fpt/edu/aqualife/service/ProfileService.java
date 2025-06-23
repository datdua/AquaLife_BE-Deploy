package vn.fpt.edu.aqualife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.edu.aqualife.entity.Account;
import vn.fpt.edu.aqualife.repository.AccountRepository;
import vn.fpt.edu.aqualife.service.impl.IProfileService;

@Service
public class ProfileService implements IProfileService {

    @Autowired
    private AccountRepository userRepository;

    @Override
    public Account getProfile(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Account updateProfile(String email, Account updatedUser) {
        Account user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFullName(updatedUser.getFullName());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setAddress(updatedUser.getAddress());
        user.setAvatarUrl(updatedUser.getAvatarUrl());
        return userRepository.save(user);
    }
}
