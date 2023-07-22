package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TrainClass")
public class TrainClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "class_id")
    @JsonProperty("class_id")
    @ApiModelProperty(value = "")
    private Integer classId;

    @Column(name = "train_id", nullable = false)
    @JsonProperty("train_id")
    @ApiModelProperty(value = "")
    private Integer trainId;

    @ManyToOne
    @JoinColumn(name = "class_type_id", nullable = false)
    @ApiModelProperty(value = "")
    private TrainClassType classType;

    @Column(name = "capacity", nullable = false)
    @ApiModelProperty(value = "")
    private Integer capacity;

    @Column(name = "base_price", nullable = false)
    @ApiModelProperty(value = "")
    private BigDecimal basePrice;

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false)
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TrainClass {\n");

        sb.append("    classType: ").append(toIndentedString(classType)).append("\n");
        sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
        sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
