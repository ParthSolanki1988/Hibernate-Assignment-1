package com.simform.hibernate_assignment_1.service;

import com.simform.hibernate_assignment_1.entity.Customer;
import com.simform.hibernate_assignment_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;


  public Customer createCustomer(Customer customer) {
    customer.getAccounts().forEach(account -> account.setCustomer(customer));
    Customer save = customerRepository.save(customer);
    return save;
  }

  public List<Customer> findAllCustomer() {
    List<Customer> all = customerRepository.findAll();
    return all;
  }


  public String findById(Long id , Customer customer) {
    Customer existingCustomer = customerRepository.findById(id).orElse(null);
    existingCustomer.setFirstName(customer.getFirstName());
    existingCustomer.setLastName(customer.getLastName());
    existingCustomer.setEmail(customer.getEmail());
    Customer save = customerRepository.save(existingCustomer);
    return "Update Customer Id : " + existingCustomer.getId();
  }

  public String deleteById(Long id) {
    Optional<Customer> byId = customerRepository.findById(id);

    if (byId.isPresent()){
      customerRepository.deleteById(id);
      return "Delete Customer Successfully!";
    }
    else {
      return "Customer Id Not Found";
    }

  }

  public Customer findByIdCustomer(Long id) {
    Customer customer = customerRepository.findById(id).orElse(null);
    return customer;
  }
}
