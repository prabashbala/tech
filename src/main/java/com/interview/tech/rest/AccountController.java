package com.interview.tech.rest;

import com.interview.tech.dao.Account;
import com.interview.tech.service.AccountService;
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
public class AccountController
{
  @Autowired
  private AccountService accountService;


  /**
   * This will handle a POST request of the json object below
   * Request Body: application/json:   *
   * {
   * system*: string,
   * name*: string,
   * date*: integer,
   * value: integer,
   * }
   *
   * @param account Account to be saved
   * @return success if the save was successful
   */
  @RequestMapping(value = "/addAccount", method = {RequestMethod.POST})
  public Account addAccount(@RequestBody Account account)
  {
    return accountService.saveAccount(account);
  }

  @RequestMapping(value = "/getAccount", method = {RequestMethod.POST})
  public Account getAccount(@RequestBody Account account)
  {
    return accountService.findAccount(account.getId());
  }

}
