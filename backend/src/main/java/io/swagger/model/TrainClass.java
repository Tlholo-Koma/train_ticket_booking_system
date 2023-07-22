package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
    @ToString.Include
    @Column(name = "class_id")
    @JsonProperty("class_id")
    @ApiModelProperty(value = "")
    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    @ApiModelProperty(value = "")
    @ToString.Include
    private Train train;

    @ManyToOne
    @JoinColumn(name = "class_type_id", nullable = false)
    @ApiModelProperty(value = "")
    @ToString.Include
    private TrainClassType classType;

    @Column(name = "capacity", nullable = false)
    @ApiModelProperty(value = "")
    @ToString.Include
    private Integer capacity;

    @Column(name = "base_price", nullable = false)
    @ApiModelProperty(value = "")
    @ToString.Include
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
}
