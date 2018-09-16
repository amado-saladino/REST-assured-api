package com.utilities;

import com.data.Faker;
import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import request.models.Info;
import request.models.User;
import static io.restassured.RestAssured.given;

public class Factory {

    static Faker faker=new Faker();
    static Gson gson = new Gson();
    final static String url="http://localhost:3000/users/";

    public static User getLastUser() {

        User[] users= given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then().extract().body().as(User[].class, ObjectMapperType.GSON);

        return users[users.length-1];
    }


    public static int getUserCount() {

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get(url);
          
        
        return gson.fromJson(response.asString(),
        		User[].class).length;
    }
    

    public static Response getAllUsersResponse(){

        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(url);
    }

    
    public static User createComplexUser() {
        User user=new User();
        Info info=new Info();

        info.setEmail(faker.getEmail());
        info.setPhone(faker.getPhone());
        info.setAddress(faker.getAddress());

        user.setId(faker.getRandomNumber());
        user.setName(faker.getFemaleFirstName());
        user.setAge(faker.getAge());
        user.setCity(faker.getCity());
        user.setInfo( info );

        return user;
    }
    

}
