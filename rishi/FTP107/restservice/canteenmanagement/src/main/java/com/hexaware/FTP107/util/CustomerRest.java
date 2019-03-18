package com.hexaware.FTP107.util;
import java.time.LocalDateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP107.model.Customer;
import com.hexaware.FTP107.model.Menu;
import com.hexaware.FTP107.model.Orders;
import com.hexaware.FTP107.factory.CustomerFactory;

/**
 * This class provides status.
 */

/**
 * This class provides a REST interface for the Customer entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @return the menu details
   */
  @GET
  @Path("/custinfo")
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] customerInfo() {
    Customer[] cust = CustomerFactory.showCustomer();
    return cust;
  }
  /**
   * Returns Customer details.
   * @param cUserName customer username.
   * @param cPassword customer password.
   * @return the login details
   */
  @GET
  @Path("/clogin")
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer customerLogin(
      @QueryParam("cUserName") final String cUserName, @QueryParam("cPassword") final String cPassword) {
    Customer cust = CustomerFactory.showCustomerLogin(cUserName, cPassword);
    if (cust == null) {
      throw new NotFoundException("Invalid Username and Password" + cUserName + "and" + cPassword);
    }
    return cust;
  }

  /**
   * Returns Customer details.
   * @param custId customer ID.
   * @param custOrder Orders object.
   * @return the place order details
   */
  @POST
  @Path("/placeorder/{custId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Status placeOrder(
      @PathParam("custId") final int custId, final Orders custOrder) {

    Status st = new Status();
    int retValue = 0;
    String retMsg = null;
    Customer c = CustomerFactory.getCWallet(custId);
    if (custOrder != null && c != null) {
      int foodId = custOrder.getFoodId();
      int qty = custOrder.getQty();
      Menu[] menu = CustomerFactory.placeOrder(foodId);
      for (Menu m : menu) {
        if (m != null && qty >= 1) {
          LocalDateTime date =  LocalDateTime.now();
          retValue = CustomerFactory.placeOrder(custId, qty, m, date);

        }
      }
      if (retValue == 1) {
        retMsg = "Order is placed";
      }
      st.setMsg(retMsg);
      System.out.println(st.getMsg());
    }
    return st;
  }

  /**
   * Returns Customer details.
   * @param custId customerID
   * @return wallet details
   */
  @GET
    @Path("/showwallet/{custId}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Customer getCWallet(@PathParam("custId") final int custId) {
    Customer ct = CustomerFactory.getCWallet(custId);
    if (ct == null) {
      throw new NotFoundException(custId + "not found");
    }
    return ct;
  }
}
