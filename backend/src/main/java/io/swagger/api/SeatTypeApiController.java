package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.SeatType;
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
public class SeatTypeApiController implements SeatTypeApi {

    private static final Logger log = LoggerFactory.getLogger(SeatTypeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SeatTypeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ApiResponseMessage> addSeatType(@ApiParam(value = "Seat type object" ,required=true )  @Valid @RequestBody SeatType seatType) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /seatType/seatType POST (addSeatType) with seatType=" + seatType);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> deleteSeatType(@ApiParam(value = "ID of the seat type to delete",required=true) @PathVariable("seatTypeId") Integer seatTypeId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /seatType/seatType/{seatTypeId} DELETE (deleteSeatType) with seatTypeId=" + seatTypeId);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> getSeatTypes() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /seatType/seatTypes GET (getSeatTypes)");

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> updateSeatType(@ApiParam(value = "ID of the seat type to update",required=true) @PathVariable("seatTypeId") Integer seatTypeId,@ApiParam(value = "Updated seat type object" ,required=true )  @Valid @RequestBody SeatType seatType) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /seatType/seatType/{seatTypeId} PUT (updateSeatType) with seatTypeId=" + seatTypeId + " and seatType=" + seatType);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);

    }

}
