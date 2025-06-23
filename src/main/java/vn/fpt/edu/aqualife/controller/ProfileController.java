package vn.fpt.edu.aqualife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import vn.fpt.edu.aqualife.entity.Account;
import vn.fpt.edu.aqualife.service.impl.IProfileService;

public class ProfileController {

    @Autowired
    private IProfileService iprofileService;

    @GetMapping
    public ResponseEntity<Account> getProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(iprofileService.getProfile(email));
    }

    @PutMapping
    public ResponseEntity<Account> updateProfile(@RequestBody Account updatedUser) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(iprofileService.updateProfile(email, updatedUser));
    }
}
