/**
 * NOTE: This class is auto generated by the swagger code generator program (unset).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.PeakTime;
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
@Api(value = "peakTime", description = "the peakTime API")
@RequestMapping(value = "")
public interface PeakTimeApi {

    @ApiOperation(value = "Add a new peak time", nickname = "addPeakTime", notes = "", tags={ "peakTime", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Peak time created successfully") })
    @RequestMapping(value = "/peakTime/peakTime",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addPeakTime(@ApiParam(value = "Peak time object" ,required=true )  @Valid @RequestBody PeakTime peakTime);


    @ApiOperation(value = "Delete a peak time", nickname = "deletePeakTime", notes = "", tags={ "peakTime", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Peak time deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Peak time not found") })
    @RequestMapping(value = "/peakTime/peakTime/{peakTimeId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePeakTime(@ApiParam(value = "ID of the peak time to delete",required=true) @PathVariable("peakTimeId") Integer peakTimeId);


    @ApiOperation(value = "Get all peak times", nickname = "getpeakTimes", notes = "", response = PeakTime.class, responseContainer = "List", tags={ "peakTime", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = PeakTime.class, responseContainer = "List") })
    @RequestMapping(value = "/peakTime/peakTimes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PeakTime>> getpeakTimes();


    @ApiOperation(value = "Update a peakTime", nickname = "updatePeakTime", notes = "", tags={ "peakTime", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Peak time updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Peak time not found") })
    @RequestMapping(value = "/peakTime/peakTime/{peakTimeId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePeakTime(@ApiParam(value = "ID of the peak time to update",required=true) @PathVariable("peakTimeId") Integer peakTimeId,@ApiParam(value = "Updated peak time object" ,required=true )  @Valid @RequestBody PeakTime peakTime);

}
