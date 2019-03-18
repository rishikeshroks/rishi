package com.hexaware.FTP107.util;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.hexaware.FTP107.factory.CustomerFactory;
import com.hexaware.FTP107.factory.MenuFactory;
import com.hexaware.FTP107.factory.OrdersFactory;
import com.hexaware.FTP107.factory.VendorFactory;
import com.hexaware.FTP107.model.Customer;
import com.hexaware.FTP107.model.Menu;
import com.hexaware.FTP107.model.Orders;
import com.hexaware.FTP107.model.Vendor;

/**
 * CliMain used as Client interface for java coading.
 *
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  /**
 *
 * @author hexware
 */
  private double totPrice = 0.0;
  /**
 * CliMain used as Client interface for java coading.
 *
 * @author hexware
 */
  private double totcal = 0.0;

  /**
   * mainMenu method used to display the option we had in the application.
   */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Customer Dashboard");
    System.out.println("3. Vendor Dashboard ");
    System.out.println("4. Exit");
    System.out.println("-----------------------");
    mainMenuDetails();
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          customerDashbooard();
          break;
        case 3:
          vendorDashbooard();
          break;
        case 4:
          Runtime.getRuntime().halt(0);
          break;

        default:
          System.out.println("Choose from 1 - 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
  private void customerDashbooard() {
    Customer c = customerLogin();
    if (c != null) {
      System.out.println("Welcome " + c.getCustName());
      custLog(c);
    } else {
      mainMenu();
    }
  }
  private void custLog(final Customer c) {
    System.out.println("-----------------------");
    System.out.println("1. Customer Order history");
    System.out.println("2. Order Food");
    System.out.println("3. Wallet information");
    System.out.println("4. Exit");
    System.out.println("-----------------------");
    int cust = option.nextInt();
    switch (cust) {
      case 1:
        System.out.println("Customer Order history");
        showOrderHistoryForCustomers(c);
        custLog(c);
        break;

      case 2:
        System.out.println("Order Food");
        orderFood(c);
        custLog(c);
        break;

      case 3:
        System.out.println("Wallet information");
        walletinfo(c);
        custLog(c);
        break;

      case 4:
        mainMenu();
        break;

      default:
        System.out.println("INVALID OPTION");
    }
  }

  private void vendorDashbooard() {
    Vendor v = vendorLogin();
    if (v != null) {
      System.out.println("Welcome " + v.getVenName());
      venLog(v);
    } else {
      mainMenu();
    }

  }
  private void venLog(final Vendor v) {
    System.out.println("Vendor Dashboard");
    System.out.println("-----------------------");
    System.out.println("1. Vendor Order history");
    System.out.println("2. Accept OR Cancel");
    System.out.println("3. Exit");
    System.out.println("4. Show gst");
    System.out.println("-----------------------");
    int ven = option.nextInt();

    switch (ven) {
      case 1:
        System.out.println("Vendor Order History");
        showOrderHistoryForVendors(v);
        venLog(v);
        break;

      case 2:
        System.out.println("Accept OR Cancel Orders");
        accOrders(v);
        venLog(v);
      case 3:
        mainMenu();
        break;

      case 4:
        System.out.println("The total GST for this Month is  ");
        showGst(v);
        venLog(v);
      default:
        System.out.println("INVALID OPTION");
    }
  }

  private Menu[] showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("%10s %20s %10s %10s %20s %24s %15s", "FoodId", "Food Name", "Vendor ID", "Price", "CAT", "Desc",
        "Calories");
    System.out.println();
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------------------------");
    for (Menu m : menu) {
      System.out.printf("%10s %20s %10s %10s %20s %24s %15s", m.getFoodId(), m.getFoodName(), m.getVId(), m.getPrice(),
          m.getFoodCat(), m.getFoodDesc(), m.getFoodCal());
      System.out.println();
    }
    return menu;
  }

  private Vendor vendorLogin() {
    System.out.println("Welcome to login Page");
    System.out.println("Enter your Username: ");
    String venUsername = option.next();
    System.out.println("Enter your Password: ");
    String venPassword = option.next();
    Vendor v = VendorFactory.showVendorLogin(venUsername, venPassword);
    if (v != null) {
      System.out.println("Login Succesfull");
    } else {
      System.out.println("Login Failed");
    }
    return v;
  }

  private Customer customerLogin() {

    System.out.println("Welcome to login Page");
    System.out.println("Enter your Username: ");
    String cUserName = option.next();
    System.out.println("Enter your Password: ");
    String cPassword = option.next();
    Customer c = CustomerFactory.showCustomerLogin(cUserName, cPassword);
    if (c != null) {
      System.out.println("Login Succesfull");
    } else {
      System.out.println("Login Failed");
    }

    return c;
  }


  private void orderFood(final Customer argCust) {
    showFullMenu();
    System.out.println("Enter the Food id");
    int foodId = option.nextInt();
    Menu[] obj123 = CustomerFactory.placeOrder(foodId);

    for (Menu m : obj123) {
      if (foodId != 0 && foodId == m.getFoodId()) {
        System.out.println(m);
        System.out.println("Quantity");
        int qty = option.nextInt();
        if (qty >= 1) {
          totPrice = totPrice + m.getPrice() * qty;
          System.out.println("YOur total price is -> " + totPrice);
          totcal = totcal + m.getFoodCal() * qty;
          System.out.println("Total calories   -> " + totcal);
          LocalDateTime date =  LocalDateTime.now();
          CustomerFactory.placeOrder(argCust.getCustId(), qty, m, date);
        } else {
          System.out.println("Give a valid input");
          orderFood(argCust);
        }
      }
    }

    System.out.println("Press 1 to ORDER More!!!... Press 2 for Checkout....");
    int morder = option.nextInt();
    switch (morder) {
      case 1: orderFood(argCust);
        showFullMenu();
        break;
      case 2:
        System.out.println("Thank you for ordering");
        break;
      default:
        System.out.println("INVALID OPTION");
    }

  }

  private void showOrderHistoryForCustomers(final Customer argCust) {
    Orders[] orders = OrdersFactory.showDetailsforCustomer(argCust.getCustId());
    System.out.println("Orderid"  +  "\t    "  +  "customerid"  +  "\t    "  +  "vendorid"  +  "\t  "
        +  "foodid"  +  "\t   "  +  "quantity"  +  "\t   "  +  "totalprice"  +  "\t        "  +  "totalcalories"
        +  "\t       "  +  "orderstatus"  +  "\t       "  +  "estimatedtime"  +  "\t    "  +  "ordertime"  +  "\t    "
        +  "orderdate");
    for (Orders o : orders) {
      System.out.println(o.getOId()  +  "\t      "  +  o.getCustId()  +  "\t            "  +  o.getVenId()  +  "\t           "
          +  o.getFoodId()  +  "\t            "  +  o.getQty()  +  "\t            "  +  o.getTotPrice()
          +  "\t            "   +  o.getTotCal()  +  "\t        "  +  o.getOStatus()  +  "\t         "  +  o.getEstTime()
          +  "\t    "  +  o.getOTime()  +  "\t    "  +  o.getODate());
    }

  }
  private void showOrderHistoryForVendors(final Vendor argVen) {
    Orders[] orders = OrdersFactory.showDetailsforVendor(argVen.getVenId());
    System.out.println("Orderid"  +  "\t    "  +  "customerid"  +  "\t    "  +  "vendorid"  +  "\t    "
        +  "foodid"  +  "\t    "  +  "quantity"  +  "\t     "  +  "totalprice"  +  "\t      "  +  "totalcalories"
        +  "\t  "  +  "orderstatus"  +  "\t   "  +  "estimatedtime"  +  "\t"  +  "ordertime"  +  "\t     "
        +  "orderdate");
    for (Orders m : orders) {
      System.out.println(m.getOId()  +  "\t    "  +  m.getCustId()  +  "\t            "  +  m.getVenId()  +  "\t             "
          +  m.getFoodId()  +  "\t        "  +  m.getQty()  +  "\t       "  +  m.getTotPrice()
          +  "\t        "  +  m.getTotCal()  +  "\t          "  +  m.getOStatus()  +  "\t       "  +  m.getEstTime()
          +  "\t        "  +  m.getOTime()  +  "\t     "  +  m.getODate());
    }
  }
  private  void showGst(final Vendor argVen){
    int venId = argVen.getVenId();
    System.out.println("Enter the month");
    int month = option.nextInt();
    System.out.println("Enter the year");
    int year = option.nextInt();
    Double Gst = OrdersFactory.showGst(argVen.getVenId(),month,year);
    System.out.println("your tax for this month is -->" + Gst);
  }


  private  void accOrders(final Vendor argVen) {
    int venId = argVen.getVenId();
    Orders[] order = OrdersFactory.showOrdersPlaced(venId);
    System.out.println("o_Id" + "\t" + "cust_Id" + "\t" + "ven_Id" + "\t" + "food_Id" + "\t" + "qty" + "\t" + "tot_Price" + "\t " + "tot_Cal"
        + "\t    " + "O_Status" + "\t" + "est_Time" + "\t" + "O_Time" + "\t" + "O_Date" + "\t" + "O_reason");
    for (Orders o:order) {
      System.out.println(o.getOId() + "\t" + o.getCustId() + "\t" + o.getVenId() + "\t"
          + o.getFoodId() + "\t" + o.getQty() + "\t" + o.getTotPrice() + "\t" + o.getTotCal() + "\t" + o.getOStatus() + "\t"
          + o.getEstTime() + "\t" + o.getOTime() + "\t" + o.getODate() + "\t" + o.getOReason());
    }
    System.out.println("Enter the orderid");
    int oId = option.nextInt();

    System.out.println("Press 1 for accept  Press 2 for deny");
    int opt = option.nextInt();
    int result = OrdersFactory.checkOrders(oId, opt);
    if (result == 1) {
      System.out.println("Order updated successfully");
    } else if (result == 2) {
      System.out.println("Order denied");
    } else {
      System.out.println("Inavlid input");
    }

    System.out.println("Please type the reason");
    option.nextLine();
    String reason = option.nextLine();
    OrdersFactory.updateCom(reason, oId);


    /*System.out.println("Select the reason:\n 1. The food is unavailable!\n 2. Entered quantity for food item not available!\n 3. Closed for the day!");
    int orderOption = option.nextInt();
    switch (orderOption) {
      case 1:
        System.out.println("The food is unavailable!");
        String com = "The food is unavailable!";
        OrdersFactory.updateCom(com, oId);
        break;
      case 2:
        System.out.println("Entered quantity for food item not available!");
        String com1 = "Food Quantity Limited!";
        OrdersFactory.updateCom(com1, oId);
        break;
      case 3:
        System.out.println("Closed for the day!");
        String com2 = "Closed for the day!";
        OrdersFactory.updateCom(com2, oId);
        break;
      default:
        System.out.println("Choose from 1 to 3");
    }*/

    Orders[] uOrder = OrdersFactory.showUpdatedOrder(oId);
    System.out.println("o_Id" + "\t" + "cust_Id" + "\t" + "ven_Id" + "\t" + "food_Id" + "\t" + "qty" + "\t" + "tot_Price" + "\t" + "tot_Cal" + "\t"
        + "O_Status" + "\t" + "est_Time" + "\t" + "O_Time" + "\t" + "O_Date" + "\t" + "O_reason");
    for (Orders u:uOrder) {
      System.out.println(u.getOId() + "\t" + u.getCustId() + "\t" + u.getVenId() + "\t" + u.getFoodId() + "\t"
            + u.getQty() + "\t" + u.getTotPrice() + "\t" + u.getTotCal() + "\t" + u.getOStatus() + "\t" + u.getEstTime() + "\t"
            + u.getOTime() + "\t" + u.getODate() + "\t" + u.getOReason());
    }
  }

  private double walletinfo(final Customer argCust) {
    int custId = argCust.getCustId();
    Customer c = CustomerFactory.getCWallet(custId);
    double walAmount = c.getCWallet();
    System.out.println("your wallet balance is " + c.getCWallet());
    return walAmount;
  }


  /**
   * main method is the basic entry point for the application.
   *
   * @param args used to get the user input.
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
