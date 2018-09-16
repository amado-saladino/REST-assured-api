package request.put;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.data.Faker;
import com.utilities.Factory;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import request.models.User;

public class PUTRequest {
	
	final String url="http://localhost:3000/users/";
	User lastUser;
	Faker faker;
	int userCount;
	
	@BeforeClass
	public void setup(){
		lastUser=Factory.getLastUser();
		faker=new Faker();
		userCount=Factory.getUserCount();
	}
	
	
	@Test
	public void updateLastUser(){
		
		User updatedUser=Factory.createComplexUser();
		
		given()
		.body(updatedUser)
		.when()
		.contentType(ContentType.JSON)
		.put(url + "{id}",lastUser.getId())
		.then()
		.statusCode(200).and()
		.body("id",is(lastUser.getId()),
				"name",not(lastUser.getName()),
				"city",not(lastUser.getCity()),
				"age",not(lastUser.getAge()))
		.contentType(ContentType.JSON);
	}
	
	
	@Test(dependsOnMethods = "updateLastUser")
    public void testGetUsers() {

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get(url);

        response.then().body("size()",is( userCount ));
    }


}
