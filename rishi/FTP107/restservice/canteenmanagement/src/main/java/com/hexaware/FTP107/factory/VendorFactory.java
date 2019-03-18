package com.hexaware.FTP107.factory;


import java.util.List;
import java.util.Objects;

import com.hexaware.FTP107.model.Vendor;
import com.hexaware.FTP107.persistence.DbConnection;
import com.hexaware.FTP107.persistence.VendorDAO;

/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }

  /**
   * Call the data base connection.
   * @return .
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
  /**
   * Call the data base connection.
   * @return .
   * @param venUsername return username
   * @param venPassword return password
   */
  public static Vendor showVendorLogin(final String venUsername, final String venPassword) {
    Vendor v = dao().showLogin(venUsername, venPassword);
    if (v != null) {
      if (Objects.equals(v.getVenUsername(), venUsername)
          && Objects.equals(v.getVenPassword(), venPassword)) {
        return v;
      }
    } else {
      return null;
    }
    return null;
  }

     /**
   * Call the data base connection.
   * @param venId for wallet.
   * @return the array of customer object.
   */
  public static Vendor getVendorDetails(final int venId) {
    Vendor vr = dao().getVendor(venId);
    return vr;
  }
}

