package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TrainSeat
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:33:10.367+02:00")


public class TrainSeat   {
  @JsonProperty("seat_type")
  private String seatType = null;

  @JsonProperty("class_type")
  private String classType = null;

  @JsonProperty("seat_number")
  private String seatNumber = null;

  @JsonProperty("is_booked")
  private Boolean isBooked = null;

  @JsonProperty("seat_price")
  private BigDecimal seatPrice = null;

  public TrainSeat seatType(String seatType) {
    this.seatType = seatType;
    return this;
  }

  /**
   * Get seatType
   * @return seatType
  **/
  @ApiModelProperty(value = "")


  public String getSeatType() {
    return seatType;
  }

  public void setSeatType(String seatType) {
    this.seatType = seatType;
  }

  public TrainSeat classType(String classType) {
    this.classType = classType;
    return this;
  }

  /**
   * Get classType
   * @return classType
  **/
  @ApiModelProperty(value = "")


  public String getClassType() {
    return classType;
  }

  public void setClassType(String classType) {
    this.classType = classType;
  }

  public TrainSeat seatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
    return this;
  }

  /**
   * Get seatNumber
   * @return seatNumber
  **/
  @ApiModelProperty(value = "")


  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public TrainSeat isBooked(Boolean isBooked) {
    this.isBooked = isBooked;
    return this;
  }

  /**
   * Get isBooked
   * @return isBooked
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsBooked() {
    return isBooked;
  }

  public void setIsBooked(Boolean isBooked) {
    this.isBooked = isBooked;
  }

  public TrainSeat seatPrice(BigDecimal seatPrice) {
    this.seatPrice = seatPrice;
    return this;
  }

  /**
   * Get seatPrice
   * @return seatPrice
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getSeatPrice() {
    return seatPrice;
  }

  public void setSeatPrice(BigDecimal seatPrice) {
    this.seatPrice = seatPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrainSeat trainSeat = (TrainSeat) o;
    return Objects.equals(this.seatType, trainSeat.seatType) &&
        Objects.equals(this.classType, trainSeat.classType) &&
        Objects.equals(this.seatNumber, trainSeat.seatNumber) &&
        Objects.equals(this.isBooked, trainSeat.isBooked) &&
        Objects.equals(this.seatPrice, trainSeat.seatPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seatType, classType, seatNumber, isBooked, seatPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainSeat {\n");
    
    sb.append("    seatType: ").append(toIndentedString(seatType)).append("\n");
    sb.append("    classType: ").append(toIndentedString(classType)).append("\n");
    sb.append("    seatNumber: ").append(toIndentedString(seatNumber)).append("\n");
    sb.append("    isBooked: ").append(toIndentedString(isBooked)).append("\n");
    sb.append("    seatPrice: ").append(toIndentedString(seatPrice)).append("\n");
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

