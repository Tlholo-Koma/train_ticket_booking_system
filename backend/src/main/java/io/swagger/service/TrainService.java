package io.swagger.service;

import io.swagger.model.Train;
import io.swagger.model.TrainClass;
import io.swagger.model.TrainSeat;
import io.swagger.repository.TrainRepository;
import io.swagger.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;
import java.util.Optional;


@Service
public class TrainService {

    private final BookingRepository bookingRepository;
    private final TrainRepository trainRepository;
    private final TrainClassService trainClassService;
    private final TrainSeatService trainSeatService;
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public TrainService(BookingRepository bookingRepository, TrainRepository trainRepository,
                        TrainClassService trainClassService, TrainSeatService trainSeatService,
                        JdbcTemplate jdbcTemplate) {
        this.bookingRepository = bookingRepository;
        this.trainRepository = trainRepository;
        this.trainClassService = trainClassService;
        this.trainSeatService = trainSeatService;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train getTrainById(Integer trainId) {
        return trainRepository.findById(trainId).orElse(null);
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

    public boolean deleteTrain(Train train, Integer trainId) {
        boolean isTrainUsedInBooking = checkIfTrainUsedInBooking(trainId);

        if (isTrainUsedInBooking) {
            return false;
        }
        else {
            for (TrainClass trainClass : train.getTrainClasses()) {
                trainClassService.deleteTrainClass(trainClass.getClassId());
            }
            for (TrainSeat trainSeat : train.getTrainSeats()) {
                trainSeatService.deleteTrainSeat(trainSeat.getSeatId());
            }
            train.setTrainClasses(null);
            train.setTrainSeats(null);
            trainRepository.deleteById(trainId);
            return true;
        }
    }

    private boolean checkIfTrainUsedInBooking(Integer trainId) {
        return bookingRepository.existsByTrainId(trainId);
    }

    private void callAddSeatsStoredProcedure(int trainId) {
        String storedProcedureCall = "{call AddSeats(?)}";

        jdbcTemplate.update(storedProcedureCall, trainId);
    }
}
