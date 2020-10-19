package de.vese.vese.util;

import org.json.JSONObject;

public class JSONBuilder {


    public static JSONObject generateJsonObjectPrimitive(String key, Object value) {
        JSONObject object = new JSONObject();
        object.append(key,value);
        return object;
    }

}
