package com.interview.tech.da;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class AccountDA implements Serializable
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @ManyToMany(fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.PERSIST,
                  CascadeType.MERGE
          })
  @JoinTable(
          name = "cust_link_acc",
          joinColumns = @JoinColumn(name = "account_id"),
          inverseJoinColumns = @JoinColumn(name = "customer_id"))
  private Set<CustomerDA> customers;

  @Column
  private Integer accountNumber;

  public AccountDA(Set<CustomerDA> customers, Integer accountNumber)
  {
    this.customers = customers;
    this.accountNumber = accountNumber;
  }

  public AccountDA()
  {
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Set<CustomerDA> getCustomers()
  {
    return customers;
  }

  public void setCustomers(Set<CustomerDA> customers)
  {
    this.customers = customers;
  }

  public Integer getAccountNumber()
  {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber)
  {
    this.accountNumber = accountNumber;
  }
}
