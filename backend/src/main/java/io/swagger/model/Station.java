package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Station
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")


public class Station   {
  @JsonProperty("station_id")
  private Integer stationId = null;

  @JsonProperty("station_name")
  private String stationName = null;

  public Station stationId(Integer stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * Get stationId
   * @return stationId
  **/
  @ApiModelProperty(value = "")


  public Integer getStationId() {
    return stationId;
  }

  public void setStationId(Integer stationId) {
    this.stationId = stationId;
  }

  public Station stationName(String stationName) {
    this.stationName = stationName;
    return this;
  }

  /**
   * Get stationName
   * @return stationName
  **/
  @ApiModelProperty(value = "")


  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Station station = (Station) o;
    return Objects.equals(this.stationId, station.stationId) &&
        Objects.equals(this.stationName, station.stationName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationId, stationName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Station {\n");
    
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    stationName: ").append(toIndentedString(stationName)).append("\n");
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

