/**
 * NOTE: This class is auto generated by the swagger code generator program (unset).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.SeatType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@Validated
@Api(value = "seatType", description = "the seatType API")
@RequestMapping(value = "")
public interface SeatTypeApi {

    @ApiOperation(value = "Add a new seat type", nickname = "addSeatType", notes = "", tags={ "seatType", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Seat type created successfully") })
    @RequestMapping(value = "/seatType/seatType",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ApiResponseMessage> addSeatType(@ApiParam(value = "Seat type object" ,required=true )  @Valid @RequestBody SeatType seatType);


    @ApiOperation(value = "Delete a seat type", nickname = "deleteSeatType", notes = "", tags={ "seatType", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Seat type deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Seat type not found") })
    @RequestMapping(value = "/seatType/seatType/{seatTypeId}",
        method = RequestMethod.DELETE)
    ResponseEntity<ApiResponseMessage> deleteSeatType(@ApiParam(value = "ID of the seat type to delete",required=true) @PathVariable("seatTypeId") Integer seatTypeId);


    @ApiOperation(value = "Get all seat types", nickname = "getSeatTypes", notes = "", response = SeatType.class, responseContainer = "List", tags={ "seatType", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = SeatType.class, responseContainer = "List") })
    @RequestMapping(value = "/seatType/seatTypes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ApiResponseMessage> getSeatTypes();


    @ApiOperation(value = "Update a seat type", nickname = "updateSeatType", notes = "", tags={ "seatType", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Seat type updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Seat type not found") })
    @RequestMapping(value = "/seatType/seatType/{seatTypeId}",
        method = RequestMethod.PUT)
    ResponseEntity<ApiResponseMessage> updateSeatType(@ApiParam(value = "ID of the seat type to update",required=true) @PathVariable("seatTypeId") Integer seatTypeId,@ApiParam(value = "Updated seat type object" ,required=true )  @Valid @RequestBody SeatType seatType);

}
