package in.reqres.info;

import in.reqres.constants.EndPoints;
import in.reqres.model.Pojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ReqresSteps {
    @Step("Creating user with name:{0},job:{1}")
    public ValidatableResponse createUser(String name,String job){
        Pojo pojo=new Pojo();
        pojo.setName(name);
        pojo.setJob(job);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(pojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then();
    }

    @Step("Getting the User information with Id: {0}")
    public HashMap<String, ?> getUserInfoByName(String userId) {


        HashMap<String, ?> userMap = SerenityRest.given().log().all()
                .when()
                .pathParam("userID", userId)
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then()
                .statusCode(200)
                .extract().path("");

        return userMap;
    }
    @Step("Login User with email : {0}, password: {1}")
    public  HashMap<String, ?> loginUser(String email,
                                               String password) {
        Pojo pojo = new Pojo();
        pojo.setEmail(email);
        pojo.setPassword(password);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(pojo)
                .when()
                .post(EndPoints.UPDATE_USER)

                .then()
                .statusCode(200)
                .extract()
                .path("");
    }

    @Step("Update User name : {0}, Job: {1}")
    public ValidatableResponse updateUserByPatch(String userId,
                                                 String name,
                                                 String job) {
        Pojo pojo = new Pojo();
       pojo.setName(name);
       pojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("userID", userId)
                .body(pojo)
                .when()
                .patch(EndPoints.UPDATE_USER)
                .then();
    }



    @Step("Update User name : {0}, Job: {1}")
    public ValidatableResponse updateUserByPut(String userId,
                                               String name,
                                               String job) {
        Pojo pojo = new Pojo();
        pojo.setName(name);
      pojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("userID", userId)
                .body(pojo)
                .when()
                .put(EndPoints.UPDATE_USER)
                .then();
    }

    @Step("Deleting user information with userId: {0}")
    public ValidatableResponse deleteUser(String userId){
        return SerenityRest.given().log().all()
                .when()
                .delete(EndPoints.DELETE_user_BY_ID)
                .then();
    }
    }



