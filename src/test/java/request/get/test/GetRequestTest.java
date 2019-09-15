package request.get.test;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetRequestTest {

	private final static Logger logger = LogManager.getLogger(GetRequestTest.class);
	private SoftAssert softAssert = new SoftAssert();
	  
	final String key="b6907d289e10d714a6e88b30761fae22";
	final String url="http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	Response response;
	int code;
	
	@Test
	public void testResponseCode() {
		logger.error("Test status code");
		logger.info("log some info");

		response= get(url);
		code=response.getStatusCode();
		long time=response.time();
				//response.then().extract().time();
		
		System.out.println("Status Code is: " + code);
		System.out.println("Response Time is: " + time);
		
		softAssert.assertEquals(code, 200);
		softAssert.assertAll();
	}

	@Test
	public void testItReturnsTheRightValuesForOneCity() {
		when().get(url)
		.then().body("coord.size()", is(2))
		.and().body("size()", is(12));		
	}
	
	@Test
	public void testResponseCodeWithBDD() {
		when().get(url)
		.then().statusCode(200).body("sys.country", equalTo("GB") )
		.and().body("name", equalTo("London"));
	}
	
	@Test
	public void testResponseWithParams() {
		given().param("q", "London")
		.param("appid", key)
		.when().get("http://samples.openweathermap.org/data/2.5/weather")
		.then().statusCode(200)
		.and().body("name", equalTo("London"),"sys.country", equalTo("GB"));		
	}
	
	@Test
	public void testResponseBody() {
		response= get(url);
		String body= response.asString();
		System.out.println(body);		
	}
		

}
