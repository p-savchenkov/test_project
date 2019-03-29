import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import  static org.assertj.core.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class junitTestWithParams {

  @BeforeClass
  public static void setUpUrl(){

    RestAssured.baseURI = "http://autoru-api-server-int.vrts-slb.test.vertis.yandex.net/";
    RestAssured.basePath = "1.0/";

  }

  @Parameters(name = "{index}: user {0} - response {1}")
  public static Iterable<Object[]> data(){
    return Arrays.asList(new Object[][]{
            {"20621551", 200},
            {"123", 404}
    });
  }

  private String uId;
  private int responseCode;

  public junitTestWithParams(String uId, int responseCode){
    this.uId = uId;
    this.responseCode = responseCode;

  }

  @Test
  public void userTest(){
    Response resp =
            RestAssured.given().
                    header("X-Authorization", "Vertis swagger").
                    header("X-uid", this.uId).
                    log().all().
            when().
                    get("user").
            then().
                    contentType(ContentType.JSON).
                    extract().response();

    assertThat(resp.getStatusCode()).isEqualTo(this.responseCode);


  }
}
