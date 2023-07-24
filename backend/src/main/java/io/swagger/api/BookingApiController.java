package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Booking;
import io.swagger.model.Train;
import io.swagger.service.BookingService;
import io.swagger.service.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@Controller
public class BookingApiController implements BookingApi {

    private static final Logger log = LoggerFactory.getLogger(BookingApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final BookingService bookingService;
    private final TrainService trainService;

    @Autowired
    public BookingApiController(ObjectMapper objectMapper, HttpServletRequest request,
            BookingService bookingService, TrainService trainService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.bookingService = bookingService;
        this.trainService = trainService;
    }

    public ResponseEntity<ApiResponseMessage> bookTrain(
            @ApiParam(value = "User Booking" ,required=true )  @Valid @RequestBody Booking booking) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking POST (bookTrain) with booking=" + booking);

        try {
            Train train = trainService.getTrainById(booking.getTrainId());
            booking.setTrainName(train.getTrainName());
            booking.setSourceStation(train.getSourceStation().getStationName());
            booking.setDestinationStation(train.getDestinationStation().getStationName());
            booking.setTravelDate(train.getTravelDate());
            booking.setDepartureTime(train.getDepartureTime());

            // TODO: add ticket price
            Booking addedStation = bookingService.createOrUpdateTrain(booking);
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(), "Booking created successfully");
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }
        catch (Exception e) {
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to add booking.", e.getMessage());
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponseMessage> deleteBooking(
            @ApiParam(value = "ID of the booking to delete",required=true) @PathVariable("bookingId") Integer bookingId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking/{bookingId} DELETE (deleteBooking) with bookingId=" + bookingId);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> getBooking(
            @ApiParam(value = "ID of the booking to get",required=true) @PathVariable("bookingId") Integer bookingId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking/{bookingId} GET (getBooking) with bookingId=" + bookingId);

        try {
            Booking foundBooking = bookingService.getBookingById(bookingId);
            System.out.println(foundBooking);

            if (foundBooking == null) {
                ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_FOUND.value(), "Booking was not found.");
                log.debug("Response: " + responseMessage);
                return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
            }

            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.OK.value(), "Booking found successfully", foundBooking);
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to get booking.", e.getMessage());
            log.debug("Response: " + responseMessage);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponseMessage> getBookings(
            @ApiParam(value = "User email of bookings to get",required=true) @PathVariable("userEmail") String userEmail) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/getBooking/{userEmail} GET (getBookings) with userEmail=" + userEmail);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> updateBooking(
            @ApiParam(value = "ID of the booking to update",required=true) @PathVariable("bookingId") Integer bookingId,@ApiParam(value = "Updated booking object" ,required=true )  @Valid @RequestBody Booking booking) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /booking/booking/{bookingId} PUT (updateBooking) with bookingId=" + bookingId + " and booking=" + booking);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

}
