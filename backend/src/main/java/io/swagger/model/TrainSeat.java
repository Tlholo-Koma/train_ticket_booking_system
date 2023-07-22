package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Seat")
public class TrainSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "seat_id")
    @JsonProperty("seat_id")
    @ApiModelProperty(value = "")
    private Integer seatId;

    @Column(name = "train_id", nullable = false)
    @JsonProperty("train_id")
    @ApiModelProperty(value = "")
    private Integer trainId;

    @Column(name = "class_id", nullable = false)
    @JsonProperty("class_id")
    @ApiModelProperty(value = "")
    private Integer classId;

    @Column(name = "seat_type_id", nullable = false)
    @JsonProperty("seat_type_id")
    @ApiModelProperty(value = "")
    private Integer seatTypeId;

    @Column(name = "seat_number", nullable = false)
    @JsonProperty("seat_number")
    @ApiModelProperty(value = "")
    private String seatNumber;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TrainSeat {\n");

        sb.append("    seatId: ").append(toIndentedString(seatId)).append("\n");
        sb.append("    classId: ").append(toIndentedString(classId)).append("\n");
        sb.append("    seatNumber: ").append(toIndentedString(seatNumber)).append("\n");
        sb.append("    isBooked: ").append(toIndentedString(isBooked)).append("\n");
        //sb.append("    seatPrice: ").append(toIndentedString(seatPrice)).append("\n");
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
