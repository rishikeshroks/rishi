package com.hexaware.FTP107.model;
import java.util.Objects;
import java.util.Date;
import java.sql.Time;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Orders {
 /**
  * foodId to store foodId.
  */
  private int oId;
  private int custId;
  private int venId;
  private int foodId;
  private int qty;
  private float totPrice;
  private float totCal;
  private OrdersStatus oStatus;
  private Time estTime;
  private Time oTime;
  private Date oDate;
  private  String oReason;
  /**
   * Default Constructor.
   */
  public Orders() {

  }
  /**
 * @param argOId to initialize this Oid.
 * used to get details through constructor.
 * @param argCustId to initialize this Custid.
 * used to get details through constructor.
 * @param argVenId to initialize this Venid.
 * used to get details through constructor.
 * @param argFoodId to initialize this Foodid.
 * used to get details through constructor.
 * @param argQty to initialize this Qty.
 * used to get details through constructor.
 * @param argTotPrice to initialize this TotPrice.
 * used to get details through constructor.
 * @param argTotCal to initialize this TotCal.
 * used to get details through constructor.
 *@param argOStatus to initialize this OStatus.
 * used to get details through constructor.
 * @param argEstTime to initialize this EstTime.
 * used to get details through constructor.
 * @param argOTime initialize this OTime.
 * used to get details through constructor.
 * @param argODate to initialize this ODate.
 * used to get details through constructor.
 * @param argOReason to initialize this OReason.
 * used to get details through constructor.
 */
  public Orders(final int argOId,
      final int argCustId,
      final int argVenId,
      final int argFoodId,
      final int argQty,
      final float argTotPrice,
      final float argTotCal,
      final OrdersStatus argOStatus,
      final Time argEstTime,
      final Time argOTime,
      final Date argODate,
      final String argOReason) {
    this.oId = argOId;
    this.custId = argCustId;
    this.venId = argVenId;
    this.foodId = argFoodId;
    this.qty = argQty;
    this.totPrice = argTotPrice;
    this.totCal = argTotCal;
    this.oStatus = argOStatus;
    this.estTime = argEstTime;
    this.oTime = argOTime;
    this.oDate = argODate;
    this.oReason = argOReason;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders order = (Orders) obj;
    if (Objects.equals(oId, order.oId)
        && Objects.equals(custId, order.custId)
        && Objects.equals(venId, order.venId)
        && Objects.equals(foodId, order.foodId)
        && Objects.equals(qty, order.qty)
        && Objects.equals(totPrice, order.totPrice)
        && Objects.equals(totCal, order.totCal)
        && Objects.equals(oStatus, order.oStatus)
        && Objects.equals(estTime, order.estTime)
        && Objects.equals(oTime, order.oTime)
        && Objects.equals(oDate, order.oDate)
        && Objects.equals(oReason, order.oReason)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(oId, custId, venId, foodId, qty,
    totPrice, totCal, oStatus, estTime, oTime, oDate, oReason);
  }
  @Override
  public final String toString() {
    return (this.oId + " " + this.custId + " " + this.venId + " " + this.foodId
      + " " + this.qty + " " + this.totPrice + " " + this.totCal
      + " " + this.oStatus + " " + this.estTime + " " + this.oTime + " " + this.oDate + " " + this.oReason);
  }
    /**
     * @return this Order ID.
     */
  public final int getOId() {
    return this.oId;
  }
    /**
     * @return this Customer ID.
     */
  public final int getCustId() {
    return this.custId;
  }
    /**
     * @return this Vendor ID.
     */
  public final int getVenId() {
    return this.venId;
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return this.foodId;
  }
    /**
     * @return this Quantity .
     */
  public final int getQty() {
    return this.qty;
  }
    /**
     * @return this total price.
     */
  public final float getTotPrice() {
    return this.totPrice;
  }
    /**
     * @return this total calories.
     */
  public final float getTotCal() {
    return this.totCal;
  }
    /**
     * @return this order status.
     */
  public final OrdersStatus getOStatus() {
    return this.oStatus;
  }
    /**
     * @return this estimated time.
     */
  public final Time getEstTime() {
    return this.estTime;
  }
    /**
     * @return this order time.
     */
  public final Time getOTime() {
    return this.oTime;
  }
    /**
     * @return this order date.
     */
  public final Date getODate() {
    return (Date) this.oDate;
  }
    /**
     * @return this order reason.
     */
  public final String getOReason() {
    return this.oReason;
  }
    /**
     * @param argOId gets the order id.
     */
  public final void setOid(final int argOId) {
    this.oId = argOId;
  }
    /**
     * @param argCustId gets the customer id.
     */
  public final void setCustId(final int argCustId) {
    this.custId = argCustId;
  }
    /**
     * @param argVenId gets the vendor id.
     */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
    /**
     * @param argQty gets the Quantity.
     */
  public final void setQty(final int argQty) {
    this.qty = argQty;
  }
    /**
     * @param argTotPrice gets the Total Price.
     */
  public final void setTotPrice(final float argTotPrice) {
    this.totPrice = argTotPrice;
  }
    /**
     * @param argTotCal gets the Total Calories.
     */
  public final void setTotalCal(final float argTotCal) {
    this.totCal = argTotCal;
  }
    /**
     * @param argOStatus gets the Order Status.
     */
  public final void setOStatus(final OrdersStatus argOStatus) {
    this.oStatus = argOStatus;
  }
    /**
     * @param argEstTime gets the Estimated time.
     */
  public final void setEstTime(final Time argEstTime) {
    this.estTime = argEstTime;
  }
    /**
     * @param argOTime gets the order time.
     */
  public final void setOTime(final Time argOTime) {
    this.oTime = argOTime;
  }
    /**
     * @param argODate gets the order date.
     */
  public final void setODate(final Date argODate) {
    this.oDate = (Date) argODate.clone();
  }
    /**
     * @param argOReason gets the order reason.
     */
  public final void setOReason(final String argOReason) {
    this.oReason = argOReason;
  }
}
