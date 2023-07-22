package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.StationApi;
import io.swagger.api.ApiResponseMessage;
import io.swagger.model.Station;
import io.swagger.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@Controller
public class StationApiController implements StationApi {

    private static final Logger log = LoggerFactory.getLogger(StationApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final StationService stationService;

    @Autowired
    public StationApiController(ObjectMapper objectMapper, HttpServletRequest request,
            StationService stationService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.stationService = stationService;
    }

    public ResponseEntity<ApiResponseMessage> addStation(
            @ApiParam(value = "Station object", required = true) @Valid @RequestBody Station station) {
        log.debug("Received request to /station/station POST (addStation) with station=" + station);
        Station addedStation = stationService.createOrUpdateStation(station);
        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(),
                "Station created successfully");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseMessage> deleteStation(
            @ApiParam(value = "ID of the station to delete", required = true) @PathVariable("stationId") Integer stationId) {
        log.debug("Received request to /station/station/{stationId} DELETE (deleteStation) with stationId="
                + stationId);
        stationService.deleteStation(stationId);
        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(),
                "Station deleted successfully");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    public ResponseEntity<List<Station>> getStations() {
        log.debug("Received request to /station/stations GET (getStations)");
        List<Station> stations = stationService.getAllStations();
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseMessage> updateStation(
            @ApiParam(value = "ID of the station to update", required = true) @PathVariable("stationId") Integer stationId,
            @ApiParam(value = "Updated station object", required = true) @Valid @RequestBody Station station) {
        log.debug("Received request to /station/station/{stationId} PUT (updateStation) with stationId=" + stationId
                + " AND station=" + station);
        station.setStationId(stationId);
        Station updatedStation = stationService.createOrUpdateStation(station);
        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(),
                "Station updated successfully");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}

