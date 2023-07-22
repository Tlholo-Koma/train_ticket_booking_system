package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TrainClassType")
public class TrainClassType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "class_type_id")
    @JsonProperty("class_type_id")
    @ApiModelProperty(value = "")
    private Integer classTypeId;

    @Column(name = "class_type_name", nullable = false)
    @JsonProperty("class_type_name")
    @ApiModelProperty(value = "")
    private String classTypeName;

    @Column(name = "created_by", nullable = false)
    @JsonProperty("created_by")
    @ApiModelProperty(value = "")
    private final String createdBy ="SYSTEM";

    @Column(name = "date_created", nullable = false)
    @JsonProperty("date_created")
    @ApiModelProperty(value = "")
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false)
    @JsonProperty("date_updated")
    @ApiModelProperty(value = "")
    private Date dateUpdated;
    
    @PrePersist
    protected void onCreate() {
      dateCreated = new Date();
      dateUpdated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
      dateUpdated = new Date();
    }
}
