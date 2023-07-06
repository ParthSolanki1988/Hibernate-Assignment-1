package com.simform.hibernate_assignment_1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "transaction_id")
  private Long id;

  @Column(name = "transaction_amount")
  private double amount;

  @Column(name = "transaction_date")
  private Date date;

  @Column(name = "transaction_type")
  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @ManyToOne
  @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
  @JsonBackReference
  private Account account;


}
