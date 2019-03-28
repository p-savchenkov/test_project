import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestAssuredTest {

  private static Response response;

@BeforeClass
public static void setUpUrl() throws Exception {

  System.out.println("setuping url");
  RestAssured.baseURI = "http://autoru-api-server-int.vrts-slb.test.vertis.yandex.net/";
  RestAssured.basePath = "1.0/";
}

@BeforeClass
public static void getUserResponse() throws Exception {

  
   RestAssuredTest.response =
          RestAssured.given().
                  header("X-Authorization", "Vertis swagger").
                  header("X-uid", "20621551").
                  log().all().
           when().
                  get("user").
           then().
                  contentType(ContentType.JSON).
                  extract().response();
  System.out.println("setuping params");



}

@Test
public void userPhoneTest(){
  JsonPath responseJson = response.jsonPath();
  String uId = responseJson.get("user.id");
  assertThat(uId).isEqualToIgnoringCase("20621551");


}

  //public static void main(String[] args){
   // RestAssuredTest resp = new RestAssuredTest("http://autoru-api-server-int.vrts-slb.test.vertis.yandex.net/1.0/user?token=swagger&userID=20621551");

  }


