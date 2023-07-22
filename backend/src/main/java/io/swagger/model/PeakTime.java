package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "peaktimes")
public class PeakTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @JsonProperty("peak_time_id")
    @ApiModelProperty(value = "")
    @ToString.Include
    private Integer peakTimeId;

    @Column(name = "start_time", nullable = false)
    @JsonProperty("start_time")
    @ApiModelProperty(value = "")
    @ToString.Include
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    @JsonProperty("end_time")
    @ApiModelProperty(value = "")
    @ToString.Include
    private LocalTime endTime;

    @Column(name = "price_increase_percentage", nullable = false)
    @JsonProperty("price_increase_percentage")
    @ToString.Include
    private Double priceIncreasePercentage;

    @Column(name = "created_by", nullable = false)
    private final String createdBy = "SYSTEM";

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
