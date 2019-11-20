package com.interview.tech.service;

import com.interview.tech.da.AccountDA;
import com.interview.tech.da.AccountRepository;
import com.interview.tech.da.CustomerDA;
import com.interview.tech.dao.Account;
import com.interview.tech.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService
{
  @Autowired
  private AccountRepository accountRepository;

  public Account saveAccount(Account account)
  {
    Set<CustomerDA> customer = new HashSet<>();
    mapCustomerDaList(account, customer);
    AccountDA accountSaved = accountRepository.save(new AccountDA(customer, account.getAccountNumber()));
    Account savedAccount = new Account();
    savedAccount.setId(accountSaved.getId());
    mapCustomerIDs(accountSaved.getCustomers(), savedAccount);
    savedAccount.setAccountNumber(accountSaved.getAccountNumber());
    return savedAccount;
  }

  private void mapCustomerDaList(Account account, Set<CustomerDA> customer)
  {
    if(account.getAccountNumber() !=null && account.getCustomerIds()!= null)
    {
      for(Customer customers : account.getCustomers())
      {
        CustomerDA customerDa = new CustomerDA();
        customerDa.setForeName(customers.getForeName());
        customerDa.setSureName(customers.getSureName());
        customerDa.setDateOfBirth(customers.getDateOfBirth());
        customer.add(customerDa);
      }
    }
  }

  private void mapCustomerIDs(Set<CustomerDA> customers, Account savedAccount)
  {
    for(CustomerDA savedCustomer: customers)
    {
      if(savedCustomer.getId()!=null)
      {
        savedAccount.getCustomerIds().add(savedCustomer.getId().toString());
      }
    }
  }

  public Account findAccount(Long customerId)
  {
    Optional<AccountDA> accountDA = accountRepository.findById(customerId);
    Account account = new Account();
    if(accountDA.isPresent())
    {
      account = new Account();
      mapCustomerIDs(accountDA.get().getCustomers(), account);
      account.setAccountNumber(accountDA.get().getAccountNumber());
      account.setId(accountDA.get().getId());
    }
    return account;
  }
}
