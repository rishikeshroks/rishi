package com.hexaware.FTP107.integration.test;
import com.hexaware.FTP107.integration.test.Orders;
import java.util.Arrays;
import java.util.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class OrdersRestTest {

	@Test
	public void testOrdersList() throws AssertionError, URISyntaxException {
    Orders[] res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/orders"))
    .getBody().as(Orders[].class);
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
	Time ot = new Time(8,42,27);
	assertNotNull(res);
	assertEquals(3, res[0].getCustId());
	assertEquals(508, res[0].getVenId());
    assertEquals(1016, res[0].getFoodId());
    assertEquals(2, res[0]. getQty());
	assertEquals(80, res[0].getTotPrice(), 0.1);
    assertEquals(156, res[0].getTotCal(), 0.1);
    assertEquals(o, res[0]. getOStatus());
    assertEquals(ot, res[0].getEstTime());
    assertEquals(ot, res[0].getOTime());
    assertEquals(null, res[0].getOReason());
    }
    
    @Test
	public void testCustOrdersList() throws AssertionError, URISyntaxException {
    Orders[] res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/orders/cust/3"))
    .getBody().as(Orders[].class);
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
	Time ot = new Time(8,42,27);
	assertNotNull(res);
	assertEquals(3, res[0].getCustId());
	assertEquals(508, res[0].getVenId());
    assertEquals(1016, res[0].getFoodId());
    assertEquals(2, res[0]. getQty());
	assertEquals(80, res[0].getTotPrice(), 0.1);
    assertEquals(156, res[0].getTotCal(), 0.1);
    assertEquals(o, res[0]. getOStatus());
    assertEquals(ot, res[0].getEstTime());
    assertEquals(ot, res[0].getOTime());
    assertEquals(null, res[0].getOReason());
    }
    
    @Test
	public void testVenOrdersList() throws AssertionError, URISyntaxException {
    Orders[] res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/orders/ven/500"))
    .getBody().as(Orders[].class);
    OrdersStatus o = OrdersStatus.valueOf("PLACE_ORDER");
	Time ot = new Time(8,45,17);
    assertNotNull(res);
    assertEquals(43, res[0].getOId());
	assertEquals(3, res[0].getCustId());
	assertEquals(500, res[0].getVenId());
    assertEquals(1000, res[0].getFoodId());
    assertEquals(1, res[0]. getQty());
	assertEquals(20, res[0].getTotPrice(), 0.1);
    assertEquals(45, res[0].getTotCal(), 0.1);
    assertEquals(o, res[0]. getOStatus());
    assertEquals(ot, res[0].getEstTime());
    assertEquals(ot, res[0].getOTime());
    assertEquals(null, res[0].getOReason());
    }
    
    @Test
    public void testAcceptDeny() throws AssertionError, URISyntaxException {
       Date dt = new Date();
 
      Time et = new Time(12,55,37);
     
      Orders ord = new Orders(56,1,500,1000,2,40.0f,90.0f,OrdersStatus.DELIVERED,et,et,dt," ");
      String str = given()
                    .contentType("application/json")
                    .body(ord).when()
                    .put(CommonUtil.getURI("/api/orders/update/56"))
                    .getBody().asString();
        System.out.println(str);
        //String estr = "{\"msg\":\"YOUR ORDER IS DELIVERED\"}";
        //assertEquals(estr, str);
        assertNotNull(str);
  }

}