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
@Table(name = "Passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@ToString.Include
	@JsonProperty("passenger_id")
	private Integer passengerId;

	@JsonProperty("booking_id")
	@Column(name = "booking_id")
	private Integer bookingId;

	@JsonProperty("seat_id")
	@Column(name = "seat_id")
	private Integer seatId;

	@JsonProperty("passenger_name")
	@Column(name = "passenger_name", nullable = false)
	private String passengerName;
	
	@ManyToOne
	@JoinColumn(name = "booking_id", insertable = false, updatable = false)
	private UserBooking booking;

	@JsonProperty("age")
	@Column(name = "age")
	private Integer age;

	@JsonProperty("date_created")
	@Column(name = "date_created", nullable = false)
	private LocalDate dateCreated;

	@JsonProperty("date_updated")
	@Column(name = "date_updated", nullable = false)
	private LocalDate dateUpdated;
}
