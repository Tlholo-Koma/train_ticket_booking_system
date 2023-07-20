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
 * PeakTime
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")


public class PeakTime   {
  @JsonProperty("peak_time_id")
  private Integer peakTimeId = null;

  @JsonProperty("start_time")
  private String startTime = null;

  @JsonProperty("end_time")
  private String endTime = null;

  @JsonProperty("price_increase_percentage")
  private BigDecimal priceIncreasePercentage = null;

  public PeakTime peakTimeId(Integer peakTimeId) {
    this.peakTimeId = peakTimeId;
    return this;
  }

  /**
   * Get peakTimeId
   * @return peakTimeId
  **/
  @ApiModelProperty(value = "")


  public Integer getPeakTimeId() {
    return peakTimeId;
  }

  public void setPeakTimeId(Integer peakTimeId) {
    this.peakTimeId = peakTimeId;
  }

  public PeakTime startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(value = "")


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public PeakTime endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(value = "")


  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public PeakTime priceIncreasePercentage(BigDecimal priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

  /**
   * Get priceIncreasePercentage
   * @return priceIncreasePercentage
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }

  public void setPriceIncreasePercentage(BigDecimal priceIncreasePercentage) {
    this.priceIncreasePercentage = priceIncreasePercentage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeakTime peakTime = (PeakTime) o;
    return Objects.equals(this.peakTimeId, peakTime.peakTimeId) &&
        Objects.equals(this.startTime, peakTime.startTime) &&
        Objects.equals(this.endTime, peakTime.endTime) &&
        Objects.equals(this.priceIncreasePercentage, peakTime.priceIncreasePercentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(peakTimeId, startTime, endTime, priceIncreasePercentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeakTime {\n");
    
    sb.append("    peakTimeId: ").append(toIndentedString(peakTimeId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
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

