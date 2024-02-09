import org.junit.Test;

import static io.restassured.RestAssured.*;
public class FirstTest {
    @Test
    public void myFristTest(){
        given().
        when().get("https://swapi.dev/api/people/1").
        then().statusCode(200);
    }
}
