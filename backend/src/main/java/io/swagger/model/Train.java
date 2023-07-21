package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * Train
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")


public class Train   {
  @JsonProperty("train_id")
  private Integer trainId = null;

  @JsonProperty("train_name")
  private String trainName = null;

  @JsonProperty("source_station")
  private String sourceStation = null;

  @JsonProperty("destination_station")
  private String destinationStation = null;

  @JsonProperty("travel_date")
  private Date travelDate = null;

  @JsonProperty("departure_time")
  private String departureTime = null;

  @JsonProperty("train_classes")
  @Valid
  private List<TrainClass> trainClasses = null;

  @JsonProperty("train_seats")
  @Valid
  private List<TrainSeat> trainSeats = null;

  public Train trainId(Integer trainId) {
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

  public Train trainName(String trainName) {
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

  public Train sourceStation(String sourceStation) {
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

  public Train destinationStation(String destinationStation) {
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

  public Train travelDate(Date travelDate) {
    this.travelDate = travelDate;
    return this;
  }

  /**
   * Get travelDate
   * @return travelDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Date getTravelDate() {
    return travelDate;
  }

  public void setTravelDate(Date travelDate) {
    this.travelDate = travelDate;
  }

  public Train departureTime(String departureTime) {
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

  public Train trainClasses(List<TrainClass> trainClasses) {
    this.trainClasses = trainClasses;
    return this;
  }

  public Train addTrainClassesItem(TrainClass trainClassesItem) {
    if (this.trainClasses == null) {
      this.trainClasses = new ArrayList<TrainClass>();
    }
    this.trainClasses.add(trainClassesItem);
    return this;
  }

  /**
   * Get trainClasses
   * @return trainClasses
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TrainClass> getTrainClasses() {
    return trainClasses;
  }

  public void setTrainClasses(List<TrainClass> trainClasses) {
    this.trainClasses = trainClasses;
  }

  public Train trainSeats(List<TrainSeat> trainSeats) {
    this.trainSeats = trainSeats;
    return this;
  }

  public Train addTrainSeatsItem(TrainSeat trainSeatsItem) {
    if (this.trainSeats == null) {
      this.trainSeats = new ArrayList<TrainSeat>();
    }
    this.trainSeats.add(trainSeatsItem);
    return this;
  }

  /**
   * Get trainSeats
   * @return trainSeats
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TrainSeat> getTrainSeats() {
    return trainSeats;
  }

  public void setTrainSeats(List<TrainSeat> trainSeats) {
    this.trainSeats = trainSeats;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Train train = (Train) o;
    return Objects.equals(this.trainId, train.trainId) &&
        Objects.equals(this.trainName, train.trainName) &&
        Objects.equals(this.sourceStation, train.sourceStation) &&
        Objects.equals(this.destinationStation, train.destinationStation) &&
        Objects.equals(this.travelDate, train.travelDate) &&
        Objects.equals(this.departureTime, train.departureTime) &&
        Objects.equals(this.trainClasses, train.trainClasses) &&
        Objects.equals(this.trainSeats, train.trainSeats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trainId, trainName, sourceStation, destinationStation, travelDate, departureTime, trainClasses, trainSeats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Train {\n");
    
    sb.append("    trainId: ").append(toIndentedString(trainId)).append("\n");
    sb.append("    trainName: ").append(toIndentedString(trainName)).append("\n");
    sb.append("    sourceStation: ").append(toIndentedString(sourceStation)).append("\n");
    sb.append("    destinationStation: ").append(toIndentedString(destinationStation)).append("\n");
    sb.append("    travelDate: ").append(toIndentedString(travelDate)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    trainClasses: ").append(toIndentedString(trainClasses)).append("\n");
    sb.append("    trainSeats: ").append(toIndentedString(trainSeats)).append("\n");
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

