package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Servers.REQUESTBIN_URL;
import static constants.Constants.Servers.SWAPI_URL;

public class TestConfig {

    protected RequestSpecification requestSpecificationForSwapiTests = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .build();


    protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/xml")
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();
    protected RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .addCookie("testCookieJSON")
            .build();

    protected ResponseSpecification responseSpecificationForGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();


    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;



    }
}
