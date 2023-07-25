package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "seattype")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonProperty("seat_type_id")
    @ApiModelProperty(value = "")
    private Integer seatTypeId;

    @Column(name = "seat_type_name", nullable = false)
    @ToString.Include
    @JsonProperty("seat_type_name")
    @ApiModelProperty(value = "")
    private String seatTypeName;

    @Column(name = "created_by", nullable = false)
    @JsonIgnore
    private String createdBy = "SYSTEM";

    @Column(name = "date_created", nullable = false)
    @JsonIgnore
    private Date dateCreated;

    @Column(name = "date_updated", nullable = false)
    @JsonIgnore
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
