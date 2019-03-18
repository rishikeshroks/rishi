package com.hexaware.FTP107.factory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.hexaware.FTP107.model.Customer;
import com.hexaware.FTP107.model.Orders;
import com.hexaware.FTP107.model.OrdersStatus;
import com.hexaware.FTP107.persistence.DbConnection;
import com.hexaware.FTP107.persistence.OrdersDAO;

/**
 * MenuFactory class used to fetch menu data from database.
 *
 * @author hexware
 */
public class OrdersFactory {
    /**
     * Protected constructor.
     */
  protected OrdersFactory() {

  }
    /**
     * Call the data base connection.
     *
     * @return the connection object.
     */
  public static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
    /**
     * Call the data base connection.
     *@param fId to update the record.
     *@param vId to update the record.
     *@param cId to update the record.
     *@param qty to update the record.
     *@param totalPrice to update the record.
     *@param totCal to update the record.
     *@param date date attribute.
     *@return integer value
     */
  public static int orderQuery(final int fId, final int vId, final int cId, final int qty,
      final float totalPrice, final float totCal, final LocalDateTime date) {
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String od = date.format(df);

    DateTimeFormatter tf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
    String et1 = date.format(tf1);
    OrdersDAO dao = dao();
    String res = null;
    int orderPl = dao.insertQuery(cId, vId, fId, qty, totalPrice, totCal, o.name(),
        et1, et1, od, res);
    return orderPl;
  }
    /**
     * Call the data base connection.
     *@param custId cid tag.
     * @return the array of orders object to corresponding customer
     */
  public static Orders[] showDetailsforCustomer(final int custId) {
    List<Orders> orders = dao().showAllOrderDetailsforCustomer(custId);
    return orders.toArray(new Orders[orders.size()]);
  }
        /**
     * Call the data base connection.
     *@param venId vid tag.
     * @return the array of orders object to corresponding vendor
     */
  public static Orders[] showDetailsforVendor(final int venId) {
    List<Orders> orders = dao().showAllOrderDetailsforVendor(venId);
    return orders.toArray(new Orders[orders.size()]);
  }
        /**
     * Call the data base connection.
     *@param venId vid tag.
     * @return the gst of month to corresponding vendor
     */
  public static Double showGst(final int venId,final int month,final int year) {
    Double Gst = dao().showGst(venId,month,year);
    return Gst;
  }

      /**
   * Call the data base connection.
   * @param oId to update the record.
   * @return the array of Orders object.
   */
  public static Orders[] showUpdatedOrder(final int oId) {
    List<Orders> order = dao().showOrder(oId);
    return order.toArray(new Orders[order.size()]);
  }
/**
   * Call the data base connection.
   * @param venId to update the record.
   * @return the array of Orders object.
   */
  public static Orders[] showOrdersPlaced(final int venId) {
    List<Orders> order = dao().show(venId);
    return order.toArray(new Orders[order.size()]);
  }
  /**
   * Call the data base connection.
   * @param oId to update the record.
   * @return the array of Orders object.
   */
  public static int accepted(final int oId) {
    int value = dao().setOrderStatusAsDelivered(oId);
    return value;
  }

  /**
   * Call the data base connection.
   * @param oId to update the record.
   * @return the array of Orders object.
   */
  public static int denied(final int oId) {
    int sat = dao().setOrderStatusAsCancelled(oId);
    return sat;
  }
  /**
   * Call the data base connection.
   * @param oId to update the record.
   * @param opt to update the record.
   * @return odeny orders object.
   */
  public static int checkOrders(final int oId, final int opt) {
    if (opt == 1) {
      int result = OrdersFactory.accepted(oId);
      return result;
    } else {
      OrdersFactory.denied(oId);
      Orders odeny = dao().showoid(oId);
      Customer cust = CustomerFactory.getCWallet(odeny.getCustId());
      CustomerFactory.walletRevert(cust.getCWallet(), odeny.getTotPrice(), odeny.getCustId());
      return 2;

    }
  }
       /**
     * Call the data base connection.
     *
     * @return the array of orders object.
     */
  public static Orders[] showAllOrders() {
    List<Orders> order = dao().show();
    return order.toArray(new Orders[order.size()]);
  }
    /**
   * Call the data base connection.
   * @param oId to update the record.
   * @return the array of orders object.
   */
  public static Orders showOrderGivenId(final int oId) {
    Orders ord = dao().showoid(oId);
    return ord;
  }
     /**
   * Call the data base connection.
   * @param oReason to update the record.
   * @param oId to update the record
     * @return the array of orders object.
     */
  public static int updateCom(final String oReason, final int oId) {
    int up = dao().updateReason(oId, oReason);
    return up;
  }
}
