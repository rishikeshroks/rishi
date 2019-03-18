package com.hexaware.FTP107.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP107.model.Vendor;


/**
 * vendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from Vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
    /**
     *@return vid arg.
     *@param usernm arg.
     *@param passwd arg.
     */

  @SqlQuery("Select * from Vendor where V_USERNAME = :usernm and V_PASSWORD = :passwd")
    @Mapper(VendorMapper.class)
    Vendor showLogin(@Bind ("usernm") String usernm, @Bind ("passwd") String passwd);

 /**
     * @return the all the cust record
     * @param venId arg.
  */
  @SqlQuery("Select * from Vendor Where V_ID = :venId")
    @Mapper(VendorMapper.class)
    Vendor getVendor(@Bind ("venId") int venId);
}
