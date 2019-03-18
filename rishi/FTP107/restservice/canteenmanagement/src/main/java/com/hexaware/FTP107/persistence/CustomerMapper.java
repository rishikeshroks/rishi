package com.hexaware.FTP107.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP107.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Customer
       */
    return new Customer(rs.getInt("C_Id"), rs.getString("C_Name"), rs.getString("C_Username"), rs.getString("C_Password"),
    rs.getFloat("C_Wallet"), rs.getString("C_Email"), rs.getString("C_Phone"), rs.getString("C_Address"));
  }
}
