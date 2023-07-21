package io.swagger.api;

import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlTransient;
import java.sql.Timestamp;
import java.time.Instant;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")

@javax.xml.bind.annotation.XmlRootElement
public class ApiResponseMessage {
    Instant timestamp;
    int status;
    String type;
    String message;
    Object data = null;

    public ApiResponseMessage(){}

    public ApiResponseMessage(int status, String message){
        this.timestamp = Instant.now();
        this.status = status;
        this.type = getMessageFromHttpStatus(status);
        this.message = message;
    }

    public ApiResponseMessage(int status, String message, Object data){
        this.timestamp = Instant.now();
        this.status = status;
        this.type = getMessageFromHttpStatus(status);
        this.message = message;
        this.data = data;
    }

    private String getMessageFromHttpStatus(int status) {
        HttpStatus httpStatus = HttpStatus.valueOf(status);
        return httpStatus.getReasonPhrase();
    }

    @XmlTransient
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiResponseMessage {\n");

        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
