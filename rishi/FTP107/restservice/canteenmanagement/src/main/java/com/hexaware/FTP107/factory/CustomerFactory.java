package com.hexaware.FTP107.factory;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.FTP107.model.Customer;
import com.hexaware.FTP107.model.Menu;
import com.hexaware.FTP107.persistence.CustomerDAO;
import com.hexaware.FTP107.persistence.DbConnection;

/**
 * MenuFactory class used to fetch menu data from database.
 *
 * @author hexware
 */
public class CustomerFactory {
    /**
     * Protected constructor.
     */
  protected CustomerFactory() {

  }

    /**
     * Call the data base connection.
     *
     * @return the connection object.
     */
  public static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }

    /**
     * Call the data base connection.
     *
     * @return the array of menu object.
     */
  public static Customer[] showCustomer() {
    List<Customer> customer = dao().show();
    return customer.toArray(new Customer[customer.size()]);
  }

    /**
     * @param        <Menu>
     * @param foodId to set.
     * @return menu.
     */
  public static Menu[] placeOrder(final int foodId) {
    List<Menu> menu = dao().getFoodId(foodId);
    return menu.toArray(new Menu[menu.size()]);
  }

  /**
   * @param cUserName for validation.
   * @param cPassword for validation.
   * @return customer
   */
  public static Customer showCustomerLogin(final String cUserName, final String cPassword) {
    Customer c = dao().showCLogin(cUserName, cPassword);
    if (c != null) {
      String un = c.getCUserName();
      String pass = c.getCPassword();
      if (un.equals(cUserName) && pass.equals(cPassword)) {
        return c;
      } else {
        return null;
      }
    }
    return null;
  }
/**
 * @param cuId for custId.
 * @param qty for quantity.
 * @param m for menu.
 * @param date for menu.
 * @return for order placing.
 */

  public static int placeOrder(final int cuId, final int qty, final Menu m, final LocalDateTime date) {
    int fId = m.getFoodId();
    int vId = m.getVId();
    int cId = cuId;
    float price = (float) m.getPrice();
    float totalPrice = price * qty;
    float totcal = (float) m.getFoodCal() * qty;
    Customer c = CustomerFactory.getCWallet(cId);
    double walAmount = c.getCWallet();
    int oResult;
    boolean valCheck = CustomerFactory.validateWallet(walAmount, totalPrice, cuId);

    if (valCheck) {
      oResult = OrdersFactory.orderQuery(fId, vId, cId, qty, totalPrice, totcal, date);
    } else {
      return 2;
    }
    if (oResult == 1) {
      System.out.println("Your Order is placed");
    } else {
      System.out.println("Insufficient balance");
    }
    return oResult;

  }
     /**
   * Call the data base connection.
   * @param custId for wallet.
   * @return the array of customer object.
   */
  public static Customer getCWallet(final int custId) {
    Customer ar = dao().getWalletBal(custId);
    return ar;
  }
    /**
   * @param walAmount for wallet.
   * @param totPrice for total price.
   * @param custId for updating.
   * @return true or false.
   */

  public static boolean validateWallet(final double walAmount, final double totPrice, final int custId) {
    if (walAmount < totPrice) {
      System.out.println("insufficient balance");
      return false;
    } else {
      CustomerFactory.walletDeduct(walAmount, totPrice, custId);
      return true;
    }
  }
  /**
   * @param walAmount for wallet.
   * @param totPrice for total price.
   * @param custId for updating.
   * @return the updated value.
   */

  public static final int walletDeduct(final double walAmount, final double totPrice, final int custId) {
    double walBalance = walAmount - totPrice;
    int subUpdate = dao().setDeductWallet(walBalance, custId);
    return subUpdate;
  }
  /**
   * @param walAmount for wallet.
   * @param totPrice for total price.
   * @param custId for updating.
   * @return the value.
   */
  public static final int walletRevert(final double walAmount, final double totPrice, final int custId) {
    double walRebalance = walAmount + totPrice;
    int addUpdate = dao().setRevertWallet(walRebalance, custId);
    return addUpdate;
  }


}
