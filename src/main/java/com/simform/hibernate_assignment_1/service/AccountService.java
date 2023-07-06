package com.simform.hibernate_assignment_1.service;

import com.simform.hibernate_assignment_1.entity.Account;
import com.simform.hibernate_assignment_1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

  @Autowired
  AccountRepository accountRepository;


  public Account createAccount(Account account) {
    account.getTransactions().forEach(transaction -> transaction.setAccount(account));
    Account saveAccount = accountRepository.save(account);
    return saveAccount;
  }

  public List<Account> getAllAccount() {
    List<Account> accountList = accountRepository.findAll();
    return accountList;
  }

  public Account getById(Long id) {
    return accountRepository.findById(id).get();
  }
}
