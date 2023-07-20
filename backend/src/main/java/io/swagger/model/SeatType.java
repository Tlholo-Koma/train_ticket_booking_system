package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SeatType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T11:15:32.579+02:00")


public class SeatType   {
  @JsonProperty("seat_type_id")
  private Integer seatTypeId = null;

  @JsonProperty("seat_type_name")
  private String seatTypeName = null;

  public SeatType seatTypeId(Integer seatTypeId) {
    this.seatTypeId = seatTypeId;
    return this;
  }

  /**
   * Get seatTypeId
   * @return seatTypeId
  **/
  @ApiModelProperty(value = "")


  public Integer getSeatTypeId() {
    return seatTypeId;
  }

  public void setSeatTypeId(Integer seatTypeId) {
    this.seatTypeId = seatTypeId;
  }

  public SeatType seatTypeName(String seatTypeName) {
    this.seatTypeName = seatTypeName;
    return this;
  }

  /**
   * Get seatTypeName
   * @return seatTypeName
  **/
  @ApiModelProperty(value = "")


  public String getSeatTypeName() {
    return seatTypeName;
  }

  public void setSeatTypeName(String seatTypeName) {
    this.seatTypeName = seatTypeName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeatType seatType = (SeatType) o;
    return Objects.equals(this.seatTypeId, seatType.seatTypeId) &&
        Objects.equals(this.seatTypeName, seatType.seatTypeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seatTypeId, seatTypeName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeatType {\n");
    
    sb.append("    seatTypeId: ").append(toIndentedString(seatTypeId)).append("\n");
    sb.append("    seatTypeName: ").append(toIndentedString(seatTypeName)).append("\n");
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

