package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * TrainClass
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:56:46.917+02:00")


public class TrainClass   {
  @JsonProperty("train_class_type")
  private String trainClassType = null;

  @JsonProperty("capacity")
  private Integer capacity = null;

  @JsonProperty("base_price")
  private BigDecimal basePrice = null;

  public TrainClass trainClassType(String trainClassType) {
    this.trainClassType = trainClassType;
    return this;
  }

  /**
   * Get trainClassType
   * @return trainClassType
  **/
  @ApiModelProperty(value = "")


  public String getTrainClassType() {
    return trainClassType;
  }

  public void setTrainClassType(String trainClassType) {
    this.trainClassType = trainClassType;
  }

  public TrainClass capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Get capacity
   * @return capacity
  **/
  @ApiModelProperty(value = "")


  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public TrainClass basePrice(BigDecimal basePrice) {
    this.basePrice = basePrice;
    return this;
  }

  /**
   * Get basePrice
   * @return basePrice
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(BigDecimal basePrice) {
    this.basePrice = basePrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrainClass trainClass = (TrainClass) o;
    return Objects.equals(this.trainClassType, trainClass.trainClassType) &&
        Objects.equals(this.capacity, trainClass.capacity) &&
        Objects.equals(this.basePrice, trainClass.basePrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trainClassType, capacity, basePrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainClass {\n");
    
    sb.append("    trainClassType: ").append(toIndentedString(trainClassType)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
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

