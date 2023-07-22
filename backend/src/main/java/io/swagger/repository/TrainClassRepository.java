package io.swagger.repository;

import io.swagger.model.TrainClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainClassRepository extends JpaRepository<TrainClass, Integer> {

    @Query(value = "SELECT MAX(class_id) FROM TrainClass", nativeQuery = true)
    Integer findMaxClassId();
}
