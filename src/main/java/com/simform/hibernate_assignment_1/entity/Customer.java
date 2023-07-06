package com.simform.hibernate_assignment_1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Long id;

  @Column(name = "customer_first_name")
  private String firstName;

  @Column(name = "customer_last_name")
  private String lastName;

  @Column(name = "customer_email")
  private String email;

  @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
  @JsonBackReference
  private List<Account> accounts;









}
