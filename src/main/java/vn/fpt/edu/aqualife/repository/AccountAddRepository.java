package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.fpt.edu.aqualife.entity.AccountAdd;

public interface AccountAddRepository extends JpaRepository<AccountAdd, Integer> {
    // List<AccountAdd> findByAccountID(Integer accountId);
    @Query("SELECT aa FROM AccountAdd aa WHERE aa.account.accountId = :accountId")
    List<AccountAdd> findByAccountID(@Param("accountId") Integer accountId);
    List<AccountAdd> findByIsDefault(Boolean isDefault);
}
