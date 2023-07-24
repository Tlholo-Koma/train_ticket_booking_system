package io.swagger.service;

import io.swagger.model.Train;
import io.swagger.model.TrainClass;
import io.swagger.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;
import java.util.Optional;


@Service
public class TrainService {

    private final TrainRepository trainRepository;
    private final TrainClassService trainClassService;
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public TrainService(TrainRepository trainRepository, TrainClassService trainClassService, JdbcTemplate jdbcTemplate) {
        this.trainRepository = trainRepository;
        this.trainClassService = trainClassService;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Optional<Train> getTrainById(Integer trainId) {
        return trainRepository.findById(trainId);
    }
    
    public Train createOrUpdateTrain(Train train) {
    	train = trainRepository.save(train);

        for (TrainClass trainClass: train.getTrainClasses()) {
            trainClass.setTrain(train);
            trainClass = trainClassService.createOrUpdateTrainClass(trainClass);
        }

        callAddSeatsStoredProcedure(train.getTrainId());

        return train;
    }

    public void deleteTrain(Integer trainId) {
        trainRepository.deleteById(trainId);
    }

    private void callAddSeatsStoredProcedure(int trainId) {
        String storedProcedureCall = "{call AddSeats(?)}";

        jdbcTemplate.update(storedProcedureCall, trainId);
    }
}
