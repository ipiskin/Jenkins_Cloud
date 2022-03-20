package jenkins;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class JenkinsTests {

    @Test
    public void apiTest(){
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
//       Set the base url and path params
        spec.pathParams("first", "booking", "second", 3);

//        Send the GET request and get a respond

        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        System.out.println(actualData);

        Map<String, Object> bookingDates = (Map)actualData.get("bookingdates");

        Assert.assertEquals("Mary", actualData.get("firstname"));
        Assert.assertEquals("Ericsson", actualData.get("lastname"));
        Assert.assertEquals(512, actualData.get("totalprice"));
        Assert.assertEquals(false, actualData.get("depositpaid"));
        Assert.assertEquals("2019-05-17", bookingDates.get("checkin"));
        Assert.assertEquals("2020-05-12", bookingDates.get("checkout"));







    }


}
