package io.swagger.service;

import io.swagger.model.PeakTime;
import io.swagger.repository.PeakTimeRepository;
import io.swagger.repository.TrainPeakTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PeakTimeService {

    private final PeakTimeRepository peakTimeRepository;
    private final TrainPeakTimeRepository trainPeakTimeRepository;

    @Autowired
    public PeakTimeService(PeakTimeRepository peakTimeRepository, TrainPeakTimeRepository trainPeakTimeRepository) {
        this.peakTimeRepository = peakTimeRepository;
        this.trainPeakTimeRepository = trainPeakTimeRepository;
    }

    public List<PeakTime> getAllPeakTimes() {
        return peakTimeRepository.findAll();
    }

    public Optional<PeakTime> getPeakTimeById(Integer peakTimeId) {
        return peakTimeRepository.findById(peakTimeId);
    }

    public PeakTime createOrUpdatePeakTime(PeakTime peakTime) {
        return peakTimeRepository.save(peakTime);
    }

    public boolean deletePeakTime(Integer peakTimeId) {
        boolean isPeakTimeUsedInTrain = checkIfPeakTimeInTrain(peakTimeId);

        if (isPeakTimeUsedInTrain) {
            return false;
        }
        else {
            peakTimeRepository.deleteById(peakTimeId);
            return true;
        }
    }

    public PeakTime findPeakTimeByTime(LocalTime givenTime){
        List<PeakTime> allPeakTimes = this.getAllPeakTimes();

        return allPeakTimes.stream()
                .filter(peakTime -> peakTime.getStartTime().compareTo(givenTime) <= 0
                        && peakTime.getEndTime().compareTo(givenTime) >= 0)
                .findFirst().orElse(null);
    }

    private boolean checkIfPeakTimeInTrain(Integer peakTimeId) {
        return trainPeakTimeRepository.existsByPeakTimePeakTimeId(peakTimeId);
    }
}
