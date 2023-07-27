package io.swagger.strategy;
import io.swagger.model.PeakTime;
import io.swagger.model.TrainClass;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketPriceCalculator {

    private TicketPriceStrategy offPeakTimePriceStrategy;
    private TicketPriceStrategy peakTimePriceStrategy;

    @Autowired
    public TicketPriceCalculator(OffPeakTimePriceStrategy offPeakTimeStrategy, PeakTimePriceStrategy peakTimeStrategy) {
        this.offPeakTimePriceStrategy = offPeakTimePriceStrategy;
        this.peakTimePriceStrategy = peakTimePriceStrategy;
    }

    public BigDecimal calculateTicketPrice(TrainClass trainClass, PeakTime peakTime) {
        if (peakTime == null) {
            return offPeakTimePriceStrategy.calculateTicketPrice(trainClass, peakTime);
        }
        return peakTimePriceStrategy.calculateTicketPrice(trainClass, peakTime);
    }
}
