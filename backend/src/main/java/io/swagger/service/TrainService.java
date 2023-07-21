package io.swagger.service;

import io.swagger.model.Train;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {
    public List<Train> getAllTrains() {
        List<Train> trains = new ArrayList<>();

        Train train1 = new Train();
        train1.setTrainId(1);
        train1.setTrainName("Toon Express");
        train1.setSourceStation("Centurion");
        train1.setDestinationStation("Park");
        train1.setTravelDate(Date.valueOf("2023-07-17"));
        train1.setDepartureTime("09:00:00");
        trains.add(train1);

        Train train2 = new Train();
        train2.setTrainId(2);
        train2.setTrainName("Jungle Express");
        train2.setSourceStation("Centurion");
        train2.setDestinationStation("Hatfield");
        train2.setTravelDate(Date.valueOf("2023-07-27"));
        train2.setDepartureTime("09:00:00");
        trains.add(train2);

        Train train3 = new Train();
        train3.setTrainId(3);
        train3.setTrainName("Jungle Express");
        train3.setSourceStation("Centurion");
        train3.setDestinationStation("Park");
        train3.setTravelDate(Date.valueOf("2023-07-27"));
        train3.setDepartureTime("12:00:00");
        trains.add(train3);

        return trains;
    }
}
