package com.interview.tech.da;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class CustomerDA implements Serializable
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @ManyToMany(fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.PERSIST,
                  CascadeType.MERGE
          },
          mappedBy = "customers")
  private Set<AccountDA> accounts;

  @Column
  private String foreName;

  @Column
  private String sureName;

  @Column
  private LocalDate dateOfBirth;

  public CustomerDA(String foreName, String sureName, LocalDate dateOfBirth)
  {
    this.foreName = foreName;
    this.sureName = sureName;
    this.dateOfBirth = dateOfBirth;
  }

  public CustomerDA()
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

  public Set<AccountDA> getAccounts()
  {
    return accounts;
  }

  public void setAccounts(Set<AccountDA> accounts)
  {
    this.accounts = accounts;
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
}
