package com.hexaware.FTP107.persistence;

import java.util.List;

import com.hexaware.FTP107.model.Customer;
import com.hexaware.FTP107.model.Menu;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
    /**
     * @return the all the cust record
     *
     */
  @SqlQuery("Select * from Customer")
    @Mapper(CustomerMapper.class)
    List<Customer> show();
    /**
     * @return the all the Mrnu with food.
     * @param foodId arg.
     */
  @SqlQuery("Select * from Menu Where FOOD_ID = :foodId")
    @Mapper(MenuMapper.class)
  List<Menu> getFoodId(@Bind("foodId") int foodId);
    /**
     * @param username  arg.
     * @param password arg.
     * @return customer details.
     */

  @SqlQuery("Select * from Customer where C_USERNAME = :username and C_PASSWORD = :password")
    @Mapper(CustomerMapper.class)
  Customer showCLogin(@Bind ("username") String username, @Bind ("password") String password);

     /**
     * @return the all the cust record
     * @param custId arg.
  */
  @SqlQuery("Select * from Customer Where C_ID = :custId")
    @Mapper(CustomerMapper.class)
  Customer getWalletBal(@Bind ("custId") int custId);

     /**
     * @return the all the cust record
     * @param custId for getting walletinfo.
     * @param walBalance for getting balance.
  */
  @SqlUpdate("Update Customer Set C_WALLET=:walBalance where C_ID=:custId")
    int setDeductWallet(@Bind ("walBalance") double walBalance, @Bind ("custId") int custId);
     /**
     * @return the all the cust record
     * @param custId for getting walletinfo.
     * @param walRebalance for getting new balance.
  */

  @SqlUpdate("Update Customer Set C_WALLET=:walRebalance where C_ID=:custId")
    int setRevertWallet(@Bind ("walRebalance") double  walRebalance, @Bind ("custId") int custId);


}



