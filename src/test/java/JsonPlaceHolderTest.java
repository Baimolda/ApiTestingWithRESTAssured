import config.TestConfig;
import org.junit.Test;

import static constants.Constants.Actions.JSONPLACEHOLDER_GET;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {
    @Test
    public void GET(){
        given().queryParam("postId", 1).log().uri().
                when().get(JSONPLACEHOLDER_GET).
                then().log().body().statusCode(200);
    }

}
