package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Booking
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T11:15:32.579+02:00")


public class Booking   {
  @JsonProperty("booking_id")
  private Integer bookingId = null;

  @JsonProperty("train_id")
  private Integer trainId = null;

  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("booking_date")
  private String bookingDate = null;

  @JsonProperty("ticket_price")
  private BigDecimal ticketPrice = null;

  @JsonProperty("passengers")
  @Valid
  private List<Passenger> passengers = null;

  public Booking bookingId(Integer bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Get bookingId
   * @return bookingId
  **/
  @ApiModelProperty(value = "")


  public Integer getBookingId() {
    return bookingId;
  }

  public void setBookingId(Integer bookingId) {
    this.bookingId = bookingId;
  }

  public Booking trainId(Integer trainId) {
    this.trainId = trainId;
    return this;
  }

  /**
   * Get trainId
   * @return trainId
  **/
  @ApiModelProperty(value = "")


  public Integer getTrainId() {
    return trainId;
  }

  public void setTrainId(Integer trainId) {
    this.trainId = trainId;
  }

  public Booking userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Booking bookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
    return this;
  }

  /**
   * Get bookingDate
   * @return bookingDate
  **/
  @ApiModelProperty(value = "")


  public String getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
  }

  public Booking ticketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
    return this;
  }

  /**
   * Get ticketPrice
   * @return ticketPrice
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public Booking passengers(List<Passenger> passengers) {
    this.passengers = passengers;
    return this;
  }

  public Booking addPassengersItem(Passenger passengersItem) {
    if (this.passengers == null) {
      this.passengers = new ArrayList<Passenger>();
    }
    this.passengers.add(passengersItem);
    return this;
  }

  /**
   * Get passengers
   * @return passengers
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.bookingId, booking.bookingId) &&
        Objects.equals(this.trainId, booking.trainId) &&
        Objects.equals(this.userId, booking.userId) &&
        Objects.equals(this.bookingDate, booking.bookingDate) &&
        Objects.equals(this.ticketPrice, booking.ticketPrice) &&
        Objects.equals(this.passengers, booking.passengers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, trainId, userId, bookingDate, ticketPrice, passengers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    trainId: ").append(toIndentedString(trainId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    ticketPrice: ").append(toIndentedString(ticketPrice)).append("\n");
    sb.append("    passengers: ").append(toIndentedString(passengers)).append("\n");
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

