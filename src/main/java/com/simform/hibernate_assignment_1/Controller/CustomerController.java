package com.simform.hibernate_assignment_1.Controller;

import com.simform.hibernate_assignment_1.entity.Customer;
import com.simform.hibernate_assignment_1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

  @Autowired
  CustomerService customerService;


  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
    Customer savedCustomer = customerService.createCustomer(customer);
    return new ResponseEntity<>(savedCustomer , HttpStatus.CREATED);
  }


  @GetMapping
  public ResponseEntity<List<Customer>> findAllCustomer(){
    List<Customer> allCustomer = customerService.findAllCustomer();
    return new ResponseEntity<>(allCustomer , HttpStatus.FOUND);
  }

  @GetMapping("{id}")
  public ResponseEntity<Customer> findByIdCustomer(@PathVariable("id") Long id){
    Customer byIdCustomer = customerService.findByIdCustomer(id);
    return new ResponseEntity<>(byIdCustomer , HttpStatus.FOUND);
  }


  @PutMapping("{id}")
  public ResponseEntity<String> updateCustomer(@PathVariable("id") Long id , @RequestBody Customer customer){
    customerService.updateCustomerById(id , customer);
    return new ResponseEntity<>("Update Successfully!",HttpStatus.OK);
  }


  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id ){
    String s = customerService.deleteById(id);
    return new ResponseEntity<>(s , HttpStatus.OK);
  }
}
