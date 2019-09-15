package request.patch.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.utilities.Factory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import request.models.User;
import com.data.Faker;

public class TestPatchRequest {

	final String url="http://localhost:3000/users/";
	User lastUser;
	Faker faker;
	
	@BeforeClass
	private void setup(){
		lastUser=Factory.getLastUser();
		faker = new Faker();
	}
	
	@Test
	public void updateUserbyName(){
		given()
		.body("{\"name\":\"" + faker.getFemaleFirstName() + "\"}")
		.when()
		.contentType(ContentType.JSON)
		.patch(url + "{id}", lastUser.getId())
		.then()
		.statusCode(200).and()
		.body("name",not(lastUser.getName()) )
		.contentType(ContentType.JSON);
	}

}
