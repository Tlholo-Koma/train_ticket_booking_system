package io.swagger.service;

import io.swagger.model.*;
import io.swagger.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final PassengerService passengerService;
    private final TrainService trainService;
    private final TrainClassService trainClassService;
    private final TicketPriceCalculator ticketPriceCalculator;
    private final TrainSeatService trainSeatService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, PassengerService passengerService, TrainService trainService,
                          TrainClassService trainClassService, TicketPriceCalculator ticketPriceCalculator,
                          TrainSeatService trainSeatService) {
        this.bookingRepository = bookingRepository;
        this.passengerService = passengerService;
        this.trainService = trainService;
        this.trainClassService = trainClassService;
        this.ticketPriceCalculator = ticketPriceCalculator;
        this.trainSeatService = trainSeatService;
    }

    public Booking getBookingById(Integer bookingId) {
        Booking booking = bookingRepository.findBookingByBookingId(bookingId).orElse(null);
        return populateTrainSeatsForBooking(booking);
    }

    public Booking createOrUpdateTrain(Booking booking) {
        // set train details
        Train train = trainService.getTrainById(booking.getTrainId());
        booking.setTrainName(train.getTrainName());
        booking.setSourceStation(train.getSourceStation().getStationName());
        booking.setDestinationStation(train.getDestinationStation().getStationName());
        booking.setTravelDate(train.getTravelDate());
        booking.setDepartureTime(train.getDepartureTime());

        // get train class
        TrainClass trainClass = trainClassService.getTrainClassByTrainClassType(booking.getTrainClass(), booking.getTrainId());

        // TODO: add peak time
        // is peak time
        PeakTime peakTime = null;

        // number of passengers
        Integer numberOfPassengers = booking.getPassengers().size();

        // Calculate ticket price
        BigDecimal seatPrice = ticketPriceCalculator.calculateTicketPrice(trainClass, peakTime);

        // add ticket price
        booking.setTicketPrice(seatPrice.multiply(BigDecimal.valueOf(numberOfPassengers)));

        int numOfSeats = train.getTrainSeats().size();

        // check seat availability
        if (numOfSeats >= numberOfPassengers) {
            int seatNumber = 0;
            for (int i = 0; i < numberOfPassengers; i++) {
                Passenger passenger = booking.getPassengers().get(i);
                TrainSeat trainSeat = train.getTrainSeats().get(seatNumber);

                if (!trainSeat.isBooked()) {
                    trainSeat.setBooked(true);
                    trainSeat.setSeatPrice(seatPrice);

                    // TODO: set passenger seat
                    //passenger.setSeat(trainSeat);

                    // Save the updated seat in the repository.
                    trainSeatService.createOrUpdateTrainSeat(trainSeat);
                }
                else {
                    i = i - 1;
                }
                seatNumber += 1;
            }
        }
        else {
            return null;
        }

        Integer bookingId = bookingRepository.insertBooking(booking.getBookingDate(), train.getTrainId(), booking.getTicketPrice(), booking.getUserEmail());

//        for (Passenger passenger : booking.getPassengers()) {
            //passenger.set
//            passengerService.createOrUpdatePassenger(passenger);
//        }

        return booking;
    }

    public void deleteBooking(Integer bookingId, Booking booking) {
        for (Passenger passenger : booking.getPassengers()) {
            // TODO: set is_booked is false, set seat_price to null
            passengerService.deletePassenger(passenger.getPassengerId());
        }
        bookingRepository.deleteById(bookingId);
    }

    public List<Booking> getBookingByUserEmail(String userEmail) {
        List<Booking> bookings = bookingRepository.findByUserEmail(userEmail).orElse(null);
        return populateTrainSeatsForBookings(bookings);
    }

    private List<Booking> populateTrainSeatsForBookings(List<Booking> bookings) {
        if (bookings != null) {
            for (Booking booking : bookings) {
                populateTrainSeatsForBooking(booking);
            }
        }
        return bookings;
    }

    private Booking populateTrainSeatsForBooking(Booking booking) {
        if (booking != null) {
            for (Passenger passenger : booking.getPassengers()) {
                Integer seatId = passenger.getSeatId();

                List<TrainSeat> trainSeats = new ArrayList<>();
                trainSeats.add(trainSeatService.getTrainSeatById(seatId));
                passenger.setSeats(trainSeats);
            }
        }
        return booking;
    }

}
