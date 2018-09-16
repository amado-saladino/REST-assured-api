package request.delete.test;

import com.utilities.Factory;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import request.models.User;

import static io.restassured.RestAssured.given;

public class TestDelete {

    private SoftAssert softAssert = new SoftAssert();
    final String url="http://localhost:3000/users/";
    User lastUserToDelete;
    int userCount;

    @BeforeClass
    public void setup(){
        lastUserToDelete= Factory.getLastUser();
        userCount=Factory.getUserCount();
    }

    @Test
    public void testDeleteUser(){

        given()
                .when()
                .delete(url + lastUserToDelete.getId())
                .then()
                .statusCode(200);

        String responseBody= Factory.getAllUsersResponse().asString();

        softAssert.assertFalse(responseBody.contains(lastUserToDelete.getId()));
        softAssert.assertAll();
    }
    
    @Test(dependsOnMethods = "testDeleteUser")
    public void testGetUsers() {

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get(url);

        response.then().body("size()",is( userCount-1 ));
    }


}
