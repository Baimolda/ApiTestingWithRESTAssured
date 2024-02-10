import config.TestConfig;
import org.junit.Test;

import static constants.Constants.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {
    @Test
    public void GET(){
        given().queryParam("postId", 1).log().uri().
                when().get(JSONPLACEHOLDER_GET).
                then().log().body().statusCode(200);
    }
    @Test
    public void Put(){

        String putBodyJson = "{\n" +
                "\t\"id\": 1,\n" +
                "\t\"title\": \"foo\",\n" +
                "\t\"body\": \"bar\",\n" +
                "\t\"userId\": 1\n" +
                "}";
        given().body(putBodyJson).log().uri().
                when().put(JSONPLACEHOLDER_PUT).
                then().log().body().statusCode(200);
    }
    @Test
    public void Delete(){
        given().log().uri().
                when().delete(JSONPLACEHOLDER_DELETE).
                then().log().body().statusCode(200);
    }

}
