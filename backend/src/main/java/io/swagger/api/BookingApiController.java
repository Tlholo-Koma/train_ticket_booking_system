package io.swagger.api;

import io.swagger.model.Booking;
import org.threeten.bp.LocalDate;
import io.swagger.model.Passenger;
import io.swagger.model.SeatType;
import io.swagger.model.Station;
import io.swagger.model.Train;
import io.swagger.model.TrainClassType;
import io.swagger.model.TrainTicket;
import io.swagger.model.UserBooking;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T11:15:32.579+02:00")

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

    public ResponseEntity<Void> addSeatType(@ApiParam(value = "Seat type object" ,required=true )  @Valid @RequestBody SeatType seatType) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> addTrainClassType(@ApiParam(value = "Station object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> addStation(@ApiParam(value = "Station object" ,required=true )  @Valid @RequestBody Station station) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Integer> bookTrain(@ApiParam(value = "User Booking" ,required=true )  @Valid @RequestBody UserBooking booking) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Integer>(objectMapper.readValue("{}", Integer.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Integer>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteSeatType(@ApiParam(value = "ID of the seat type to delete",required=true) @PathVariable("seatTypeId") Integer seatTypeId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteStation(@ApiParam(value = "ID of the station to delete",required=true) @PathVariable("stationId") Integer stationId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTrainClassType(@ApiParam(value = "ID of the train class type to delete",required=true) @PathVariable("classId") Integer classId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TrainTicket> getBooking(@ApiParam(value = "ID of the booking to get",required=true) @PathVariable("bookingId") Integer bookingId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TrainTicket>(objectMapper.readValue("{\"empty\": false}", TrainTicket.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TrainTicket>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TrainTicket>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<TrainClassType>> getClasses() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<TrainClassType>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<TrainClassType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<TrainClassType>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<SeatType>> getSeatTypes() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<SeatType>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<SeatType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<SeatType>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Station>> getStations() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Station>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Station>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Station>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Train>> getTrains() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Train>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Train>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Train>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Train>> getTrainsBasedOnStation(@NotNull @ApiParam(value = "The source station", required = true) @Valid @RequestParam(value = "from", required = true) String from,@NotNull @ApiParam(value = "The destination station", required = true) @Valid @RequestParam(value = "to", required = true) String to,@NotNull @ApiParam(value = "The travel date", required = true) @Valid @RequestParam(value = "date", required = true) LocalDate date) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Train>>(objectMapper.readValue("{}", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Train>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Train>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateBooking(@ApiParam(value = "ID of the booking to update",required=true) @PathVariable("bookingId") Integer bookingId,@ApiParam(value = "Updated booking object" ,required=true )  @Valid @RequestBody Booking booking) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updatePassenger(@ApiParam(value = "ID of the booking containing the passenger",required=true) @PathVariable("bookingId") Integer bookingId,@ApiParam(value = "ID of the passenger to update",required=true) @PathVariable("passengerId") Integer passengerId,@ApiParam(value = "Updated passenger object" ,required=true )  @Valid @RequestBody Passenger passenger) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateSeatType(@ApiParam(value = "ID of the seat type to update",required=true) @PathVariable("seatTypeId") Integer seatTypeId,@ApiParam(value = "Updated seat type object" ,required=true )  @Valid @RequestBody SeatType seatType) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateStation(@ApiParam(value = "ID of the station to update",required=true) @PathVariable("stationId") Integer stationId,@ApiParam(value = "Updated station object" ,required=true )  @Valid @RequestBody Station station) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTrainClassType(@ApiParam(value = "ID of the train class type to update",required=true) @PathVariable("classId") Integer classId,@ApiParam(value = "Updated train class type object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
