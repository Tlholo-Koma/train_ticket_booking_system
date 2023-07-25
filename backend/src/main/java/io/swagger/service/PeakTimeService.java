package io.swagger.service;

import io.swagger.model.PeakTime;
import io.swagger.repository.PeakTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeakTimeService {

    private final PeakTimeRepository peakTimeRepository;

    @Autowired
    public PeakTimeService(PeakTimeRepository peakTimeRepository) {
        this.peakTimeRepository = peakTimeRepository;
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

    public void deletePeakTime(Integer peakTimeId) {
        peakTimeRepository.deleteById(peakTimeId);
    }
}
