package com.hexaware.FTP107.model;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;


/**
 * Test class for Vendor.
 */
@RunWith(JMockit.class)
public class VendorTest {
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
  public final void testVendor() {
    Vendor v = null;
    Vendor v1 = new Vendor();
    assertNotNull("vendor not null", v1);
    assertNotNull(v1);
    Vendor v2 = new Vendor(10, "Anne", "sea", "ree", "art@999", "9047776706", "vadapalani");
    v2.setVenId(10);
    assertNotEquals(v2, null);
    assertEquals(10, v2.getVenId());
    v2.setVenName("Anne");
    assertEquals("Anne", v2.getVenName());
    assertNotEquals(9, v2.getVenId());
    assertNotEquals("Sudha", v2.getVenName());
    v2.setVenUsername("sea");
    assertEquals("sea", v2.getVenUsername());
    v2.setVenPassword("ree");
    assertEquals("ree", v2.getVenPassword());
    assertNotEquals("cry", v2.getVenUsername());
    assertNotEquals("try", v2.getVenPassword());
    v2.setVenEmail("art@999");
    assertEquals("art@999", v2.getVenEmail());
    v2.setVenPhone("9047776706");
    assertEquals("9047776706", v2.getVenPhone());
    assertNotEquals("zyz", v2.getVenEmail());
    assertNotEquals("12345", v2.getVenPhone());
    v2.setVenAddress("vadapalani");
    assertEquals("vadapalani", v2.getVenAddress());
    assertNotEquals("siruseri", v2.getVenAddress());
    assertEquals(v2.hashCode(), new Vendor(10, "Anne", "sea", "ree", "art@999", "9047776706", "vadapalani").hashCode());
    Vendor actual = new Vendor(10, "Anne", "sea", "ree", "art@999", "9047776706", "vadapalani");
    Vendor expected = new Vendor(10, "Anne", "sea", "ree", "art@999", "9047776706", "vadapalani");
    Vendor real = new Vendor(10, "123", "run", "see", "add", "999", "126");
    assertEquals(actual, expected);
    System.out.println(v2);
    Vendor v3 = new Vendor("Anne");
    assertEquals("Anne", v3.getVenName());
    assertNotEquals(v3, null);
    assertNotEquals(actual, real);
    ArrayList al = new ArrayList();
    assertFalse(v2.equals(al));
  }
}
