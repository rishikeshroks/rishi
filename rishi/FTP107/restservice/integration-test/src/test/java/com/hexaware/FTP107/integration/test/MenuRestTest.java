package com.hexaware.FTP107.integration.test;
import com.hexaware.FTP107.integration.test.Menu;
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

public class MenuRestTest {

	@Test
	public void testMenuList() throws AssertionError, URISyntaxException {
	Menu[] res = 
	given()
	.when()
	.accept(ContentType.JSON)
	.get(CommonUtil.getURI("/api/menu"))
	.getBody().as(Menu[].class);
	
	assertNotNull(res);
	assertEquals(1000, res[1].getFoodId());
	assertEquals("Idly Sambar", res[1].getFoodName());
	assertEquals(500, res[1].getVId());
	assertEquals(20.0, res[1].getPrice(),0.1);
	assertEquals("South Indian", res[1].getFoodCat());
	assertEquals("2 idly ", res[1].getFoodDesc());
	assertEquals(45.0, res[1].getFoodCal(),0.1);
	}

	@Test
	public void testMenuById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/menu/1010")).then().assertThat().statusCode(404);
	}
	
}
