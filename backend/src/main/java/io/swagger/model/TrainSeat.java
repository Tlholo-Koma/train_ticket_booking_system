package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "Seat")
public class TrainSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(name = "seat_id")
    @JsonProperty("seat_id")
    @ApiModelProperty(value = "")
    private Integer seatId;

    @ToString.Include
    @Column(name = "train_id", nullable = false)
    @JsonProperty("train_id")
    @ApiModelProperty(value = "")
    private Integer trainId;

    @ToString.Include
    @Column(name = "class_id", nullable = false)
    @JsonProperty("class_id")
    @ApiModelProperty(value = "")
    private Integer classId;

    @ToString.Include
    @Column(name = "seat_type_id", nullable = false)
    @JsonProperty("seat_type_id")
    @ApiModelProperty(value = "")
    private Integer seatTypeId;

    @ToString.Include
    @Column(name = "seat_number", nullable = false)
    @JsonProperty("seat_number")
    @ApiModelProperty(value = "")
    private String seatNumber;

    @ToString.Include
    @Column(name = "is_booked", nullable = false)
    @JsonProperty("is_booked")
    @ApiModelProperty(value = "")
    private boolean isBooked;

    @Column(name = "date_created", nullable = false)
    @ApiModelProperty(value = "")
    private LocalDateTime dateCreated;

    @Column(name = "date_updated", nullable = false)
    @ApiModelProperty(value = "")
    private LocalDateTime dateUpdated;
}
