package io.swagger.service;

import io.swagger.model.Train;
import io.swagger.model.Station;
import io.swagger.model.TrainClass;
import io.swagger.model.TrainClassType;
import io.swagger.repository.StationRepository;
import io.swagger.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    private final TrainRepository trainRepository;
    private final StationService stationService;
    private final TrainClassTypeService trainClassTypeService;
    private final TrainClassService trainClassService;

    @Autowired
    public TrainService(TrainRepository trainRepository, StationService stationService, TrainClassTypeService trainClassTypeService, TrainClassService trainClassService) {
        this.trainRepository = trainRepository;
        this.stationService = stationService;
        this.trainClassTypeService = trainClassTypeService;
        this.trainClassService = trainClassService;
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

        // Get the Station objects for source_station and destination_station
        String sourceStationName = train.getSourceStation().getStationName();
        String destinationStationName = train.getDestinationStation().getStationName();

        Station sourceStation = stationService.getStationByName(sourceStationName);
        Station destinationStation = stationService.getStationByName(destinationStationName);

        train.setSourceStation(sourceStation);
        train.setDestinationStation(destinationStation);

        // Save or associate the TrainClassType entities
        for (TrainClass trainClass : train.getTrainClasses()) {
            trainClass.setTrainId(train.getTrainId());
            TrainClassType classType = trainClass.getClassType();
            if (classType != null) {
                // get the TrainClassType id
                TrainClassType existingClassType = trainClassTypeService.getTrainClassTypeByName(classType.getClassTypeName());
                if (existingClassType != null) {
                    trainClass.setClassType(existingClassType);
                }
            }
        }

        train = trainRepository.save(train);

        for (TrainClass trainClass : train.getTrainClasses()) {
            // insert the TrainClass
            trainClass = trainClassService.createOrUpdateTrainClass(trainClass);
        }

        return train;
    }

    public void deleteTrain(Integer trainId) {
        trainRepository.deleteById(trainId);
    }
}
