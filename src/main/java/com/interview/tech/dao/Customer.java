package com.interview.tech.dao;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer
{
  @Id
  private Long id;
  private List<String> accountIds = new ArrayList<>();
  private List<Account> accounts = new ArrayList<>();
  private String foreName;
  private String sureName;
  private LocalDate dateOfBirth;

  public Customer()
  {
  }

  public Customer(Long id, List<String> accountIds, String foreName, String sureName, LocalDate dateOfBirth)
  {
    this.id = id;
    this.accountIds = accountIds;
    this.foreName = foreName;
    this.sureName = sureName;
    this.dateOfBirth = dateOfBirth;
  }

  public Customer(String foreName, String sureName, LocalDate dateOfBirth)
  {
    this.foreName = foreName;
    this.sureName = sureName;
    this.dateOfBirth = dateOfBirth;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getForeName()
  {
    return foreName;
  }

  public void setForeName(String foreName)
  {
    this.foreName = foreName;
  }

  public String getSureName()
  {
    return sureName;
  }

  public void setSureName(String sureName)
  {
    this.sureName = sureName;
  }

  public LocalDate getDateOfBirth()
  {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth)
  {
    this.dateOfBirth = dateOfBirth;
  }

  public List<String> getAccountIds()
  {
    return accountIds;
  }

  public void setAccountIds(List<String> accountIds)
  {
    this.accountIds = accountIds;
  }

  public List<Account> getAccounts()
  {
    return accounts;
  }

  public void setAccounts(List<Account> accounts)
  {
    this.accounts = accounts;
  }
}
