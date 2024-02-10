package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Servers.REQUESTBIN_URL;

public class TestConfig {


    protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/xml")
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
        RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addCookie("testCookieJSON")
                .build();
        RestAssured.requestSpecification = requestSpecificationJson;


    }
}
