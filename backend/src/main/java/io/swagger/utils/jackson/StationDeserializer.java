package io.swagger.utils.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.model.Station;

import java.io.IOException;

public class StationDeserializer extends JsonDeserializer<Station> {
    @Override
    public Station deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String stationName = node.asText(); // Assuming the JSON contains the station name as a simple string
        Station station = new Station();
        station.setStationName(stationName);
        return station;
    }
}

