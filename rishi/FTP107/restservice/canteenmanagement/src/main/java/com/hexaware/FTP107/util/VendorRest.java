package com.hexaware.FTP107.util;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP107.model.Vendor;
import com.hexaware.FTP107.factory.VendorFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns vendor details.
   * @return the vendor details
   */
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] listVendor() {
    Vendor[] vendor = VendorFactory.showVendor();
    return vendor;
  }
    /**
   * Returns Menu details.
   * @param venUsername login.
   * @param venPassword login.
   * @return the vendor details
   */

  @GET
  @Path("/vlogin")
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor vendorLogInRest(@QueryParam("venUsername") final String venUsername, @QueryParam("venPassword") final String venPassword) {
    Vendor v1 = VendorFactory.showVendorLogin(venUsername, venPassword);
    if (v1 == null) {
      throw new NotFoundException("login failed" + "enter valid details" + venUsername);
    }
    return v1;
  }

  /**
   * Returns Vendor details.
   * @param venId VendorID
   * @return wallet details
   */
  @GET
  @Path("/vendordetails/{venId}")
  @Produces(MediaType.APPLICATION_JSON)
  public static Vendor getVendorDetails(@PathParam("venId") final int venId) {
    Vendor ct = VendorFactory.getVendorDetails(venId);
    if (ct == null) {
      throw new NotFoundException(venId + "not found");
    }
    return ct;
  }
}

