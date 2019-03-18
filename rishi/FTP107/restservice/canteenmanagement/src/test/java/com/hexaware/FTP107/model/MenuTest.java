package com.hexaware.FTP107.model;

//import com.hexaware.FTP107.persistence.MenuDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
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
  public final void testMenu() {
    Menu m = null;
    assertNull(m);
    Menu m1 = new Menu();
    assertNotNull(m1);
    Menu m2 = new Menu(100, "idilis", 200, 25.78, "South indian", "idlis and sambar", 40);
    m2.setFoodId(100);
    assertEquals(100, m2.getFoodId());
    m2.setFoodName("idlis");
    assertEquals("idlis", m2.getFoodName());
    m2.setVId(200);
    assertEquals(200, m2.getVId());
    m2.setPrice(25.78);
    assertEquals(25.78, m2.getPrice(), 0.01);
    m2.setFoodCat("south indian");
    assertEquals("south indian", m2.getFoodCat());
    m2.setFoodDesc("idlis and sambar");
    assertEquals("idlis and sambar", m2.getFoodDesc());
    m2.setFoodCal(40.05);
    assertEquals(40.05, m2.getFoodCal(), 0.01);
    assertNotEquals(45, m2.getFoodId());
    assertNotEquals("poori", m2.getFoodName());
    assertNotEquals(456, m2.getVId());
    assertNotEquals(62, m2.getPrice());
    assertNotEquals("chinese", m2.getFoodCat());
    assertNotEquals("3 poori", m2.getFoodDesc());
    assertNotEquals(200, m2.getFoodCal());
  }
  /**
   * constructor of menutest.
   */
  @Test
  public final void testAllArgTestConstructor() {
    Menu m3 = new Menu(100, "idlis", 200, 25.78, "South indian", "idlis and sambar", 40.00);
    assertNotNull("Menu is not null", m3);
    assertNotNull(m3);
    assertEquals(100, m3.getFoodId());
    assertEquals("idlis", m3.getFoodName());
    assertEquals(200, m3.getVId());
    assertEquals(25.78, m3.getPrice(), 0.01);
    assertEquals("South indian", m3.getFoodCat());
    assertEquals("idlis and sambar", m3.getFoodDesc());
    assertEquals(40.00, m3.getFoodCal(), 0.01);
    assertEquals(m3.hashCode(), new Menu(100, "idlis", 200, 25.78, "South indian", "idlis and sambar", 40.00) .hashCode());
    assertEquals(m3.toString(), new Menu(100, "idlis", 200, 25.78, "South indian", "idlis and sambar", 40.00) .toString());
    ArrayList ml = new ArrayList();
    assertFalse(m3.equals(ml));
    assertNotEquals(m3, null);
  }
  /**
   * Test the final objects .
   */
  @Test
  /**
  * objects are passased .
   */
  public final void testObjects() {
    Menu expected = new Menu(100, "idlis", 200, 25.78, "South indian", "idlis and sambar", 40.00);
    Menu actual = new Menu(100, "idlis", 200, 25.78, "South indian", "idlis and sambar", 40.0);
    assertEquals(expected, actual);
    Menu m4 = new Menu(45, "poori", 456, 62, "chinese", "3poori", 200);
    assertNotEquals(m4, actual);
  }
}
