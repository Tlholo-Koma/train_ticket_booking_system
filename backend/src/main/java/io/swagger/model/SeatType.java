package io.swagger.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "SeatType")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonProperty("seat_type_id")
    private Integer seatTypeId;

    @ToString.Include
    @JsonProperty("seat_type_name")
    @Column(name = "seat_type_name", nullable = false)
    private String seatTypeName;

    @JsonProperty("created_by")
    @Column(name = "created_by", nullable = false)
    private String createdBy = "SYSTEM";

    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "date_updated", nullable = false)
    private LocalDate dateUpdated;
}
