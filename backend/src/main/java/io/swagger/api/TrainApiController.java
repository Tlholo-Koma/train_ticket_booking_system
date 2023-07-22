package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Train;
import io.swagger.service.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-21T17:12:22.488+02:00")

@Controller
public class TrainApiController implements TrainApi {

    private static final Logger log = LoggerFactory.getLogger(TrainApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final TrainService trainService;

    @Autowired
    public TrainApiController(ObjectMapper objectMapper, HttpServletRequest request,
            TrainService trainService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.trainService = trainService;
    }

    public ResponseEntity<ApiResponseMessage> addTrain(@ApiParam(value = "Train object" ,required=true )  @Valid @RequestBody Train train) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /train/train POST (addTrain) with train=" + train);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> deleteTrain(@ApiParam(value = "ID of the train to delete",required=true) @PathVariable("trainId") Integer trainId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /train/train/{trainId} DELETE (deleteTrain) with trainId=" + trainId);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> getTrains() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /train/trains GET (getTrains)");

        try {
            List<Train> trains = trainService.getAllTrains();

            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(), "Trains retrieved successfully", trains);
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to retrieve trains", e.getMessage());
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponseMessage> getTrainsBasedOnStation(@NotNull @ApiParam(value = "The source station", required = true) @Valid @RequestParam(value = "from", required = true) String from,@NotNull @ApiParam(value = "The destination station", required = true) @Valid @RequestParam(value = "to", required = true) String to,@NotNull @ApiParam(value = "The travel date", required = true) @Valid @RequestParam(value = "date", required = true) Date date) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /train/getTrainsBasedOnStation GET (getTrainsBasedOnStation) with from=" + from + " AND to=" + to + " AND date=" + date);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> updateTrain(@ApiParam(value = "ID of the train to update",required=true) @PathVariable("trainId") Integer trainId,@ApiParam(value = "Updated train" ,required=true )  @Valid @RequestBody Train train) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /train/train/{trainId} PUT (updateTrain) with =" + trainId + " AND train=" + train);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

}
