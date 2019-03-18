package com.hexaware.FTP107.integration.test;
import com.hexaware.FTP107.integration.test.Customer;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.sql.Time;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class CustomerRestTest {

	@Test
	public void testCustomerList() throws AssertionError, URISyntaxException {
	Customer[] res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/customer/custinfo"))
	.getBody().as(Customer[].class);
	
	assertNotNull(res);
	assertEquals(1, res[0].getCustId());
	assertEquals("RISHIKESH", res[0].getCustName());
	assertEquals("RISHI", res[0].getCUserName());
	assertEquals("ABC@123", res[0].getCPassword());
	//assertEquals(1050, res[0].getCWallet(),0.2);
	assertEquals("RISHI@GMAIL.COM", res[0].getCEmail());
    assertEquals("9654123649", res[0].getCPhone());
    assertEquals("NO1 NAVALUR CHENNAI-78", res[0].getCAddress());
    }
    @Test
	public void testCustomerLogin() throws AssertionError, URISyntaxException {
	Customer res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/customer/clogin?cUserName=RISHI&cPassword=ABC@123"))
	.getBody().as(Customer.class);
	
	assertNotNull(res);
	assertEquals(1, res.getCustId());
	assertEquals("RISHIKESH", res.getCustName());
	assertEquals("RISHI", res.getCUserName());
	assertEquals("ABC@123", res.getCPassword());
	//assertEquals(1050, res.getCWallet(),0.2);
	assertEquals("RISHI@GMAIL.COM", res.getCEmail());
    assertEquals("9654123649", res.getCPhone());
    assertEquals("NO1 NAVALUR CHENNAI-78", res.getCAddress());
    }
    
    @Test
	public void testCustomerWallet() throws AssertionError, URISyntaxException {
	Customer res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/customer/showwallet/1"))
	.getBody().as(Customer.class);
	
	assertNotNull(res);
	assertEquals(1, res.getCustId());
	assertEquals("RISHIKESH", res.getCustName());
	assertEquals("RISHI", res.getCUserName());
	assertEquals("ABC@123", res.getCPassword());
	//assertEquals(1050, res.getCWallet(),0.2);
	assertEquals("RISHI@GMAIL.COM", res.getCEmail());
    assertEquals("9654123649", res.getCPhone());
    assertEquals("NO1 NAVALUR CHENNAI-78", res.getCAddress());
	}
	
	
	@Test
    public void testPlaceOrder() throws AssertionError, URISyntaxException {
       Date dt = new Date();
 
      Time et = new Time(12,33,36);
     
      Orders ord = new Orders(67,2,500,1000,1,20.0f,45.0f,OrdersStatus.PLACE_ORDER, et, et, dt, " ");
      String str = given()
                    .contentType("application/json")
                    .body(ord).when()
                    .post(CommonUtil.getURI("/api/customer/placeorder/1"))
                    .getBody().asString();
        System.out.println(str);
        //String estr = "{\"msg\":\"Order is placed\"}";
        assertNotNull(str);
  }
	
	

    
    @Test
	public void testCustomerById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/customer/1045")).then().assertThat().statusCode(404);
	}
	



}

