package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.TrainTicket;
import io.swagger.model.UserBooking;
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
public class BookingApiController implements BookingApi {

    private static final Logger log = LoggerFactory.getLogger(BookingApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookingApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Integer> bookTrain(@ApiParam(value = "User Booking" ,required=true )  @Valid @RequestBody UserBooking booking) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking POST (bookTrain) with booking=" + booking);
        return new ResponseEntity<Integer>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteBooking(@ApiParam(value = "ID of the booking to delete",required=true) @PathVariable("bookingId") Integer bookingId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking/{bookingId} DELETE (deleteBooking) with bookingId=" + bookingId);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TrainTicket> getBooking(@ApiParam(value = "ID of the booking to get",required=true) @PathVariable("bookingId") Integer bookingId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking/{bookingId} GET (getBooking) with bookingId=" + bookingId);
        return new ResponseEntity<TrainTicket>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<TrainTicket>> getBookings(@ApiParam(value = "User email of bookings to get",required=true) @PathVariable("userEmail") String userEmail) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/getBooking/{userEmail} GET (getBookings) with userEmail=" + userEmail);
        return new ResponseEntity<List<TrainTicket>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateBooking(@ApiParam(value = "ID of the booking to update",required=true) @PathVariable("bookingId") Integer bookingId,@ApiParam(value = "Updated booking object" ,required=true )  @Valid @RequestBody TrainTicket booking) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking/{bookingId} PUT (updateBooking) with bookingId=" + bookingId + " and booking=" + booking);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
