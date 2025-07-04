package task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class task3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode valuesRoot = mapper.readTree(new File(args[0]));
        Map<Integer, String> valuesMap = new HashMap<>();
        for (JsonNode val : valuesRoot.get("values")) {
            valuesMap.put(val.get("id").asInt(), val.get("value").asText());
        }

        ObjectNode testsRoot = (ObjectNode) mapper.readTree(new File(args[1]));

        fillValues(testsRoot.get("tests"), valuesMap);

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[2]), testsRoot);
    }

    private static void fillValues(JsonNode tests, Map<Integer, String> valuesMap) {
        for (JsonNode testNode : tests) {
            ObjectNode test = (ObjectNode) testNode;
            int id = test.get("id").asInt();
            if (valuesMap.containsKey(id)) {
                test.put("value", valuesMap.get(id));
            }

            if (test.has("values")) {
                fillValues(test.get("values"), valuesMap);
            }
        }
    }
}
