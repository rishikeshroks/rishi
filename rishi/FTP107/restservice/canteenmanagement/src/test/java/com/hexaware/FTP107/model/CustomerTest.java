package com.hexaware.FTP107.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;


import mockit.integration.junit4.JMockit;


/**
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */

  @Test
  public final void testCustomer() {
    Customer c = new Customer();
    Customer c2 = null;
    assertNull(c2);
    assertNotNull("Customer is not null", c);
    assertNotNull(c);
    Customer c3 = new Customer();
    c3.setCustId(2001);
    assertEquals(2001, c3.getCustId());
    assertNotEquals(2006, c3.getCustId());
    c3.setCustName("Anu");
    assertEquals("Anu", c3.getCustName());
    assertNotEquals("Geet", c3.getCustName());
    c3.setCUserName("abc123");
    assertEquals("abc123", c3.getCUserName());
    assertNotEquals("bvsght", c3.getCUserName());
    c3.setCPassword("er125465");
    assertEquals("er125465", c3.getCPassword());
    assertNotEquals("vfstnc", c3.getCPassword());
    c3.setCWallet(23.0f);
    assertEquals(23.0f, c3.getCWallet(), 0.01);
    assertNotEquals(24.9f, c3.getCWallet(), 0.01);
    c3.setCEmail("sdert@1");
    assertEquals("sdert@1", c3.getCEmail());
    assertNotEquals("sth@12", c3.getCEmail());
    c3.setCPhone("8664564784");
    assertEquals("8664564784", c3.getCPhone());
    assertNotEquals("9567467484", c3.getCPhone());
    c3.setCAddress("No:5,chrompet");
    assertEquals("No:5,chrompet", c3.getCAddress());
    assertNotEquals("No:4,saidapet", c3.getCAddress());
  }
  /**
  * Tests the equals/hashcode methods of the employee class.
   */
  @Test
   public final void testAllArgTestConstructor() {

    Customer c1 = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    assertEquals(2000, c1.getCustId());
    assertNotEquals(2006, c1.getCustId());
    assertEquals("Anu", c1.getCustName());
    assertNotEquals("Geet", c1.getCustName());
    assertEquals("abc123", c1.getCUserName());
    assertNotEquals("bvsght", c1.getCUserName());
    assertEquals("er125465", c1.getCPassword());
    assertNotEquals("vfstnc", c1.getCPassword());
    assertEquals(23.0f, c1.getCWallet(), 0.01);
    assertNotEquals(24.9f, c1.getCWallet(), 0.01);
    assertEquals("sdert@1", c1.getCEmail());
    assertNotEquals("sth@12", c1.getCEmail());
    assertEquals("8664564784", c1.getCPhone());
    assertNotEquals("9567467484", c1.getCPhone());
    assertEquals("No:5,chrompet", c1.getCAddress());
    assertNotEquals("No:4,saidapet", c1.getCAddress());
    assertEquals(c1.hashCode(), new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet").hashCode());
    Customer actual = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    Customer expected = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    assertEquals(actual, expected);
    Customer re = new Customer(2010, "Anub", "abc1234", "er12e5465", 13.0f, "sdeert@1", "8666764784", "No:2,chropet");
    assertNotEquals(actual, re);
    assertEquals(c1.toString(), new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet").toString());
    ArrayList ar = new ArrayList();
    assertFalse(c1.equals(ar));
    Customer c4 = new Customer();
    assertNotEquals(c4, null);
  }
}
