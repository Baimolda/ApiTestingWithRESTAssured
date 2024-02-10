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
    @Test
    public void PostWithJson(){

        String postJsonBody = "{\n" +
                "\t\"title\": \"foo\",\n" +
                "\t\"body\": \"bar\",\n" +
                "\t\"userId\": 1\n" +
                "}";

        given().body(postJsonBody).log().uri().
                when().post(JSONPLACEHOLDER_POST).
                then().log().body().statusCode(201);
    }
    @Test
    public void PostWithXml(){
        String postXmlBody = "\t\t\t<?xml version=\"1.0\"?>\n" +
                "\t\t\t<Company>\n" +
                "\t\t\t  <Employee>\n" +
                "\t\t\t\t  <FirstName>Tanmay</FirstName>\n" +
                "\t\t\t\t  <LastName>Patil</LastName>\n" +
                "\t\t\t\t  <ContactNo>1234567890</ContactNo>\n" +
                "\t\t\t\t  <Email>tanmaypatil@xyz.com</Email>\n" +
                "\t\t\t\t  <Address>\n" +
                "\t\t\t\t\t   <City>Bangalore</City>\n" +
                "\t\t\t\t\t   <State>Karnataka</State>\n" +
                "\t\t\t\t\t   <Zip>560212</Zip>\n" +
                "\t\t\t\t  </Address>\n" +
                "\t\t\t  </Employee>\n" +
                "\t\t\t</Company>\n" +
                "\t\t\t";
        given().body(postXmlBody).log().uri().
                when().post("").
                then().log().body().statusCode(200);
    }

}
