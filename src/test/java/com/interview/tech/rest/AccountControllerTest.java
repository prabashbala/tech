package com.interview.tech.rest;

import com.interview.tech.dao.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest
{
  private static final String urlAdd = "http://localhost:8080/addAccount";
  private static final String urlGet = "http://localhost:8080/getAccount";

  @LocalServerPort
  private int port;

  @Autowired
  private AccountController accountController;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void contexLoads() throws Exception
  {
    assertThat(accountController).isNotNull();
  }

  @Test
  public void whenPOSTRequestToAddCustomerIsValidThenReturnSuccess()
  {
    String newURL = urlAdd.replace("8080", String.valueOf(port));
    Account account = new Account();
    account.setAccountNumber(1);
    List<String> customerIds = new ArrayList<>();
    customerIds.add("1");
    customerIds.add("2");
    customerIds.add("3");

    account.setCustomerIds(customerIds);
    String response = this.restTemplate.postForObject(newURL, account, String.class);
    assertTrue(response.equalsIgnoreCase("SUCCESS"));
  }

  @Test
  public void whenPOSTRequestToGetCustomerIsValidThenReturnSuccess()
  {
    String newURL = urlGet.replace("8080", String.valueOf(port));
    Account account = new Account();
    account.setId(new Long("12542856"));

    String response = this.restTemplate.postForObject(newURL, account, String.class);
    assertTrue(response.equalsIgnoreCase("SUCCESS"));
  }
}