package com.hexaware.FTP107.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP107.model.Customer;
import com.hexaware.FTP107.model.Orders;
import com.hexaware.FTP107.model.OrdersStatus;
import com.hexaware.FTP107.persistence.CustomerDAO;
import com.hexaware.FTP107.persistence.OrdersDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class OrdersFactoryTest {
  /**
   * tests that vendor history is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void vendorOrderHistory(@Mocked final OrdersDAO dao) {
    final List<Orders> order = new ArrayList<Orders>();
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = "place order";
    int expSize = 1;
    final Orders or = new Orders(5004, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, res);
    order.add(or);

    new Expectations() {
        {
          System.out.println("mocked get all vendor's orders details ");
          dao.showAllOrderDetailsforVendor(3003);
          result = order;
        } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders[] co = OrdersFactory.showDetailsforVendor(3003);
    assertEquals(expSize, co.length);
    assertEquals(or, co[0]);
  }
  /**
   * tests that vendor history is handled correctly.
   * @param dao mocking the dao class
   
  @Test
  public final void showGst(@Mocked final OrdersDAO dao) {
    final List<Orders> order = new ArrayList<Orders>();
    OrdersStatus o = OrdersStatus.valueOf("DELIVERED");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final float gst = 1.0f;
    final String res = "place order";
    final int venId =1;
    final int month =1;
    final int year =1; 

    final Orders or = new Orders(5004, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, res);

    new Expectations() {
        {
          System.out.println("mocked get all vendor's gst details ");
          dao.showGst(3003,03,2019);
          result = gst;
        } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Double Gst = OrdersDAO.showGst(venId,month,year);
    assertEquals(1,1,1);

  } */
   /**
  * tests that customer history is handled correctly.
  * @param dao mocking the dao class
  */

  @Test
  public final void customerOrderHistory(@Mocked final OrdersDAO dao) {
    final List<Orders> order = new ArrayList<Orders>();
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = " ";
    int expSize = 1;
    final Orders or = new Orders(5004, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, res);
    order.add(or);

    new Expectations() {
        {
          System.out.println("mocked get all customer's orders details ");
          dao.showAllOrderDetailsforCustomer(2002);
          result = order;
        } };
    new MockUp<OrdersFactory>() {
        @Mock
     OrdersDAO dao() {
        return dao;
        }
    };
    Orders[] co = OrdersFactory.showDetailsforCustomer(2002);
    assertEquals(expSize, co.length);
    assertEquals(or, co[0]);
  }

     /**
  * @param dao mocking the dao class
  */
  @Test
  public final void updatedOrder(@Mocked final OrdersDAO dao) {
    final List<Orders> order = new ArrayList<Orders>();
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());

    final String res = " ";
    int expSize = 1;

    final Orders or = new Orders(5007, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, res);
    order.add(or);

    new Expectations() {
        {
          System.out.println("mocked get updated orders details ");
          dao.showOrder(5007);
          result = order;
        } };
    new MockUp<OrdersFactory>() {
          @Mock
   OrdersDAO dao() {
        return dao;
      }
      };
    Orders[] uo = OrdersFactory.showUpdatedOrder(5007);
    assertEquals(expSize, uo.length);
    assertEquals(or, uo[0]);
  }
      /**
  * tests that order placed list is handled correctly.
  * @param dao mocking the dao class
  */

  @Test
  public final void setrdersPlaced(@Mocked final OrdersDAO dao) {
    final List<Orders> order = new ArrayList<Orders>();
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = " ";
    int expSize = 1;
    final Orders or = new Orders(5007, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
         od, res);
    order.add(or);
    new Expectations() {
        {
          System.out.println("mocked get updated orders details ");
          dao.show(3003);
          result = order;
        } };
    new MockUp<OrdersFactory>() {
        @Mock
  OrdersDAO dao() {
        return dao;
      }
      };
    Orders[] op = OrdersFactory.showOrdersPlaced(3003);
    assertEquals(expSize, op.length);
    assertEquals(or, op[0]);
  }
     /**
  * tests that orders delivered list is handled correctly.
  * @param dao mocking the dao class
  */
  @Test
  public final void setOrdersDelivered(@Mocked final OrdersDAO dao) {
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = " ";
    final Orders or = new Orders(5007, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, res);
    final int expected = 2;

    new Expectations() {
        {
          System.out.println("mocked get delivered orders details ");
          dao.setOrderStatusAsDelivered(5007);
          result = expected;
        } };
    new MockUp<OrdersFactory>() {
        @Mock
  OrdersDAO dao() {
        return dao;
      }
      };
    int d1 = OrdersFactory.accepted(5007);
    assertEquals(expected, d1);
  }
     /**
  * tests that orders cancelled list is handled correctly.
  * @param dao mocking the dao class
  */
  @Test
  public final void setOrdersCancelled(@Mocked final OrdersDAO dao) {
    final int rowsUpdated;
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = " ";
    final Orders or = new Orders(5007, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, res);
    rowsUpdated = or.getOId();

    new Expectations() {
        {
          System.out.println("mocked get cancelled orders details ");
          dao.setOrderStatusAsCancelled(5007);
          result = rowsUpdated;
        } };
    new MockUp<OrdersFactory>() {
        @Mock
  OrdersDAO dao() {
        return dao;
      }
      };
    int actualResult = OrdersFactory.denied(5007);
    assertEquals(rowsUpdated, actualResult);
  }
     /**
  * tests that place order list is handled correctly.
  * @param dao mocking the dao class
  */
  @Test
  public final void orderQueryTest(@Mocked final OrdersDAO dao) {
    final int rowsUpdated = 1;
    final OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    final String status = o.name();
    final LocalDateTime date =  LocalDateTime.now();
    final String res = null;

    new Expectations() {
        {
          System.out.println("mocked place order details ");
          DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          String od = date.format(df);

          DateTimeFormatter tf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
          String et1 = date.format(tf1);
          dao.insertQuery(2002, 3003, 4004, 3, 140.0f, 96.0f, status, et1, et1, od, res);
          result = rowsUpdated;
        } };
    new MockUp<OrdersFactory>() {
        @Mock
  OrdersDAO dao() {
        return dao;
      }
      };
    System.out.println(date);
    int actualResult = OrdersFactory.orderQuery(4004, 3003, 2002, 3, 140.0f, 96.0f, date);
    assertEquals(rowsUpdated, actualResult);
  }
     /**
  * tests that checking orders list is handled correctly.
  * @param dao mocking the dao class
  * @param cdao mocking the dao class
  */
  @Test
  public final void checkingOrders(@Mocked final OrdersDAO dao, @Mocked final CustomerDAO cdao) {
    final int rowsUpdatedD, rowsUpdatedRW, rowsUpdatedA, rowsUpdatedO, rowsUpdatedOd;
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = " ";
    final Customer cu = new Customer(2002, "rahul", "rahul", "rahul1", 99.0f,
        "rahul@gmail.com", "90876767686", "bangalore");
    final Orders or = new Orders(5007, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, res);
    rowsUpdatedD = 1;
    rowsUpdatedA = 1;
    rowsUpdatedRW = 1;
    rowsUpdatedO = 2;
    rowsUpdatedOd = 1;


    new Expectations() {
        {
          System.out.println("mocked get checking orders 1 ");
          dao.setOrderStatusAsCancelled(5007);
          result = rowsUpdatedD;
          dao.setOrderStatusAsDelivered(5007);
          result = rowsUpdatedA;
          dao.showoid(5007);
          result = or;
        } };
    new MockUp<OrdersFactory>() {
        @Mock
  OrdersDAO dao() {
        return dao;
      }
      };

    new Expectations() {
        {
          System.out.println("mocked get checking orders 2 ");
          cdao.getWalletBal(2002);
          result = cu;
          cdao.setRevertWallet(239.0, 2002);
          result = rowsUpdatedRW;
      } };
    new MockUp<CustomerFactory>() {
        @Mock
      CustomerDAO dao() {
        return cdao;
      }
      };
    int actualResultD = OrdersFactory.denied(5007);
    int value1 = OrdersFactory.checkOrders(5007, 2);
    int value2 = OrdersFactory.checkOrders(5007, 1);
    int actualResultA = OrdersFactory.accepted(5007);
    Customer c = CustomerFactory.getCWallet(2002);
    int actualResultW = CustomerFactory.walletRevert(99.0f, 140.0f, 2002);
    assertEquals(rowsUpdatedA, actualResultA);
    assertEquals(rowsUpdatedD, actualResultD);
    assertEquals(rowsUpdatedRW, actualResultW);
    assertEquals(value1, rowsUpdatedO);
    assertEquals(rowsUpdatedOd, value2);
    assertEquals(c, cu);
  }
       /**
  * tests that default constructor is handled correctly.
  */
  @Test
   public final void defaultConstructor() {
    OrdersFactory of = new OrdersFactory();
    assertNotNull(of);

  }
     /**
  * Tests the db.
   */
  @Test
    public final void testDao() {
    OrdersDAO od = OrdersFactory.dao();
    assertNotNull(od);
    Orders[] on = OrdersFactory.showAllOrders();
    assertNotNull(on);
  }

     /**
  * tests that place order list is handled correctly.
  * @param odao mocking the dao class
  */

  @Test
   public final void showgiventest(@Mocked final OrdersDAO odao) {
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final int expectedSize = 1;
    final int oa = 1;
    final Orders oe = new Orders(5007, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, "placed");

    new Expectations() { {
        System.out.println("mocked getOrders ");
        odao.showoid(5007);
        result = oe;
      } };
    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("mocked dao");
            return odao;
        }
    };
    Orders ot = OrdersFactory.showOrderGivenId(5007);
    assertEquals(oe, ot);
  }
     /**
  * tests that place order list is handled correctly.
  * @param oudao mocking the dao class
  */
  @Test
   public final void testupdatecom(@Mocked final OrdersDAO oudao) {
    final int expectedSize = 1;
    final int oupdate = 1;
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders oupstatus = new Orders(5007, 2002, 3003, 4004, 3, 140.0f, 96.0f, o, t, t,
        od, "placed");
    new Expectations() { {
        System.out.println("mocked updatestatus ");
        oudao.updateReason(5007, "placed");
        result = oupdate;
      } };
    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("mocked dao");
            return oudao;
        }
    };
    int ocp = OrdersFactory.updateCom("placed", 5007);
    assertEquals(ocp, expectedSize);
  }

}


