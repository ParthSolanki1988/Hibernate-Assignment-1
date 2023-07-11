package com.simform.hibernate_assignment_1.Controller;

import com.simform.hibernate_assignment_1.entity.Account;
import com.simform.hibernate_assignment_1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
  @Autowired
  AccountService accountService;

  //POST : localhost:8080/api/v1/accounts

  @PostMapping
  public ResponseEntity<Account> createAccount(@RequestBody Account account){
    Account savedAccount = accountService.createAccount(account);
    return new ResponseEntity<>(savedAccount , HttpStatus.CREATED);
  }

  //GET : localhost:8080/api/v1/accounts

  @GetMapping
  public ResponseEntity<List<Account>> getAllAccount(){
    List<Account> allAccount = accountService.getAllAccount();
    return new ResponseEntity<>(allAccount , HttpStatus.FOUND);
  }

  //GET : localhost:8080/api/v1/accounts/{id}

  @GetMapping("{id}")
  public ResponseEntity<Account> getById(@PathVariable("id") Long id){
    Account accountById = accountService.getById(id);
    return new ResponseEntity<>(accountById , HttpStatus.FOUND);
  }
}
