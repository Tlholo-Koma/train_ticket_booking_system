package io.swagger.repository;

import io.swagger.model.TrainTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainTicketRepository extends JpaRepository<TrainTicket, Integer> {
}