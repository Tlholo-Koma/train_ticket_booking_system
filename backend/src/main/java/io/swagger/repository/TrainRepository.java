package io.swagger.repository;

import io.swagger.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

    @Query(value = "SELECT MAX(train_id) FROM Train", nativeQuery = true)
    Integer findMaxTrainId();
}
