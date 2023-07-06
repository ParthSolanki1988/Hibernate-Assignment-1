package com.simform.hibernate_assignment_1.repository;

import com.simform.hibernate_assignment_1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}