package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "seattype")
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

    @Column(name = "created_by", nullable = false)
    @JsonIgnore
    private String createdBy = "SYSTEM";

    @Column(name = "date_created", nullable = false)
    @JsonIgnore
    private LocalDate dateCreated;

    @Column(name = "date_updated", nullable = false)
    @JsonIgnore
    private LocalDate dateUpdated;
}
