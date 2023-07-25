package io.swagger.service;

import io.swagger.model.PeakTime;
import io.swagger.model.TrainClass;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketPriceCalculator {
    public BigDecimal calculateTicketPrice(TrainClass trainClass, PeakTime peakTime){
        if (peakTime == null) {
            return trainClass.getBasePrice();
        }
        return trainClass.getBasePrice().
                multiply(peakTime.getPriceIncreasePercentage());
    }
}
