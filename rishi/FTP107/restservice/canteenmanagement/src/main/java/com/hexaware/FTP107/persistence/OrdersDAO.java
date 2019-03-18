package com.hexaware.FTP107.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP107.model.Orders;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrdersDAO {
  /**
   * @return the all the orders record.
   */
  @SqlQuery("Select * from Orders")
  @Mapper(OrdersMapper.class)
  List<Orders> showAllOrderDetails();

  /**
   * @return the specific the oid record
   * @param oid oid tag.
   */
  @SqlQuery("Select * from Orders where O_ID = :oid")
  @Mapper(OrdersMapper.class)
  Orders showoid(@Bind("oid") int oid);

  /**
   * @return the specific the customer record
   * @param cid cid tag.
   */
  @SqlQuery("Select * from Orders where C_ID = :cid")
  @Mapper(OrdersMapper.class)

  Orders showcid(@Bind("cid") int cid);

  /**
   * @return the specific the vendor record
   * @param vid vid tag.
   */
  @SqlQuery("Select * from Orders where V_ID = :vid")
  @Mapper(OrdersMapper.class)
  Orders showvid(@Bind("vid") int vid);
  /**
   * @param cId cId tag.
   * @param vId vId tag.
   * @param fId fId tag.
   * @param qty qty tag.
   * @param totalprice totalprice tag.
   * @param totcal totcal tag.
   * @param o o tag
   * @param et1 Et1 tag.
   * @param ot1 Ot1 tag.
   * @param od od tag.
   * @param res res tag.
   * @return orders.
   */
  @SqlUpdate(" INSERT INTO ORDERS(C_ID,V_ID,FOOD_ID, QTY,TOT_PRICE,TOT_CAL,O_STATUS,EST_TIME,O_TIME,O_DATE,O_REASON) VALUES(:C_ID,:V_ID,:FOOD_ID,:QTY,:TOT_PRICE,:TOT_CAL,:O_STATUS,:EST_TIME,:O_TIME,:O_DATE,:O_REASON)")
  @Mapper(OrdersMapper.class)
  int insertQuery(@Bind("C_ID") int cId, @Bind("V_ID") int vId, @Bind("FOOD_ID") int fId, @Bind("QTY") int qty,
      @Bind("TOT_PRICE") float totalprice, @Bind("TOT_CAL") float totcal, @Bind("O_STATUS") String o,
      @Bind("EST_TIME") String et1, @Bind("O_TIME") String ot1, @Bind("O_DATE") String od, @Bind("O_REASON") String res);
    /**
     * @return the specific the order record for the customer
     * @param cid cid tag.
     */
  @SqlQuery("Select * from Orders where C_ID = :cid")
    @Mapper(OrdersMapper.class)
     List<Orders> showAllOrderDetailsforCustomer(@Bind ("cid") int cid);
    /**
    * @return the specific the vendor record
    * @param vid vid tag.
    */
  @SqlQuery("Select * from Orders where V_ID = :vid")
    @Mapper(OrdersMapper.class)
    List<Orders> showAllOrderDetailsforVendor(@Bind ("vid") int vid);
 /**
    * @return the specific the vendor record
    * @param venId oid tag.
    */
  @SqlQuery("Select * from Orders where V_ID = :venId and O_STATUS = 'PLACE_ORDER'")
    @Mapper(OrdersMapper.class)
    List<Orders> show(@Bind("venId") int venId);
      /**
      * @return the specific the vendor record
      * @param oid oid tag.
      */
  @SqlQuery("Select * from Orders where O_ID = :oId")
      @Mapper(OrdersMapper.class)
      List<Orders> showOrder(@Bind ("oId") int oid);
      /**
      * @return the specific the vendor record
      * @param oid oid tag.
      */
  @SqlQuery("SELECT SUM(tot_price) * 0.05 AS GST FROM orders WHERE month (O_DATE) = :month and year(O_DATE)= :year AND V_ID = :venId and O_STATUS='DELIVERED';")

      Double showGst(@Bind ("venId") int venId, @Bind ("month") int month,@Bind ("year") int year);
      /**
      * @return the specific the vendor record
      * @param venId venId tag.
      */
  @SqlUpdate("Update Orders set  O_STATUS = 'DELIVERED' where O_ID = :oid ")
      int setOrderStatusAsDelivered(@Bind ("oid") int oid);
      /**
      * @return the specific the vendor record
      * @param oid oid tag.
      * @param oReason tag.
      */
  @SqlUpdate("Update Orders set  O_REASON = :oReason where O_ID = :oId ")
      int  updateReason(@Bind ("oId") int oid, @Bind ("oReason") String oReason);
            /**
      * @return the specific the vendor record
      * @param oid oid tag.
      */
  @SqlUpdate("Update Orders set  O_STATUS = 'CANCELLED' where O_ID = :oid ")
      int setOrderStatusAsCancelled(@Bind ("oid") int oid);
          /**
     * @return the all the cust record
     *
     */
  @SqlQuery("Select * from Orders")
    @Mapper(OrdersMapper.class)
    List<Orders> show();
}

