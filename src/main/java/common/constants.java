package common;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class constants {
    public static final String apiUrl = "http://localhost:8080";

    public static Response response = null;
    public static String endpoint = null;
    public static String request_body = null;

    public static Map<String, Object> APIresponse;
    public static Map<String,Object> headerMap = new HashMap<String,Object>();
    public static Map<String,Object> queryMap = new HashMap<String,Object>();

    public static String userId;
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String dayOfBirth;
}
