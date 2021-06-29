package apiUtils;

import common.constants;
import io.restassured.parsing.Parser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JsonFlattenerHelper;
import utils.YamlReader;

public class Rest_API {

    public void get_api() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = constants.apiUrl;
        try {

            constants.response = RestAssured.given().log().all().headers(constants.headerMap).queryParams(constants.queryMap).get(constants.endpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + constants.response.asString());
    }

    public void delete_api() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = constants.apiUrl;
        try {

            constants.response = RestAssured.given().log().all().headers(constants.headerMap).queryParams(constants.queryMap).delete(constants.endpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + constants.response.asString());
    }

    public void post_api() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = constants.apiUrl;
        try {

            constants.response = RestAssured.given().log().all().headers(constants.headerMap).queryParams(constants.queryMap).body(constants.request_body).post(constants.endpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + constants.response.asString());
    }
    public void patch_api() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = constants.apiUrl;
        try {

            constants.response = RestAssured.given().log().all().headers(constants.headerMap).queryParams(constants.queryMap).body(constants.request_body).patch(constants.endpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + constants.response.asString());
    }
}
