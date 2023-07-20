package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Passenger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserBooking
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:33:10.367+02:00")


public class UserBooking   {
  @JsonProperty("train_id")
  private Integer trainId = null;

  @JsonProperty("train_class")
  private String trainClass = null;

  @JsonProperty("user_email")
  private String userEmail = null;

  @JsonProperty("passengers")
  @Valid
  private List<Passenger> passengers = null;

  public UserBooking trainId(Integer trainId) {
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

  public UserBooking trainClass(String trainClass) {
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

  public UserBooking userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  /**
   * Get userEmail
   * @return userEmail
  **/
  @ApiModelProperty(value = "")


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public UserBooking passengers(List<Passenger> passengers) {
    this.passengers = passengers;
    return this;
  }

  public UserBooking addPassengersItem(Passenger passengersItem) {
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
    UserBooking userBooking = (UserBooking) o;
    return Objects.equals(this.trainId, userBooking.trainId) &&
        Objects.equals(this.trainClass, userBooking.trainClass) &&
        Objects.equals(this.userEmail, userBooking.userEmail) &&
        Objects.equals(this.passengers, userBooking.passengers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trainId, trainClass, userEmail, passengers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBooking {\n");
    
    sb.append("    trainId: ").append(toIndentedString(trainId)).append("\n");
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

