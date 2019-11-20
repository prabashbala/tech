package com.interview.tech.rest;

import com.interview.tech.dao.Account;
import com.interview.tech.dao.Customer;
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
public class CustomerControllerTest
{
  private static final String urlGetCustomer = "http://localhost:8080/getCustomer";

  @LocalServerPort
  private int port;

  @Autowired
  private CustomerController customerController;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void contexLoads() throws Exception
  {
    assertThat(customerController).isNotNull();
  }

  @Test
  public void whenPOSTRequestToCustomerIsValidThenReturnSuccess()
  {
    String newURL = urlGetCustomer.replace("8080", String.valueOf(port));
    Customer customer = new Customer();
    customer.setId(new Long("12545"));

   this.restTemplate.postForObject(newURL, customer, String.class);
    String response = this.restTemplate.postForObject(newURL, customer, String.class);
    assertTrue(response.equalsIgnoreCase("SUCCESS"));
  }
}