package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Admin;
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
public class AdminApiController implements AdminApi {

    private static final Logger log = LoggerFactory.getLogger(AdminApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AdminApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ApiResponseMessage> addAdmin(@ApiParam(value = "Admin object" ,required=true )  @Valid @RequestBody Admin admin) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /admin/admin POST (addAdmin) with admin=" + admin);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> deleteAdmin(@ApiParam(value = "ID of the admin to delete",required=true) @PathVariable("adminId") Integer adminId) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /admin/admin/{adminId} DELETE (deleteAdmin) with adminId=" + adminId);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> getAdmins() {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /admin/admins GET (getAdmins)");

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ApiResponseMessage> updateAdmin(@ApiParam(value = "ID of the admin to update",required=true) @PathVariable("adminId") Integer adminId,@ApiParam(value = "Updated admin object" ,required=true )  @Valid @RequestBody Admin admin) {
        String accept = request.getHeader("Accept");
        log.debug("Received request to /admin/admin/{adminId} PUT (updateAdmin) with adminId=" + adminId + " AND admin=" + admin);

        ApiResponseMessage responseMessage = new ApiResponseMessage(HttpStatus.NOT_IMPLEMENTED.value(), "Not implemented");
        log.debug("Response: " + responseMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_IMPLEMENTED);
    }

}
