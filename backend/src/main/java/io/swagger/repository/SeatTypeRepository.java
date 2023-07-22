package io.swagger.repository;

import io.swagger.model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Integer> {

    @Query("SELECT MAX(st.seatTypeId) FROM SeatType st")
    Integer findMaxSeatTypeId();
}
