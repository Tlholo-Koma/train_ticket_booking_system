package io.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.swagger.model.Station; // Importing Station model
import io.swagger.repository.StationRepository; // Importing StationRepository

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired; // Provides annotations for automatic dependency injection
import org.springframework.stereotype.Service; // Marks the class as a service component

import java.util.Date; // Provides classes for working with dates and times
import java.util.List; // Provides interfaces and classes for working with lists
import java.util.Optional; // Provides a container object which may or may not contain a non-null value

@Service
public class StationService {

    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<Station> getStationById(Integer id) {
        return stationRepository.findById(id);
    }

    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

    public Optional<Station> getStationByName(String stationName) {
        return stationRepository.findByStationName(stationName);
    }

    public List<Station> getStationsCreatedAfter(Date date) {
        return stationRepository.findStationsCreatedAfter(date);
    }

    public List<Station> getStationsUpdatedBefore(Date date) {
        return stationRepository.findStationsUpdatedBefore(date);
    }

    public void updateStationName(Integer stationId, String stationName) {
        stationRepository.updateStationName(stationId, stationName);
    }

    public void deleteStationByName(String stationName) {
        stationRepository.deleteStationByName(stationName);
    }

    public void deleteStationById(Integer stationId) {
        stationRepository.deleteStationById(stationId);
    }
}

