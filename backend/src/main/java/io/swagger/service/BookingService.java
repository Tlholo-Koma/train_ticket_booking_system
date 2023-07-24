package io.swagger.service;

import io.swagger.model.Booking;
import io.swagger.model.Passenger;
import io.swagger.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Booking getBookingById(Integer bookingId) {
        return bookingRepository.findBookingByBookingId(bookingId).orElse(null);
    }

    public Booking createOrUpdateTrain(Booking booking) {
        // TODO: check seat availability
        booking = bookingRepository.save(booking);

        for (Passenger passenger : booking.getPassengers()) {
            passengerService.createOrUpdatePassenger(passenger);
        }

        return booking;
    }

    public void deleteBooking(Integer bookingId, Booking booking) {
        for (Passenger passenger : booking.getPassengers()) {
            // TODO: set is_booked is false, set seat_price to null 
            passengerService.deletePassenger(passenger.getPassengerId());
        }
        bookingRepository.deleteById(bookingId);
    }
}
