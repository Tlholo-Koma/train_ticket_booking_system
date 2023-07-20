/**
 * NOTE: This class is auto generated by the swagger code generator program (unset).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.TrainClassType;
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
@Api(value = "trainClass", description = "the trainClass API")
@RequestMapping(value = "")
public interface TrainClassApi {

    @ApiOperation(value = "Add a new train class type", nickname = "addTrainClassType", notes = "", tags={ "trainClass", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train Class Type created successfully") })
    @RequestMapping(value = "/trainClass/trainClass",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addTrainClassType(@ApiParam(value = "Station object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType);


    @ApiOperation(value = "Delete a train class type", nickname = "deleteTrainClassType", notes = "", tags={ "trainClass", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train class type deleted successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Train class type not found") })
    @RequestMapping(value = "/trainClass/trainClass/{classId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTrainClassType(@ApiParam(value = "ID of the train class type to delete",required=true) @PathVariable("classId") Integer classId);


    @ApiOperation(value = "Get all classes", nickname = "getClasses", notes = "", response = TrainClassType.class, responseContainer = "List", tags={ "trainClass", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = TrainClassType.class, responseContainer = "List") })
    @RequestMapping(value = "/trainClass/trainClasses",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TrainClassType>> getClasses();


    @ApiOperation(value = "Update a train class type", nickname = "updateTrainClassType", notes = "", tags={ "trainClass", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Train class type updated successfully"),
        @ApiResponse(code = 400, message = "Invalid request data"),
        @ApiResponse(code = 404, message = "Train class type not found") })
    @RequestMapping(value = "/trainClass/trainClass/{classId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateTrainClassType(@ApiParam(value = "ID of the train class type to update",required=true) @PathVariable("classId") Integer classId,@ApiParam(value = "Updated train class type object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType);

}
