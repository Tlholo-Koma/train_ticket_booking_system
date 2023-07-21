package io.swagger.service;

import io.swagger.model.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {
    public List<Station> getAllStations() {
        return new ArrayList<>();
    }

    public Station getStationById(Integer stationId) {
        return null;
    }

    public Station updateStationById (Integer stationId, Station station) {
        return null;
    }

    public Station deleteStationById (Integer stationId) {
        return null;
    }

    public boolean addStation(Station station) {
        return false;
    }
}
