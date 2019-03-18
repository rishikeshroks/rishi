package com.hexaware.FTP107.integration.test;
import java.util.Objects;
import com.hexaware.FTP107.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class  Customer {
    /**
     * foodId to store foodId.
     */
      private int custId;
      private String custName;
      private String cUserName;
      private String cPassword;
      private float cWallet;
      private String cEmail;
      private String cPhone;
      private String cAddress;
          /**
           * Default Constructor.
           */
      public Customer() {
      }
    /**
      * @param argCustId customerid
      * @param argCustName custer name
      * @param argCUserName username
      * @param argCPassword password
      * @param argCWallet wallet
      * @param argCEmail emailid
      * @param argCPhone phoneno
      * @param argCAddress address
    
      */
      public Customer(final int argCustId, final String argCustName,
          final String argCUserName, final String argCPassword,
          final float argCWallet, final String argCEmail, final String argCPhone,
          final String argCAddress) {
        this.custId = argCustId;
        this.custName = argCustName;
        this.cUserName = argCUserName;
        this.cPassword = argCPassword;
        this.cWallet = argCWallet;
        this.cEmail = argCEmail;
        this.cPhone = argCPhone;
        this.cAddress = argCAddress;
      }
      @Override
        public final boolean equals(final Object obj) {
        if (obj == null) {
          return false;
        }
        if (getClass() != obj.getClass()) {
          return false;
        }
        Customer customer = (Customer) obj;
        if (Objects.equals(custId, customer.custId)
            && Objects.equals(custName, customer.custName)
            && Objects.equals(cUserName, customer.cUserName)
            && Objects.equals(cPassword, customer.cPassword)
            && Objects.equals(cWallet, customer.cWallet)
            && Objects.equals(cEmail, customer.cEmail)
            && Objects.equals(cPhone, customer.cPhone)
            && Objects.equals(cAddress, customer.cAddress)) {
          return true;
        }
        return false;
      }
      @Override
        public final int hashCode() {
        return Objects.hash(custId, custName, cUserName, cPassword, cWallet,
          cEmail, cPhone, cAddress);
      }
      @Override
      public final String toString() {
        return this.getCustId() + this.getCustName() + this.getCUserName()
          + this.getCPassword() + this.getCWallet() + this.getCEmail()
          + this.getCPhone() + this.getCAddress();
      }
      /**
        * @return this custid.
        */
      public final int getCustId() {
        return  this.custId;
      }
        /**
        * @return this cust name.
        */
    
      public final String getCustName() {
        return  this.custName;
      }
      /**
        * @return this username.
        */
      public final String getCUserName() {
        return this.cUserName;
      }
      /**
        * @return this password.
        */
      public final String getCPassword() {
        return this.cPassword;
      }
      /**
        * @return this wallet details.
        */
      public final float getCWallet() {
        return this.cWallet;
      }
      /**
        * @return this cust email id
        */
      public final String getCEmail() {
        return this.cEmail;
      }
       /**
        * @return this cust phone no.
        */
      public final String getCPhone() {
        return this.cPhone;
      }
         /**
          * @return this cust address.
          */
      public final String getCAddress() {
        return this.cAddress;
      }
      /**
         * @param argCustId gets the custid
         */
      public final void setCustId(final int argCustId) {
        this.custId = argCustId;
      }
      /**
         * @param argCustName gets the custname
         */
      public final void setCustName(final String argCustName) {
        this.custName = argCustName;
      }
      /**
         * @param argCUserName gets the custusername
         */
      public  final void setCUserName(final String argCUserName) {
        this.cUserName = argCUserName;
      }
      /**
         * @param argCPassword gets the cust password
         */
      public  final  void setCPassword(final String argCPassword) {
        this.cPassword = argCPassword;
      }
      /**
         * @param argCWallet gets the cust wallet
         */
      public final  void setCWallet(final float argCWallet) {
        this.cWallet = argCWallet;
      }
      /**
         * @param argCEmail gets the cust emailid
         */
      public  final  void setCEmail(final String argCEmail) {
        this.cEmail = argCEmail;
      }
      /**
         * @param argCPhone gets the cust phone
         */
      public  final  void setCPhone(final String argCPhone) {
        this.cPhone = argCPhone;
      }
        /**
           * @param argCAddress gets the cust address
           */
      public final void setCAddress(final String argCAddress) {
        this.cAddress = argCAddress;
      }
    }
    