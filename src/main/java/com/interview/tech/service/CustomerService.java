package com.interview.tech.service;

import com.interview.tech.da.AccountDA;
import com.interview.tech.da.CustomerDA;
import com.interview.tech.da.CustomerRepository;
import com.interview.tech.dao.Account;
import com.interview.tech.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService
{
  @Autowired
  private CustomerRepository customerRepository;

  public Customer findAccount(long customerId)
  {
    Optional<CustomerDA> savedCustomer = customerRepository.findById(customerId);
    Customer customer = new Customer();
    if(savedCustomer.isPresent())
    {
      Set<AccountDA> accounts = savedCustomer.get().getAccounts();
      mapAccounts(accounts);
      customer.setDateOfBirth(savedCustomer.get().getDateOfBirth());
      customer.setForeName(savedCustomer.get().getForeName());
      customer.setSureName(savedCustomer.get().getSureName());
    }
    return customer;

  }

  private void mapAccounts(Set<AccountDA> accounts)
  {
    List<Account> accountList = new ArrayList<>();

    for(AccountDA savedAccount : accounts)
    {
      Account account = new Account();
      account.setId(savedAccount.getId());
      account.setAccountNumber(savedAccount.getAccountNumber());
      accountList.add(account);
    }
  }
}
