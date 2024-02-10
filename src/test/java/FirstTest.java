import config.TestConfig;
import org.junit.Test;

import static constants.Constants.Actions.JSONPLACEHOLDER_PUT;
import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;
public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest(){
        given().log().uri().
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200);
    }
}
