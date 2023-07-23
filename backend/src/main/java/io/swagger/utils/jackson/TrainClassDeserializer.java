package io.swagger.utils.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.swagger.model.TrainClass;
import io.swagger.model.TrainClassType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainClassDeserializer extends JsonDeserializer<List<TrainClass>> {
    @Override
    public List<TrainClass> deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = parser.getCodec().readTree(parser);
        List<TrainClass> trainClasses = new ArrayList<>();

        if (node.isArray()) {
            for (JsonNode classNode : node) {
                TrainClass trainClass = new TrainClass();
                trainClass.setCapacity(classNode.get("capacity").asInt());
                trainClass.setBasePrice(classNode.get("base_price").decimalValue());

                String classTypeName = classNode.get("class_type").asText();
                TrainClassType classType = new TrainClassType();
                classType.setClassTypeName(classTypeName);
                trainClass.setClassType(classType);

                trainClass.setTrainId(null); // Assuming you will set the trainId later during the save process

                trainClasses.add(trainClass);
            }
        }

        return trainClasses;
    }
}
