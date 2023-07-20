package io.swagger.repository;

import io.swagger.model.Station;  // Importing the Station entity model
import org.springframework.data.jpa.repository.JpaRepository;  // Spring Data JPA repository interface
import org.springframework.data.jpa.repository.Modifying;  // Annotation for modifying queries
import org.springframework.data.jpa.repository.Query;  // Annotation for custom queries
import org.springframework.stereotype.Repository;  // Annotation indicating that this interface is a repository

import javax.transaction.Transactional;  // Transactional annotation for managing transactions
import java.util.Date;  // Importing Date class
import java.util.List;  // Importing List interface
import java.util.Optional;  // Importing Optional class for handling nullable results

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

    Optional<Station> findById(Integer id);

    Optional<Station> findByStationName(String stationName);

    @Query("SELECT s FROM Station s WHERE s.dateCreated > :date")
    List<Station> findStationsCreatedAfter(Date date);

    @Query("SELECT s FROM Station s WHERE s.dateUpdated < :date")
    List<Station> findStationsUpdatedBefore(Date date);

    @Modifying
    @Transactional
    @Query("UPDATE Station s SET s.stationName = :stationName WHERE s.stationId = :stationId")
    void updateStationName(Integer stationId, String stationName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Station s WHERE s.stationName = :stationName")
    void deleteStationByName(String stationName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Station s WHERE s.stationId = :stationId")
    void deleteStationById(Integer stationId);

}
