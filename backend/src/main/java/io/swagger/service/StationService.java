package io.swagger.service;

import io.swagger.model.Station;
import io.swagger.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	public Optional<Station> getStationById(Integer stationId) {
		return stationRepository.findById(stationId);
	}

	public Station createOrUpdateStation(Station station) {
		Integer maxIdFromDatabase = stationRepository.findMaxStationId();
		int nextId = (maxIdFromDatabase != null) ? maxIdFromDatabase + 1 : 1;

		if (station.getStationId() == null) {
			station.setStationId(nextId);
		}
		return stationRepository.save(station);
	}

	public void deleteStation(Integer stationId) {
		stationRepository.deleteById(stationId);
	}
}