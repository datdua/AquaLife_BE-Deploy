package vn.fpt.edu.aqualife.service.impl;

import vn.fpt.edu.aqualife.entity.Account;

public interface IProfileService {
    Account getProfile(String email);
    Account updateProfile(String email, Account updatedAccount);
}
