package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Setter
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonProperty("booking_id")
    private Integer bookingId;

    @ToString.Include
    @JsonProperty("train_id")
    private Integer trainId = null;

    @ToString.Include
    @JsonProperty("train_name")
    private String trainName = null;

    @ToString.Include
    @JsonProperty("source_station")
    private String sourceStation = null;

    @ToString.Include
    @JsonProperty("destination_station")
    private String destinationStation = null;

    @ToString.Include
    @JsonProperty("travel_date")
    private LocalDate travelDate = null;

    @ToString.Include
    @JsonProperty("departure_time")
    private Time departureTime = null;

    @ToString.Include
    @JsonProperty("booking_date")
    private Date bookingDate = null;

    @ToString.Include
    @JsonProperty("ticket_price")
    private BigDecimal ticketPrice = null;

    @ToString.Include
    @JsonProperty("train_class")
    private String trainClass;

    @ToString.Include
    @JsonProperty("user_email")
    private String userEmail = null;

    @ToString.Include
    @JsonProperty("passengers")
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();
}

