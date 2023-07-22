package io.swagger.service;

import io.swagger.model.TrainTicket;
import io.swagger.repository.TrainTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTicketService {
    private final TrainTicketRepository trainTicketRepository;

    @Autowired
    public TrainTicketService(TrainTicketRepository trainTicketRepository) {
        this.trainTicketRepository = trainTicketRepository;
    }

    public List<TrainTicket> getAllTrainTickets() {
        return trainTicketRepository.findAll();
    }

    public TrainTicket getTrainTicketById(Integer ticketId) {
        return trainTicketRepository.findById(ticketId).orElse(null);
    }

    public TrainTicket createTrainTicket(TrainTicket trainTicket) {
        return trainTicketRepository.save(trainTicket);
    }

    public void deleteTrainTicket(Integer ticketId) {
        trainTicketRepository.deleteById(ticketId);
    }
}
