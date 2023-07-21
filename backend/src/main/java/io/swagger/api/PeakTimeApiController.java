package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.PeakTime;
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
public class PeakTimeApiController implements PeakTimeApi {

    private static final Logger log = LoggerFactory.getLogger(PeakTimeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PeakTimeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addPeakTime(@ApiParam(value = "Peak time object" ,required=true )  @Valid @RequestBody PeakTime peakTime) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTime POST (addPeakTime) with peakTime=" + peakTime);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deletePeakTime(@ApiParam(value = "ID of the peak time to delete",required=true) @PathVariable("peakTimeId") Integer peakTimeId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTime/{peakTimeId} DELETE (deletePeakTime) with peakTimeId=" + peakTimeId);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<PeakTime>> getpeakTimes() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTimes GET (getpeakTimes)");
        return new ResponseEntity<List<PeakTime>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updatePeakTime(@ApiParam(value = "ID of the peak time to update",required=true) @PathVariable("peakTimeId") Integer peakTimeId,@ApiParam(value = "Updated peak time object" ,required=true )  @Valid @RequestBody PeakTime peakTime) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /peakTime/peakTime/{peakTimeId} PUT (updatePeakTime) with peakTimeId=" + peakTimeId + " and peakTime=" + peakTime);
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}