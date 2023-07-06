package com.simform.hibernate_assignment_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Data
@Entity
@Table(name = "account")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id")
  private Long id;

  @Column(name = "account_number")
  private long accountNumber;

  @Column(name = "account_balance")
  private double balance;


  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "customer_fk_id" , referencedColumnName = "customer_id")
  /*When Serializing "Account" object to JSON , the 'customer' property will be ignored , preventing infinite loop  */
  /*At other hand (In Customer class ) 'account' property in "Customer " object will be serialized as usual  */
//  @JsonBackReference

  private Customer customer;


  @OneToMany(mappedBy = "account" , cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Transaction> transactions;





}
