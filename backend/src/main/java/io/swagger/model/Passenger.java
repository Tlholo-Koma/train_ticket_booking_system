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
 * Passenger
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")


public class Passenger   {
  @JsonProperty("seat_id")
  private Integer seatId = null;

  @JsonProperty("seat_type")
  private String seatType = null;

  @JsonProperty("seat_number")
  private String seatNumber = null;

  @JsonProperty("seat_price")
  private BigDecimal seatPrice = null;

  @JsonProperty("passenger_id")
  private Integer passengerId = null;

  @JsonProperty("passenger_name")
  private String passengerName = null;

  @JsonProperty("age")
  private Integer age = null;

  public Passenger seatId(Integer seatId) {
    this.seatId = seatId;
    return this;
  }

  /**
   * Get seatId
   * @return seatId
  **/
  @ApiModelProperty(value = "")


  public Integer getSeatId() {
    return seatId;
  }

  public void setSeatId(Integer seatId) {
    this.seatId = seatId;
  }

  public Passenger seatType(String seatType) {
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

  public Passenger seatNumber(String seatNumber) {
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

  public Passenger seatPrice(BigDecimal seatPrice) {
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

  public Passenger passengerId(Integer passengerId) {
    this.passengerId = passengerId;
    return this;
  }

  /**
   * Get passengerId
   * @return passengerId
  **/
  @ApiModelProperty(value = "")


  public Integer getPassengerId() {
    return passengerId;
  }

  public void setPassengerId(Integer passengerId) {
    this.passengerId = passengerId;
  }

  public Passenger passengerName(String passengerName) {
    this.passengerName = passengerName;
    return this;
  }

  /**
   * Get passengerName
   * @return passengerName
  **/
  @ApiModelProperty(value = "")


  public String getPassengerName() {
    return passengerName;
  }

  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }

  public Passenger age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Passenger passenger = (Passenger) o;
    return Objects.equals(this.seatId, passenger.seatId) &&
        Objects.equals(this.seatType, passenger.seatType) &&
        Objects.equals(this.seatNumber, passenger.seatNumber) &&
        Objects.equals(this.seatPrice, passenger.seatPrice) &&
        Objects.equals(this.passengerId, passenger.passengerId) &&
        Objects.equals(this.passengerName, passenger.passengerName) &&
        Objects.equals(this.age, passenger.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seatId, seatType, seatNumber, seatPrice, passengerId, passengerName, age);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Passenger {\n");
    
    sb.append("    seatId: ").append(toIndentedString(seatId)).append("\n");
    sb.append("    seatType: ").append(toIndentedString(seatType)).append("\n");
    sb.append("    seatNumber: ").append(toIndentedString(seatNumber)).append("\n");
    sb.append("    seatPrice: ").append(toIndentedString(seatPrice)).append("\n");
    sb.append("    passengerId: ").append(toIndentedString(passengerId)).append("\n");
    sb.append("    passengerName: ").append(toIndentedString(passengerName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
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

