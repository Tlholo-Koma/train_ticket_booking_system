package io.swagger.service;

import io.swagger.model.Train;
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
        Integer maxIdFromDatabase = trainRepository.findMaxTrainId();
        int nextId = (maxIdFromDatabase != null) ? maxIdFromDatabase + 1 : 1;

        if (train.getTrainId() == null) {
            train.setTrainId(nextId);
        }
        return trainRepository.save(train);
    }

    public void deleteTrain(Integer trainId) {
        trainRepository.deleteById(trainId);
    }
}
