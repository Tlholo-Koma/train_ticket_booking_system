package io.swagger.service;

import io.swagger.model.Booking;
import io.swagger.model.Passenger;
import io.swagger.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final PassengerService passengerService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, PassengerService passengerService) {
        this.bookingRepository = bookingRepository;
        this.passengerService = passengerService;
    }

//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }

    public Booking getBookingById(Integer ticketId) {
        Optional<Booking> ticketOptional = bookingRepository.findTicketDetailsById(ticketId);
        return ticketOptional.orElse(null);
    }

    public Booking createOrUpdateTrain(Booking booking) {
        // TODO: check seat availability
        booking = bookingRepository.save(booking);

        for (Passenger passenger : booking.getPassengers()) {
            passengerService.createOrUpdatePassenger(passenger);
        }

        return booking;
    }

    public void deleteBooking(Integer ticketId) {
        bookingRepository.deleteById(ticketId);
    }
}
