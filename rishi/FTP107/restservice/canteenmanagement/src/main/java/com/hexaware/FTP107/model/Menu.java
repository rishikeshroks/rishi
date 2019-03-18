package com.hexaware.FTP107.model;

import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store food
 Id.
 */
  private int foodId;
  private String foodName;
  private int vId;
  private double price;
  private String foodCat;
  private String foodDesc;
  private double foodCal;

  /*foodId*/



  /**
   * Default Constructor.
   */
  public Menu() {
  }
/**
 * @param argFoodId to initialize
 * @param argFoodName to initialize
 * @param argVId to initialize
 * @param argPrice to initialize
 * @param argFoodCat to initialize
 * @param argFoodDesc to initialize
 * @param argFoodCal to initialize
 */
  public Menu(final int argFoodId,   final String argFoodName,  final int argVId,
              final double argPrice, final String argFoodCat,   final String argFoodDesc,
      final double argFoodCal) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.vId = argVId;
    this.price = argPrice;
    this.foodCat = argFoodCat;
    this.foodDesc = argFoodDesc;
    this.foodCal = argFoodCal;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)
        && Objects.equals(foodName, menu.foodName)
        && Objects.equals(vId, menu.vId)
        && Objects.equals(price, menu.price)
        && Objects.equals(foodCat, menu.foodCat)
        && Objects.equals(foodDesc, menu.foodDesc)
        && Objects.equals(foodCal, menu.foodCal)) {
      return true;
    }
    return false;
  }
  /**
   * @return HashValue
   */
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, foodName, vId, price, foodCat, foodDesc, foodCal);
  }
  @Override
  public final String toString() {
    return (this.foodId + " " + this.foodName + " " + this.vId + " " + this.price
      + " " + this.foodCat + " " + this.foodDesc + " " + this.foodCal);
  }
  /**
   * @param argFoodId gets the food id.
   */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /**
   * @return foodId
   */
  public final  int getFoodId() {
    return this.foodId;
  }
  /**
   * @param argFoodName to initialization
   */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  /**
   * @return foodName
   */
  public final String getFoodName() {
    return this.foodName;
  }
  /**
   * @param argVId for initialization
   */
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }
  /**
   * @return vId
   */
  public final int getVId() {
    return this.vId;
  }
  /**
   * @param argPrice for initialization
   */
  public final void setPrice(final double argPrice) {
    this.price = argPrice;
  }
  /**
   * @return price
   */
  public final double getPrice() {
    return this.price;
  }
  /**
   * @param argFoodCat for initialization
   */
  public final void setFoodCat(final String argFoodCat) {
    this.foodCat = argFoodCat;
  }
  /**
   * @return foodCat
   */
  public final String getFoodCat() {
    return this.foodCat;
  }

  /**
   * @param argFoodDesc for initialization
   * */
  public final void setFoodDesc(final String argFoodDesc) {
    this.foodDesc = argFoodDesc;
  }
  /**
   * @return foodDesc
   */
  public final String getFoodDesc() {
    return this.foodDesc;
  }

  /**
   * @param argFoodCal for initialization
   */
  public final void setFoodCal(final double argFoodCal) {
    this.foodCal = argFoodCal;
  }
  /**
   * @return foodCal
   */
  public final double getFoodCal() {
    return this.foodCal;
  }
}
