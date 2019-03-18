package com.hexaware.FTP107.util;
import javax.ws.rs.GET;
//import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP107.model.Orders;
import com.hexaware.FTP107.factory.OrdersFactory;
import com.hexaware.FTP107.model.OrdersStatus;
/**
 * This class provides a REST interface for the employee entity.
 */

class Status {
  private String msg;
  /**
 * This class provides a REST interface for the employee entity.
 */
  Status() {
  }
  /**
 * This class provides a REST interface for the employee entity.
 * @return tag.
 */
  public final String getMsg() {
    return msg;
  }
  /**
 * This class provides a REST interface for the employee entity.
 * @param st tag.
 */
  public final void setMsg(final String st) {
    msg = st;
  }
}
  /**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orders")
public class OrdersRest {
/**
   * Returns orders details.
   * @return the orders details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] listOrders() {
    Orders[] orders = OrdersFactory.showAllOrders();
    return orders;
  }
/**
   * Returns customerhistory details.
   * @param custId to update the record.
   * @return the orders details
   */
  @GET
  @Path("/cust/{custId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] customerhistory(@PathParam("custId")  final int custId) {
    Orders[] custhist = OrdersFactory.showDetailsforCustomer(custId);
    return custhist;
  }
  /**
   * Returns vendorhistory details.
   * @param venId to update the record.
   * @return the orders details
   */
  @GET
  @Path("/ven/{venId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] vendorhistory(@PathParam("venId")  final int venId) {
    Orders[] venhist = OrdersFactory.showDetailsforVendor(venId);
    return venhist;

  }
  /**
   * Returns gst details.
   * @param venId to get the gst.
   */
  @GET
    @Path("/showgst/{venId}/{month}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public static double showGst(@PathParam("venId") final int venId,@PathParam("month") final int month,@PathParam("year") final int year) {
    double gst=OrdersFactory.showGst(venId,month,year);
    return gst;
}

  /**
   * Returns Orders details.
   * @param oId get.
   * @param argOrd get.
   * @return the Orders details
   */
  @PUT
  @Path("/update/{oId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Status changeStatus(@PathParam("oId") final int oId, final Orders argOrd) {
    Status st = new Status();
    Orders oIdDb = OrdersFactory.showOrderGivenId(oId);
    if (oIdDb != null && argOrd != null && oIdDb.getOId() == argOrd.getOId()) {
      int opt = 0;
      if (argOrd.getOStatus() == OrdersStatus.DELIVERED) {
        opt = 1;
      } else if (argOrd.getOStatus() == OrdersStatus.CANCELLED) {
        opt = 2;
      } else {
        opt = 0;
      }
      int ret = OrdersFactory.checkOrders(oId, opt);
      int ret1 = OrdersFactory.updateCom(argOrd.getOReason(), oId);
      if (ret == 1 && ret1 == 1) {
        String st1 = "Order updated successfully";
        st.setMsg(st1);
        System.out.println(st.getMsg());
      } else if (ret == 2 && ret1 == 1) {
        String st2 = "Order denied";
        st.setMsg(st2);
        System.out.println(st.getMsg());
      } else {
        String st3 = "Invalid input";
        st.setMsg(st3);
        System.out.println(st.getMsg());
      }
    } else {
      String st4 = "invalid user data";
      st.setMsg(st4);
      System.out.println(st.getMsg());
    }
    return st;
  }

  /**

* Returns Order details.

* @param vId vid.


* @return the order details

*/

  @GET

  @Path("/placed/{vId}")

  @Produces(MediaType.APPLICATION_JSON)

public final Orders[] getPlacedHis(

      @PathParam("vId") final int vId) {
    Orders[] orders = OrdersFactory.showOrdersPlaced(vId);
    if (orders == null) {
      System.out.println("no such vid" + vId);
    }
    return orders;
  }
}
