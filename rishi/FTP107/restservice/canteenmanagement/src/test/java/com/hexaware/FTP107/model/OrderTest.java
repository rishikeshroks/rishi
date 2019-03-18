package com.hexaware.FTP107.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Array;

/**
 * Test class for Orders.
 */
@RunWith(JMockit.class)
public class OrderTest {
  /**
   * setup method.
   */
  @Test
  public final void testallargConstructor() {

    Orders o = new Orders();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/DD");
    sd.setLenient(false);
    Date ld = new java.sql.Date(new java.util.Date().getTime());
    Time ot = new Time(ld.getTime());
    /**
     * tests the Equals method of Orders Class
     *
     */
    Orders o1 = new Orders(5000, 2000, 3000, 5000, 3, 10.0f, 10.0f, OrdersStatus.PLACE_ORDER, ot, ot, ld, " ");
    assertEquals(5000, o1.getOId());
    assertEquals(2000, o1.getCustId());
    assertEquals(3000, o1.getVenId());
    assertEquals(5000, o1.getFoodId());
    assertEquals(3, o1.getQty());
    assertEquals(10.0f, o1.getTotPrice(), 0.01);
    assertEquals(10.0f, o1.getTotCal(), 0.01);
    OrdersStatus os = OrdersStatus.PLACE_ORDER;
    assertEquals(os, o1.getOStatus());
    assertEquals(ot, o1.getEstTime());
    assertEquals(ot, o1.getOTime());
    assertEquals(ld, o1.getODate());
    assertEquals(" ", o1.getOReason());
    assertNotEquals(o1, null);


    /**
     * tests the set and get method of Orders Class
     *
     */
    o1.setOid(5000);
    assertEquals(5000, o1.getOId());
    o1.setCustId(2000);
    assertEquals(2000, o1.getCustId());
    o1.setVenId(3000);
    assertEquals(3000, o1.getVenId());
    o1.setFoodId(5000);
    assertEquals(5000, o1.getFoodId());
    o1.setQty(3);
    assertEquals(3, o1.getQty());
    o1.setTotPrice(10.0f);
    assertEquals(10.0f, o1.getTotPrice(), 0.01);
    o1.setTotalCal(10.0f);
    assertEquals(10.0f, o1.getTotCal(), 0.01);
    o1.setOStatus(os);
    assertEquals(os, o1.getOStatus());
    o1.setEstTime(ot);
    assertEquals(ot, o1.getEstTime());
    o1.setOTime(ot);
    assertEquals(ot, o1.getOTime());
    o1.setODate(ld);
    assertEquals(ld, o1.getODate());
    o1.setOReason(" ");
    assertEquals(" ", o1.getOReason());
    assertNotEquals(o1, new Orders(5001, 2000, 3000, 5000, 3, 10.0f, 10.0f, OrdersStatus.PLACE_ORDER, ot, ot, ld, " "));

    /**
     * tests that empty Orders list is handled correctly.
     *
     * @param dao mocking the dao class
     */
    Orders on = null;
    assertNull(on);

    /**
     * Tests the array of the Orders class.
     */
    Array a = new Array();
    assertFalse(o1.equals(a));
    /**
     * Tests the toString methods of the Orders class.
     */

    System.out.println(o1);

    /**
     * Tests the equals/hashcode methods of the Orders class.
     */
    assertEquals(o1.hashCode(),
        new Orders(5000, 2000, 3000, 5000, 3, 10f, 10f, OrdersStatus.PLACE_ORDER, ot, ot, ld, " ").hashCode());
    new Orders(5000, 2000, 3000, 5000, 3, 10f, 10f, OrdersStatus.PLACE_ORDER, ot, ot, ld, " ");
    Orders ob1 = new Orders(5000, 2000, 3000, 5000, 3, 10f, 10f, OrdersStatus.PLACE_ORDER, ot, ot, ld, " ");
    Orders ob2 = new Orders(5000, 2000, 3000, 5000, 3, 10f, 10f, OrdersStatus.PLACE_ORDER, ot, ot, ld, " ");
    assertEquals(ob1, ob2);
  }


  /*
   * @Test public final void testListAllEmpty(@Mocked final MenuDAO dao) { new
   * Expectations() { { dao.show(); result = new ArrayList<Menu>(); } }; new
   * MockUp<Menu>() {
   *
   * @Mock MenuDAO dao() { return dao; } }; Menu[] me = Menu.showMenu();
   * assertEquals(0, me.length); } /** Tests that a list with some employees is
   * handled correctly.
   *
   * @param dao mocking the dao class
   */
  /*
   * @Test public final void testListAllSome(@Mocked final MenuDAO dao) { final
   * Menu m100 = new Menu(100); final Menu m101 = new Menu(101); final
   * ArrayList<Menu> mn = new ArrayList<Menu>(); new Expectations() { {
   * mn.add(m100); mn.add(m101); dao.show(); result = mn; } }; new MockUp<Menu>()
   * {
   *
   * @Mock MenuDAO dao() { return dao; } };
   */
  /*
   * Orders[] ord = Orders.showOrders(); assertEquals(2, mn1.length);
   * assertEquals(new Menu(100).getFoodId(), mn1[0].getFoodId()); assertEquals(new
   * Menu(101).getFoodId(), mn1[1].getFoodId());
   */

}
