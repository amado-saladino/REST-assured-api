package request.post.test;

import com.utilities.Factory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import request.models.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostComplexTest {

    SoftAssert softAssert = new SoftAssert();
    final String url="http://localhost:3000/users";
    int userCount;

    @Test(priority = 1)
    public void postComplexUser(){
        User user= Factory.createComplexUser();
        userCount=Factory.getUserCount();

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .body(user)
                        .when()
                        .post(url);

        response
                .then()
                .statusCode(201).and()
                .body("size()",is( 5  ))
                .and()
                .contentType(ContentType.JSON);

        User ActualUser=response.as(User.class);

        softAssert.assertEquals(user,ActualUser);
        softAssert.assertAll();
    }

    @Test(priority = 2,dependsOnMethods = "postComplexUser")
    public void testGetUsers() {

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get(url);

        response.then().body("size()",is( userCount+1 ));
    }

    @Test(priority = 3)
    public void testPostUserWithInfos(){

        userCount=Factory.getUserCount();
        User user= Factory.createComplexUser();

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(url)
        .then()
        .statusCode(201).and()
        .and()
        .contentType(ContentType.JSON);
    }

}
