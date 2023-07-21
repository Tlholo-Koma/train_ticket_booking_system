package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.TrainClassType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@Controller
public class TrainClassApiController implements TrainClassApi {

    private static final Logger log = LoggerFactory.getLogger(TrainClassApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TrainClassApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ApiResponseMessage> addTrainClassType(@ApiParam(value = "Station object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /trainClass/trainClass POST (addTrainClassType) with trainClassType=" + trainClassType);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> deleteTrainClassType(@ApiParam(value = "ID of the train class type to delete",required=true) @PathVariable("classId") Integer classId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /trainClass/trainClass/{classId} DELETE (deleteTrainClassType) with classId=" + classId);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> getClasses() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /trainClass/trainClasses GET (getClasses)");

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> updateTrainClassType(@ApiParam(value = "ID of the train class type to update",required=true) @PathVariable("classId") Integer classId,@ApiParam(value = "Updated train class type object" ,required=true )  @Valid @RequestBody TrainClassType trainClassType) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /trainClass/trainClass/{classId} PUT (updateTrainClassType) with classId=" + classId + " AND trainClassType=" + trainClassType);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

}
