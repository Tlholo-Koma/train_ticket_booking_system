/**
 * NOTE: This class is auto generated by the swagger code generator program (unset).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
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
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T11:15:32.579+02:00")

@Validated
@Api(value = "booking", description = "the booking API")
@RequestMapping(value = "")
public interface BookingApi {

    @ApiOperation(value = "Add a new seat type", nickname = "addSeatType", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Seat type created successfully") })
    @RequestMapping(value = "/booking/seatType",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addSeatType(@ApiParam(value = "Seat type object" ,required=true )  @Valid @RequestBody SeatType seatType);


    @ApiOperation(value = "Add a new train class type", nickname = "addTrainClassType", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train Class Type created successfully") })
    @RequestMapping(value = "/booking/class",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addTrainClassType(@ApiParam(value = "Station object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType);


    @ApiOperation(value = "Add a new station", nickname = "addStation", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Station created successfully") })
    @RequestMapping(value = "/booking/station",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addStation(@ApiParam(value = "Station object" ,required=true )  @Valid @RequestBody Station station);


    @ApiOperation(value = "Create a new booking", nickname = "bookTrain", notes = "", response = Integer.class, tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Booking created successfully", response = Integer.class) })
    @RequestMapping(value = "/booking",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Integer> bookTrain(@ApiParam(value = "User Booking" ,required=true )  @Valid @RequestBody UserBooking booking);


    @ApiOperation(value = "Delete a seat type", nickname = "deleteSeatType", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Seat type deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Seat type not found") })
    @RequestMapping(value = "/booking/seatType/{seatTypeId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSeatType(@ApiParam(value = "ID of the seat type to delete",required=true) @PathVariable("seatTypeId") Integer seatTypeId);


    @ApiOperation(value = "Delete a station", nickname = "deleteStation", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Station deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Station not found") })
    @RequestMapping(value = "/booking/station/{stationId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStation(@ApiParam(value = "ID of the station to delete",required=true) @PathVariable("stationId") Integer stationId);


    @ApiOperation(value = "Delete a train class type", nickname = "deleteTrainClassType", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train class type deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Train class type not found") })
    @RequestMapping(value = "/booking/class/{classId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTrainClassType(@ApiParam(value = "ID of the train class type to delete",required=true) @PathVariable("classId") Integer classId);


    @ApiOperation(value = "Get a booking", nickname = "getBooking", notes = "", response = TrainTicket.class, tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train Ticket", response = TrainTicket.class) })
    @RequestMapping(value = "/booking/{bookingId}",
        method = RequestMethod.GET)
    ResponseEntity<TrainTicket> getBooking(@ApiParam(value = "ID of the booking to get",required=true) @PathVariable("bookingId") Integer bookingId);


    @ApiOperation(value = "Get all classes", nickname = "getClasses", notes = "", response = TrainClassType.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = TrainClassType.class, responseContainer = "List") })
    @RequestMapping(value = "/booking/classes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TrainClassType>> getClasses();


    @ApiOperation(value = "Get all seat types", nickname = "getSeatTypes", notes = "", response = SeatType.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = SeatType.class, responseContainer = "List") })
    @RequestMapping(value = "/booking/seatTypes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SeatType>> getSeatTypes();


    @ApiOperation(value = "Get all stations", nickname = "getStations", notes = "", response = Station.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Station.class, responseContainer = "List") })
    @RequestMapping(value = "/booking/stations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Station>> getStations();


    @ApiOperation(value = "Get all trains", nickname = "getTrains", notes = "", response = Train.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Train.class, responseContainer = "List") })
    @RequestMapping(value = "/booking/trains",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Train>> getTrains();


    @ApiOperation(value = "Get trains based on station", nickname = "getTrainsBasedOnStation", notes = "", response = Train.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Train.class, responseContainer = "List") })
    @RequestMapping(value = "/booking/getTrainsBasedOnStation",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Train>> getTrainsBasedOnStation(@NotNull @ApiParam(value = "The source station", required = true) @Valid @RequestParam(value = "from", required = true) String from,@NotNull @ApiParam(value = "The destination station", required = true) @Valid @RequestParam(value = "to", required = true) String to,@NotNull @ApiParam(value = "The travel date", required = true) @Valid @RequestParam(value = "date", required = true) LocalDate date);


    @ApiOperation(value = "Update a booking", nickname = "updateBooking", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Booking updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Booking not found") })
    @RequestMapping(value = "/booking/{bookingId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateBooking(@ApiParam(value = "ID of the booking to update",required=true) @PathVariable("bookingId") Integer bookingId,@ApiParam(value = "Updated booking object" ,required=true )  @Valid @RequestBody Booking booking);


    @ApiOperation(value = "Update passenger details in a booking", nickname = "updatePassenger", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Passenger details updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Booking or passenger not found") })
    @RequestMapping(value = "/booking/{bookingId}/passenger/{passengerId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePassenger(@ApiParam(value = "ID of the booking containing the passenger",required=true) @PathVariable("bookingId") Integer bookingId,@ApiParam(value = "ID of the passenger to update",required=true) @PathVariable("passengerId") Integer passengerId,@ApiParam(value = "Updated passenger object" ,required=true )  @Valid @RequestBody Passenger passenger);


    @ApiOperation(value = "Update a seat type", nickname = "updateSeatType", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Seat type updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Seat type not found") })
    @RequestMapping(value = "/booking/seatType/{seatTypeId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateSeatType(@ApiParam(value = "ID of the seat type to update",required=true) @PathVariable("seatTypeId") Integer seatTypeId,@ApiParam(value = "Updated seat type object" ,required=true )  @Valid @RequestBody SeatType seatType);


    @ApiOperation(value = "Update a station", nickname = "updateStation", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Station updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Station not found") })
    @RequestMapping(value = "/booking/station/{stationId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateStation(@ApiParam(value = "ID of the station to update",required=true) @PathVariable("stationId") Integer stationId,@ApiParam(value = "Updated station object" ,required=true )  @Valid @RequestBody Station station);


    @ApiOperation(value = "Update a train class type", nickname = "updateTrainClassType", notes = "", tags={ "booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train class type updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Train class type not found") })
    @RequestMapping(value = "/booking/class/{classId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateTrainClassType(@ApiParam(value = "ID of the train class type to update",required=true) @PathVariable("classId") Integer classId,@ApiParam(value = "Updated train class type object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType);

}
