package com.interview.tech.rest;

import com.interview.tech.dao.Account;
import com.interview.tech.dao.Customer;
import org.junit.Before;
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

  private Fixture fixture;

  @Before
  public void setUp()
  {
    fixture = new Fixture();
  }

  @Autowired
  private AccountController accountController;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void contexLoads()
  {
    assertThat(accountController).isNotNull();
  }

  @Test
  public void whenPOSTRequestToAddCustomerIsValidThenReturnSuccess()
  {
    fixture.givenEndpointUrlIsSet("8080", urlAdd);
    fixture.givenAccountDetailsIsSet();
    fixture.givenCustomerIsAvailable();
    fixture.whenGetCustomerRequestIsSent();
    fixture.thenResponseIsValid();
  }

  @Test
  public void whenPOSTRequestToGetCustomerIsValidThenReturnSuccess()
  {
    fixture.givenEndpointUrlIsSet("8080", urlGet);
    fixture.givenAccountIdIsSet();
    fixture.whenGetCustomerRequestIsSent();
    fixture.thenResponseIsValid();
  }

  class Fixture
  {
    private String response;
    private Account account;
    private String endPintURL;

    private void givenCustomerIsAvailable()
    {
      account = new Account();
      account.setAccountNumber(1);
      List<Customer> customers = new ArrayList<>();
      customers.add(new Customer("Praba","Bala",null));
      customers.add(new Customer("Eric","Chan",null));
      customers.add(new Customer("Mark","Taylor",null));
      account.setCustomers(customers);
    }

    public void whenGetCustomerRequestIsSent()
    {
      response = restTemplate.postForObject(endPintURL, account, String.class);
    }

    public void givenAccountDetailsIsSet()
    {
      account = new Account();
      account.setId(new Long("12542856"));
      account = new Account();
      account.setAccountNumber(1);

    }

    public void thenResponseIsValid()
    {
      assertTrue(response.contains("customerIds"));
    }

    public void givenEndpointUrlIsSet(String targetPort, String endPointUrl)
    {
      endPintURL = endPointUrl.replace(targetPort, String.valueOf(port));
    }

    public void givenAccountIdIsSet()
    {
      account = new Account();
      account.setId(Long.valueOf(2));
    }


  }
}