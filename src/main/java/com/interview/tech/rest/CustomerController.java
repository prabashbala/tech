package com.interview.tech.rest;

import com.interview.tech.dao.Customer;
import com.interview.tech.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@EnableSpringDataWebSupport
public class CustomerController
{
  @Autowired
  private CustomerService customerService;

  @RequestMapping(value = "/getCustomer", method = {RequestMethod.POST})
  public Customer getCustomer(@RequestBody Customer customer)
  {
    return customerService.findAccount(customer.getId());
  }
}
