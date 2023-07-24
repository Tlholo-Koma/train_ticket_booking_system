package io.swagger.repository;

import io.swagger.model.UserBooking;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookingRepository extends JpaRepository<UserBooking, Integer> {

	@Query(value = "SELECT MAX(booking_id) FROM Booking", nativeQuery = true)
    Integer findMaxBookingId();

    boolean existsByTrainId(Integer trainId);
}
