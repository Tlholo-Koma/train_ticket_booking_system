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
 * TrainClassType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-07-20T12:33:10.367+02:00")


public class TrainClassType   {
  @JsonProperty("train_class_id")
  private Integer trainClassId = null;

  @JsonProperty("train_class_name")
  private String trainClassName = null;

  public TrainClassType trainClassId(Integer trainClassId) {
    this.trainClassId = trainClassId;
    return this;
  }

  /**
   * Get trainClassId
   * @return trainClassId
  **/
  @ApiModelProperty(value = "")


  public Integer getTrainClassId() {
    return trainClassId;
  }

  public void setTrainClassId(Integer trainClassId) {
    this.trainClassId = trainClassId;
  }

  public TrainClassType trainClassName(String trainClassName) {
    this.trainClassName = trainClassName;
    return this;
  }

  /**
   * Get trainClassName
   * @return trainClassName
  **/
  @ApiModelProperty(value = "")


  public String getTrainClassName() {
    return trainClassName;
  }

  public void setTrainClassName(String trainClassName) {
    this.trainClassName = trainClassName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrainClassType trainClassType = (TrainClassType) o;
    return Objects.equals(this.trainClassId, trainClassType.trainClassId) &&
        Objects.equals(this.trainClassName, trainClassType.trainClassName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trainClassId, trainClassName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainClassType {\n");
    
    sb.append("    trainClassId: ").append(toIndentedString(trainClassId)).append("\n");
    sb.append("    trainClassName: ").append(toIndentedString(trainClassName)).append("\n");
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

