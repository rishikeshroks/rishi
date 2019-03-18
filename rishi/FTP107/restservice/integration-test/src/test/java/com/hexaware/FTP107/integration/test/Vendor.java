package com.hexaware.FTP107.integration.test;
import java.util.Objects;
import com.hexaware.FTP107.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Vendor class used to display Vendor information.
 * @author hexware
 */
public class Vendor {
    /**
     * .
     */
      private int venId;
      private String venName;
      private String venUsername;
      private String venPassword;
      private String venEmail;
      private String venPhone;
      private String venAddress;
      /**
       * Default Constructor.
       */
      public Vendor() {
      }
    /**
     * @param argVenId to initialize.
     * @param argVenName to initialize.
     * @param argVenUsername to initialize.
     * @param argVenPassword to initialize.
     * @param argVenEmail to initialize.
     * @param argVenPhone to initialize.
     * @param argVenAddress to initialize.
     */
      public Vendor(final int argVenId, final String argVenName,
                    final String argVenUsername, final String argVenPassword,
                    final String argVenEmail, final String argVenPhone,
                    final String argVenAddress) {
        this.venId = argVenId;
        this.venName = argVenName;
        this.venUsername = argVenUsername;
        this.venPassword = argVenPassword;
        this.venEmail = argVenEmail;
        this.venPhone = argVenPhone;
        this.venAddress = argVenAddress;
      }
      @Override
        public final boolean equals(final Object obj) {
        if (obj == null) {
          return false;
        }
        if (getClass() != obj.getClass()) {
          return false;
        }
        Vendor vendor = (Vendor) obj;
        if (Objects.equals(venId, vendor.venId)
            && Objects.equals(venName, vendor.venName)
            && Objects.equals(venUsername, vendor.venUsername)
            && Objects.equals(venPassword, vendor.venPassword)
            && Objects.equals(venEmail, vendor.venEmail)
            && Objects.equals(venPhone, vendor.venPhone)
            && Objects.equals(venAddress, vendor.venAddress)) {
          return true;
        }
        return false;
      }
      @Override
        public final int hashCode() {
        return Objects.hash(venId, venName, venUsername, venPassword, venEmail, venPhone, venAddress);
      }
     /**
      * @param argVenName to initialize.
     */
      public Vendor(final String argVenName) {
        this.venName = argVenName;
      }
      /**
     * @return vendordetails
      */
      public final String toString() {
        return (this.venId + " " + this.venName + " " + this.venUsername + " " + this.venPassword + " "
          + this.venEmail + " " + this.venPhone + " " + this.venAddress);
      }
        /**
         * @return venid.
        */
      public final int getVenId() {
        return venId;
      }
      /**
      * @return venName
      */
      public final String getVenName() {
        return venName;
      }
      /* @param venusername
      */
      /**
      * @return venUsername
      */
      public final String getVenUsername() {
        return venUsername;
      }
      /* @param venpassword
      */
      /**
      * @return venPassword
      */
      public final String getVenPassword() {
        return venPassword;
      }
      /* @param venemail
      */
      /**
      * @return venEmail
      */
      public final String getVenEmail() {
        return venEmail;
      }
      /* @param venphone
      */
      /**
      * @return venPhone
      */
      public final String getVenPhone() {
        return venPhone;
      }
      /* @param venaddress
      */
      /**
      * @return venAddress
      */
      public final String getVenAddress() {
        return venAddress;
      }
        /**
         * @param argVenId gets the vendorid
         */
      public final void setVenId(final int argVenId) {
        this.venId = argVenId;
      }
        /**
         * @param argVenName gets the vendor name
         */
      public final void setVenName(final String argVenName) {
        this.venName = argVenName;
      }
        /**
         * @param argVenUsername gets the username
         */
      public final void setVenUsername(final String argVenUsername) {
        this.venUsername = argVenUsername;
      }
        /**
         * @param argVenPassword gets the password
         */
      public final void setVenPassword(final String argVenPassword) {
        this.venPassword = argVenPassword;
      }
        /**
         * @param argVenEmail gets the email
         */
      public final void setVenEmail(final String argVenEmail) {
        this.venEmail = argVenEmail;
      }
        /**
         * @param argVenPhone gets the phone
         */
      public final void setVenPhone(final String argVenPhone) {
        this.venPhone = argVenPhone;
      }
        /**
         * @param argVenAddress gets the address
         */
      public final void setVenAddress(final String argVenAddress) {
        this.venAddress = argVenAddress;
      }
    }
    