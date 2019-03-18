package com.hexaware.FTP107.integration.test;
import com.hexaware.FTP107.integration.test.Vendor;
import java.util.Arrays;
import java.util.Date;
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

public class VendorRestTest {
	@Test
	public void testVendorList() throws AssertionError, URISyntaxException {
    Vendor[] res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/vendor/all"))
	.getBody().as(Vendor[].class);
	
	assertNotNull(res);
	assertEquals(500, res[0].getVenId());
	assertEquals("Kushal", res[0].getVenName());
    assertEquals("kushal1", res[0].getVenUsername());
    assertEquals("kushal1", res[0].getVenPassword());
	assertEquals("abc@123", res[0].getVenEmail());
    assertEquals("1765690080", res[0].getVenPhone());
    assertEquals("4/9,thanigai", res[0].getVenAddress());
    }
    
    @Test
	public void testVendorLogin() throws AssertionError, URISyntaxException {
	Vendor res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/vendor/vlogin?venUsername=kushal1&venPassword=kushal1"))
	.getBody().as(Vendor.class);
	
	assertNotNull(res);
	assertEquals(500, res.getVenId());
	assertEquals("Kushal", res.getVenName());
    assertEquals("kushal1", res.getVenUsername());
    assertEquals("kushal1", res.getVenPassword());
	assertEquals("abc@123", res.getVenEmail());
    assertEquals("1765690080", res.getVenPhone());
    assertEquals("4/9,thanigai", res.getVenAddress());
    }
    
    @Test
	public void testVendorById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/vendor/1045")).then().assertThat().statusCode(404);
	}
	
}