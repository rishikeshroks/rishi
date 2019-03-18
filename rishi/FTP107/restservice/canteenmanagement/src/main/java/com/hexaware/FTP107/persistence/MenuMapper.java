package com.hexaware.FTP107.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP107.model.Menu;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class MenuMapper implements ResultSetMapper<Menu> {
/**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
*/
  public final Menu map(final int idx, final ResultSet rs, final StatementContext ctx)
  throws SQLException {
      /**
       * @return Menu
       */
    return new Menu(rs.getInt("FOOD_ID"), rs.getString("FOOD_NAME"),
    rs.getInt("V_ID"), rs.getDouble("PRICE"), rs.getString("FOOD_CAT"), rs.getString("FOOD_DESC"),
    rs.getDouble("FOOD_CAL"));
  }
}
