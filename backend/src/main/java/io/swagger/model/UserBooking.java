package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "Booking")
public class UserBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    @JsonProperty("booking_id")
    private Integer bookingId;

    @JsonProperty("train_id")
    @Column(name = "train_id", nullable = false)
    private Integer trainId;

    @JsonProperty("user_email")
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @JsonProperty("booking_date")
    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @JsonProperty("ticket_price")
    @Column(name = "ticket_price", nullable = false)
    private BigDecimal ticketPrice;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();

    @JsonProperty("date_created")
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @JsonProperty("date_updated")
    @Column(name = "date_updated", nullable = false)
    private LocalDateTime dateUpdated;
}
