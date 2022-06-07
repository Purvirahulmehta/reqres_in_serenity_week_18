package in.reqres.reqresTest;

import in.reqres.info.ReqresSteps;
import in.reqres.testbase.TestBase;
import in.reqres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ReqresCURDTestWithSteps extends TestBase {
    static String name = "morpheus" + TestUtils.getRandomValue();
    static String job = "leader" + TestUtils.getRandomValue();
    static String email="eve.holt@reqres.in";
    static String password="cityslicka";
    static String userId;
    static String token;
    @Steps
    ReqresSteps reqresSteps;

    @Title("This will create a new user")
    @Test
    public void test01() {
        ValidatableResponse response=reqresSteps.createUser(name,job);
        response.log().all().statusCode(201);

    }
    @Title("Verify that new user is added")
    @Test
    public void test002() {
        HashMap<String,?> userMap= reqresSteps.getUserInfoByName(userId);
        Assert.assertThat(userMap,hasValue(name));
        System.out.println(userId);
    }

    @Title("This will login a user")
    @Test
    public void test003() {
        HashMap<String, ?> tokenMap = reqresSteps.loginUser(email, password);
        Assert.assertThat(tokenMap,hasKey("token"));
        System.out.println(tokenMap);
    }
    @Title("This will update a user by PUT")
    @Test
    public void test004() {
        name = name+"_updatedbyPut";
        ValidatableResponse response = reqresSteps.updateUserByPut(userId,name, job);
        response.log().all().statusCode(200);

    }

    @Title("This will update a user by Patch")
    @Test
    public void test005() {
        name = name+"_updatedbyPatch";
        ValidatableResponse response = reqresSteps.updateUserByPatch(userId,name, job);
        response.log().all().statusCode(200);
    }

    @Title("This will update a user by Patch")
    @Test
    public void test006() {
        ValidatableResponse response = reqresSteps.deleteUser(userId);
        response.log().all().statusCode(204);
    }


}




