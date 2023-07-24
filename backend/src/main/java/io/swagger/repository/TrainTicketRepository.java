package io.swagger.repository;

import io.swagger.model.TrainTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainTicketRepository extends JpaRepository<TrainTicket, Integer> {

    @Query(value = "SELECT " +
            "B.booking_id AS 'booking_id'" +
            ", B.train_id AS 'train_id'" +
            ", T.train_name AS 'train_name' " +
            ", S1.station_name AS 'source_station'" +
            ", S2.station_name AS 'destination_station' " +
            ", T.travel_date AS 'travel_date' " +
            ", T.departure_time AS 'departure_time' " +
            ", B.booking_date AS 'booking_date' " +
            ", B.ticket_price AS 'ticket_price' " +
            ", B.user_email AS 'user_email' " +
            ", TCT.class_type_name AS 'train_class' " +
            ", P.passenger_id AS 'passenger_id' " +
            ", P.passenger_name AS 'passenger_name' " +
            ", P.age AS 'passenger_age' " +
            //", S.seat_number AS  " +
            "FROM [Booking] as B " +
            "JOIN [Train] AS T ON T.train_id = B.train_id " +
            "JOIN [Station] AS S1 ON T.source_station = S1.station_id " +
            "JOIN [Station] AS S2 ON T.destination_station = S2.station_id " +
            "LEFT JOIN Passenger P ON P.booking_id = B.booking_id " +
            "LEFT JOIN Seat AS S ON P.seat_id = S.seat_id " +
            "LEFT JOIN TrainClass AS TC ON S.class_id = TC.class_id " +
            "LEFT JOIN TrainClassType AS TCT ON TC.class_type_id = TCT.class_type_id " +
            "WHERE B.booking_id = :bookingId", nativeQuery = true)
    Optional<TrainTicket> findTicketDetailsById(@Param("bookingId") Integer bookingId);
}