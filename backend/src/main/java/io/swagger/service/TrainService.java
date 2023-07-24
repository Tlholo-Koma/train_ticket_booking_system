package io.swagger.service;

import io.swagger.model.Train;
import io.swagger.repository.StationRepository;
import io.swagger.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrainService {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Optional<Train> getTrainById(Integer trainId) {
        return trainRepository.findById(trainId);
    }
    
    public Train createOrUpdateTrain(Train train) {
    	trainRepository.save(train);
        return train;
    }

    public void deleteTrain(Integer trainId) {
        trainRepository.deleteById(trainId);
    }
}
