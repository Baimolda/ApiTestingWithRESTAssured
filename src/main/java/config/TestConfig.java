package config;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;

public class TestConfig {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}
