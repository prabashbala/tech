package com.interview.tech.dao;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Account
{
  @Id
  private Long id;
  private List<String> customerIds = new ArrayList<>();
  private Integer accountNumber;
  private List<Customer> customers = new ArrayList<>();

  public Account()
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

  public List<String> getCustomerIds()
  {
    return customerIds;
  }

  public void setCustomerIds(List<String> customerIds)
  {
    this.customerIds = customerIds;
  }

  public Integer getAccountNumber()
  {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber)
  {
    this.accountNumber = accountNumber;
  }

  public List<Customer> getCustomers()
  {
    return customers;
  }

  public void setCustomers(List<Customer> customers)
  {
    this.customers = customers;
  }
}
