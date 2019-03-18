package com.hexaware.FTP107.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.FTP107.model.Orders;
import com.hexaware.FTP107.model.OrdersStatus;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu
       */
    return new Orders(rs.getInt("O_ID"),
    rs.getInt("C_ID"),
    rs.getInt("V_ID"),
    rs.getInt("FOOD_ID"),
    rs.getInt("QTY"),
    rs.getFloat("TOT_PRICE"),
    rs.getFloat("TOT_CAL"),
    OrdersStatus.valueOf(rs.getString("O_STATUS")),
    rs.getTime("EST_TIME"),
    rs.getTime("O_TIME"),
    rs.getDate("O_DATE"),
    rs.getString("O_REASON"));
  }
}
