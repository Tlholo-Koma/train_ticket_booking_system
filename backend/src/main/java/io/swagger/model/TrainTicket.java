package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TrainTicket
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")


public class TrainTicket   {
  @JsonProperty("train_name")
  private String trainName = null;

  @JsonProperty("source_station")
  private String sourceStation = null;

  @JsonProperty("destination_station")
  private String destinationStation = null;

  @JsonProperty("travel_date")
  private LocalDate travelDate = null;

  @JsonProperty("departure_time")
  private String departureTime = null;

  @JsonProperty("booking_id")
  private Integer bookingId = null;

  @JsonProperty("booking_date")
  private String bookingDate = null;

  @JsonProperty("ticket_price")
  private BigDecimal ticketPrice = null;

  @JsonProperty("train_class")
  private String trainClass = null;

  @JsonProperty("user_email")
  private String userEmail = null;

  @JsonProperty("passengers")
  @Valid
  private List<Passenger> passengers = null;

  public TrainTicket trainName(String trainName) {
    this.trainName = trainName;
    return this;
  }

  /**
   * Get trainName
   * @return trainName
  **/
  @ApiModelProperty(value = "")


  public String getTrainName() {
    return trainName;
  }

  public void setTrainName(String trainName) {
    this.trainName = trainName;
  }

  public TrainTicket sourceStation(String sourceStation) {
    this.sourceStation = sourceStation;
    return this;
  }

  /**
   * Get sourceStation
   * @return sourceStation
  **/
  @ApiModelProperty(value = "")


  public String getSourceStation() {
    return sourceStation;
  }

  public void setSourceStation(String sourceStation) {
    this.sourceStation = sourceStation;
  }

  public TrainTicket destinationStation(String destinationStation) {
    this.destinationStation = destinationStation;
    return this;
  }

  /**
   * Get destinationStation
   * @return destinationStation
  **/
  @ApiModelProperty(value = "")


  public String getDestinationStation() {
    return destinationStation;
  }

  public void setDestinationStation(String destinationStation) {
    this.destinationStation = destinationStation;
  }

  public TrainTicket travelDate(LocalDate travelDate) {
    this.travelDate = travelDate;
    return this;
  }

  /**
   * Get travelDate
   * @return travelDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getTravelDate() {
    return travelDate;
  }

  public void setTravelDate(LocalDate travelDate) {
    this.travelDate = travelDate;
  }

  public TrainTicket departureTime(String departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Get departureTime
   * @return departureTime
  **/
  @ApiModelProperty(value = "")


  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public TrainTicket bookingId(Integer bookingId) {
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

  public TrainTicket bookingDate(String bookingDate) {
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

  public TrainTicket ticketPrice(BigDecimal ticketPrice) {
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

  public TrainTicket trainClass(String trainClass) {
    this.trainClass = trainClass;
    return this;
  }

  /**
   * Get trainClass
   * @return trainClass
  **/
  @ApiModelProperty(value = "")


  public String getTrainClass() {
    return trainClass;
  }

  public void setTrainClass(String trainClass) {
    this.trainClass = trainClass;
  }

  public TrainTicket userId(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public TrainTicket passengers(List<Passenger> passengers) {
    this.passengers = passengers;
    return this;
  }

  public TrainTicket addPassengersItem(Passenger passengersItem) {
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
    TrainTicket trainTicket = (TrainTicket) o;
    return Objects.equals(this.trainName, trainTicket.trainName) &&
        Objects.equals(this.sourceStation, trainTicket.sourceStation) &&
        Objects.equals(this.destinationStation, trainTicket.destinationStation) &&
        Objects.equals(this.travelDate, trainTicket.travelDate) &&
        Objects.equals(this.departureTime, trainTicket.departureTime) &&
        Objects.equals(this.bookingId, trainTicket.bookingId) &&
        Objects.equals(this.bookingDate, trainTicket.bookingDate) &&
        Objects.equals(this.ticketPrice, trainTicket.ticketPrice) &&
        Objects.equals(this.trainClass, trainTicket.trainClass) &&
        Objects.equals(this.userEmail, trainTicket.userEmail) &&
        Objects.equals(this.passengers, trainTicket.passengers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trainName, sourceStation, destinationStation, travelDate, departureTime, bookingId, bookingDate, ticketPrice, trainClass, userEmail, passengers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainTicket {\n");
    
    sb.append("    trainName: ").append(toIndentedString(trainName)).append("\n");
    sb.append("    sourceStation: ").append(toIndentedString(sourceStation)).append("\n");
    sb.append("    destinationStation: ").append(toIndentedString(destinationStation)).append("\n");
    sb.append("    travelDate: ").append(toIndentedString(travelDate)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    ticketPrice: ").append(toIndentedString(ticketPrice)).append("\n");
    sb.append("    trainClass: ").append(toIndentedString(trainClass)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
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

