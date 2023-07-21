package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Train;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@Controller
public class TrainApiController implements TrainApi {

    private static final Logger log = LoggerFactory.getLogger(TrainApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TrainApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Train>> getTrains() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /train/trains GET (getTrains)");
        return new ResponseEntity<List<Train>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Train>> getTrainsBasedOnStation(@NotNull @ApiParam(value = "The source station", required = true) @Valid @RequestParam(value = "from", required = true) String from,@NotNull @ApiParam(value = "The destination station", required = true) @Valid @RequestParam(value = "to", required = true) String to,@NotNull @ApiParam(value = "The travel date", required = true) @Valid @RequestParam(value = "date", required = true) Date date) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /train/getTrainsBasedOnStation GET (getTrainsBasedOnStation) with from=" + from + " AND to=" + to + " AND date=" + date);
        return new ResponseEntity<List<Train>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
