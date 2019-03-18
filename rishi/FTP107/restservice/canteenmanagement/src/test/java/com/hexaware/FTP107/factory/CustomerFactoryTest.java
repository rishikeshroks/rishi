package com.hexaware.FTP107.factory;
import com.hexaware.FTP107.model.Customer;
import com.hexaware.FTP107.persistence.CustomerDAO;

import com.hexaware.FTP107.model.Menu;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;




/**
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerFactoryTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
    /**
  * Tests the constructor.
   */
  @Test
    public final void constructorTest() {
    CustomerFactory c5 = new CustomerFactory();
    assertNotNull(c5);
  }
    /**
  * Tests the customer login.
  * @param cdao for custid.
   */
  @Test
    public final void showCustomerLoginTest(
      @Mocked final CustomerDAO cdao) {
    final Customer ste = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    new Expectations() { {
        System.out.println("mocked");
        cdao.showCLogin("abc123", "er125465");
        result = ste;

      } };
    new MockUp<CustomerFactory>() {
      @Mock
        CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
    };
    Customer c = CustomerFactory.showCustomerLogin("abc123", "er125465");
    assertEquals(c, ste);
  }
    /**
  * Tests the showcustomer login1.
  * @param cdao for custid.
   */
  @Test
    public final void showCustomerLoginTest1(
      @Mocked final CustomerDAO cdao) {
    final Customer ste = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    new Expectations() { {
        System.out.println("mocked");
        cdao.showCLogin(null, null);
        result = null;

      } };
    new MockUp<CustomerFactory>() {
      @Mock
    CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
    };
    Customer c = CustomerFactory.showCustomerLogin(null, null);
    assertNull(c);
  }
    /**
  * Tests the customer login2.
  * @param cdao for custid.
   */
  @Test
    public final void showCustomerLoginTest2(
        @Mocked final CustomerDAO cdao) {
    final Customer ste = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    new Expectations() { {
        System.out.println("mocked");
        cdao.showCLogin("Anup", "abc13");
        result = ste;

      } };
    new MockUp<CustomerFactory>() {
      @Mock
    CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
    };
    Customer c = CustomerFactory.showCustomerLogin("Anup", "abc13");
    assertNotEquals(ste, c);
  }
    /**
  * Tests the placeorder.
  * @param mdao for menu.
   */
  @Test
    public final  void placeOrderTest(
        @Mocked final CustomerDAO mdao) {
    int expectedSize = 1;
    final List<Menu> ste = new ArrayList<Menu>();
    final Menu s = new Menu(1000, "dosa", 2000, 20.6, "northindian", "2 plates", 34.9);
    ste.add(s);

    new Expectations() { {
        System.out.println("mocked placeorder Details");
        mdao.getFoodId(1000);
        result = ste;
        } };

    new MockUp<CustomerFactory>() {
        @Mock
    CustomerDAO dao() {
        System.out.println("mocked dao");
            return mdao;
        }

        };
    Menu[] sta = CustomerFactory.placeOrder(1000);
    assertEquals(expectedSize, sta.length);
  }
    /**
  * Tests the wallet details.
  * @param cdao for custid.
   */
  @Test
    public final void getCWalletTest(
      @Mocked final CustomerDAO cdao) {
    final Customer ste = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    new Expectations() { {
        System.out.println("mocked");
        cdao.getWalletBal(2000);
        result = ste;

        } };
    new MockUp<CustomerFactory>() {
      @Mock
        CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
    };
    Customer c = CustomerFactory.getCWallet(2000);
    assertEquals(c, ste);
  }
    /**
  * Tests the deduction of wallet.
  * @param cdao for custid.
   */
  @Test
    public final void walletDeductTest(
        @Mocked final CustomerDAO cdao) {
    final int a = 1;
    final double walAmount = 800.00;
    final double totPrice = 450.8;
    final int cId = 2000;
    new Expectations() { {
        System.out.println("mocked");
        double walBalance = walAmount - totPrice;
        cdao.setDeductWallet(walBalance, 2000);
        result = a;

      } };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
      };
    int c = CustomerFactory.walletDeduct(walAmount, totPrice, cId);
    assertEquals(a, c);
  }
    /**
  * Tests the show customer.
  * @param cdao for custid.
   */
  @Test
    public final void showCustomerTest(
        @Mocked final CustomerDAO cdao) {
    int expectedSize = 1;
    final List<Customer> ste = new ArrayList<Customer>();
    final Customer s = new Customer(2000, "Anu", "abc123", "er125465", 23.0f, "sdert@1", "8664564784", "No:5,chrompet");
    ste.add(s);

    new Expectations() { {
        System.out.println("mocked show customer");
        cdao.show();
        result = ste;
        } };

    new MockUp<CustomerFactory>() {
      @Mock
        CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }

        };
    Customer[] sta = CustomerFactory.showCustomer();
    assertEquals(expectedSize, sta.length);
  }
    /**
  * Tests the wallet revertion.
  * @param cdao for custid.
   */
  @Test
    public final void walletRevertTest(
        @Mocked final CustomerDAO cdao) {
    final int b = 1;
    final double walAmount = 800.00;
    final double totPrice = 450.8;
    final int cId = 2000;

    new Expectations() { {
        System.out.println("mocked");
        double walRebalance = walAmount + totPrice;
        cdao.setRevertWallet(walRebalance, cId);
        result = b;

        }  };
    new MockUp<CustomerFactory>() {
      @Mock
    CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
      };
    int c = CustomerFactory.walletRevert(walAmount, totPrice, cId);
    assertEquals(b, c);
  }
    /**
  * Tests the wallet validation.
  * @param cdao for custid.
   */
  @Test
    public final  void validateWalletTest(
        @Mocked final CustomerDAO cdao) {
    final double walAmount = 800.00;
    final double totPrice = 450.8;
    final int cId = 2000;
    new Expectations() { {
        System.out.println("mocked");
        double walBalance = walAmount - totPrice;
        cdao.setDeductWallet(walBalance, cId);

      } };
    new MockUp<CustomerFactory>() {
      @Mock
    CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
      };
    boolean c = CustomerFactory.validateWallet(walAmount, totPrice, cId);
    assertTrue(c);
  }
    /**
  * Tests the validate wallet.
   */
  @Test
    public final void validateWalletTest1() {
    final double walAmount = 450.8;
    final double totPrice = 800.0;
    final int cId = 2000;
    new Expectations() { {
        System.out.println("mocked wallet");
        result = any;
        } };

    boolean sd = CustomerFactory.validateWallet(walAmount, totPrice, cId);
    assertFalse(sd);
  }
    /**
  * Tests the db.
   */
  @Test
    public final void testDao() {
    CustomerDAO cd = CustomerFactory.dao();
    assertNotNull(cd);

    Customer[] cn = CustomerFactory.showCustomer();
    assertNotNull(cn);
  }
  /**
  * Tests the wallet validation.
  * @param cdao for custid.
   */
  @Test
    public final void placeOrderTest1(
      @Mocked final CustomerDAO cdao) {
    final int expVal = 1;
    final int cId = 2000;
    final int qty = 2;
    final double walAmount = 800.00;
    final double totPrice = 450.8;
    final Customer ste = new Customer(2000, "Anu", "abc123", "er125465",
        (float) walAmount, "sdert@1", "8664564784", "No:5,chrompet");
    final Menu m = new Menu(1000, "dosa", 3500, 20.6, "northindian", "2 plates", 34.9);
    final LocalDateTime date =  LocalDateTime.now();
    new Expectations() { {
        System.out.println("mocked");
        cdao.getWalletBal(cId);
        result = ste;
      } };

    new MockUp<CustomerFactory>() {
      @Mock
    CustomerDAO dao() {
        System.out.println("mocked dao");
        return cdao;
        }
        @Mock
        public final int walletDeduct(final double walAmount, final double totPrice, final int custId) {
          return 1;
        }
      };

    new MockUp<OrdersFactory>() {
      @Mock
      public int orderQuery(final int fId, final int vId, final int cId, final int qty,
          final float totalPrice, final float totCal, final LocalDateTime date) {
          System.out.println("mocked orderQuery");
          return 1;
      }
    };
    int actVal = CustomerFactory.placeOrder(cId, qty, m, date);
    assertEquals(expVal, actVal);
  }
}
