/**
 * NOTE: This class is auto generated by the swagger code generator program (unset).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Train;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:33:10.367+02:00")

@Validated
@Api(value = "train", description = "the train API")
@RequestMapping(value = "")
public interface TrainApi {

    @ApiOperation(value = "Get all trains", nickname = "getTrains", notes = "", response = Train.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Train.class, responseContainer = "List") })
    @RequestMapping(value = "/train/trains",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Train>> getTrains();


    @ApiOperation(value = "Get trains based on station", nickname = "getTrainsBasedOnStation", notes = "", response = Train.class, responseContainer = "List", tags={ "train", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Train.class, responseContainer = "List") })
    @RequestMapping(value = "/train/getTrainsBasedOnStation",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Train>> getTrainsBasedOnStation(@NotNull @ApiParam(value = "The source station", required = true) @Valid @RequestParam(value = "from", required = true) String from,@NotNull @ApiParam(value = "The destination station", required = true) @Valid @RequestParam(value = "to", required = true) String to,@NotNull @ApiParam(value = "The travel date", required = true) @Valid @RequestParam(value = "date", required = true) Date date);

}
