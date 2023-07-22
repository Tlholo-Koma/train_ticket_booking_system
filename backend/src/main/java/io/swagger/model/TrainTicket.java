package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "TrainTicket")
public class TrainTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonProperty("ticket_id")
    private Integer ticketId;

    @JsonProperty("train_name")
    @Column(name = "train_name")
    private String trainName;

    @JsonProperty("source_station")
    @Column(name = "source_station")
    private String sourceStation;

    @JsonProperty("destination_station")
    @Column(name = "destination_station")
    private String destinationStation;

    @JsonProperty("travel_date")
    @Column(name = "travel_date")
    private LocalDate travelDate;

    @JsonProperty("departure_time")
    @Column(name = "departure_time")
    private String departureTime;

    @JsonProperty("booking_id")
    @Column(name = "booking_id")
    private Integer bookingId;

    @JsonProperty("booking_date")
    @Column(name = "booking_date")
    private String bookingDate;

    @JsonProperty("ticket_price")
    @Column(name = "ticket_price")
    private BigDecimal ticketPrice;

    @JsonProperty("train_class")
    @Column(name = "train_class")
    private String trainClass;

    @JsonProperty("user_email")
    @Column(name = "user_email")
    private String userEmail;

    @OneToMany(mappedBy = "trainTicket", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();

    @Column(name = "created_by")
    private final String createdBy = "SYSTEM";

    @JsonProperty("date_created")
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @JsonProperty("date_updated")
    @Column(name = "date_updated", nullable = false)
    private LocalDate dateUpdated;

}

