package utils;

import java.io.FileReader;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;

import java.util.Map;

public class JsonFlattenerHelper {
    public static Map<String, Object> jsonFlattener(String json) {
        JSONParser parser = new JSONParser();
        Map<String, Object> flattenedJsonMap = null;
        try {

            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
            // log("\n=====Simple Flatten===== \n" + flattenedJson);
            flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());
            //  log("\n=====Flatten As Map=====\n" + flattenedJson);
            flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));
            String nestedJson = JsonUnflattener.unflatten(flattenedJson);
            //  System.out.println("\n=====Unflatten it back to original JSON===== \n" + nestedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flattenedJsonMap;
    }
    private static void log(String flattenedJson) {
        //System.out.println(flattenedJson);

    }
}
