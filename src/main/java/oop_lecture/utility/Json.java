package oop_lecture.utility;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    private static ObjectMapper om = getDefaultObjectMapper();

    // TODO : make a pool here
    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    public static JsonNode parse(String string) throws IOException {
        return om.readTree(string);
    }

    public static <A> A fromJson(JsonNode node, Class<A> classA) throws JsonProcessingException {
        return om.treeToValue(node, classA);
    }

    public static JsonNode toJson(Object o) {
        return om.valueToTree(o);
    }

}
