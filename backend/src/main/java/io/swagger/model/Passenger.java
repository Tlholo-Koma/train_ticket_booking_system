package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

//	@JsonProperty("booking_id")
//	@Column(name = "booking_id")
//	private Integer bookingId;

//	@JsonProperty("seat_id")
//	@Column(name = "seat_id")
//	private Integer seatId;

	@JsonProperty("passenger_name")
	@ToString.Include
	@Column(name = "passenger_name", nullable = false)
	private String passengerName;
	
//	@ManyToOne
//	@JoinColumn(name = "booking_id", insertable = false, updatable = false)
//	private UserBooking booking;

	@JsonProperty("passenger_age")
	@ToString.Include
	@Column(name = "age")
	private Integer age;


//	@JsonProperty("date_created")
//	@Column(name = "date_created", nullable = false)
//	private LocalDate dateCreated;

//	@JsonProperty("date_updated")
//	@Column(name = "date_updated", nullable = false)
//	private LocalDate dateUpdated;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	@JsonIgnore
	private Booking ticket;
}
