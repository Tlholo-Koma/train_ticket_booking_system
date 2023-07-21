package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@Controller
public class StationApiController implements StationApi {

    private static final Logger log = LoggerFactory.getLogger(StationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addStation(@ApiParam(value = "Station object" ,required=true )  @Valid @RequestBody Station station) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /station/station POST (addStation) with station=" + station);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteStation(@ApiParam(value = "ID of the station to delete",required=true) @PathVariable("stationId") Integer stationId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /station/station/{stationId} DELETE (deleteStation) with stationId=" + stationId);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Station>> getStations() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /station/stations GET (getStations)");
        return new ResponseEntity<List<Station>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateStation(@ApiParam(value = "ID of the station to update",required=true) @PathVariable("stationId") Integer stationId,@ApiParam(value = "Updated station object" ,required=true )  @Valid @RequestBody Station station) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /station/station/{stationId} PUT (updateStation) with stationId=" + stationId + " AND station=" + station);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}