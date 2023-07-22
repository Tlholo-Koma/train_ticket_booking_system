package io.swagger.service;

import io.swagger.model.UserBooking;
import io.swagger.repository.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserBookingService {

    private final UserBookingRepository userBookingRepository;

    @Autowired
    public UserBookingService(UserBookingRepository userBookingRepository) {
        this.userBookingRepository = userBookingRepository;
    }

    public List<UserBooking> getAllBookings() {
        return userBookingRepository.findAll();
    }

    public Optional<UserBooking> getBookingById(Integer bookingId) {
        return userBookingRepository.findById(bookingId);
    }

    public UserBooking createOrUpdateBooking(UserBooking booking) {
        Integer maxIdFromDatabase = userBookingRepository.findMaxBookingId();
        int nextId = (maxIdFromDatabase != null) ? maxIdFromDatabase + 1 : 1;

        if (booking.getBookingId() == null) {
            booking.setBookingId(nextId);
        }
        return userBookingRepository.save(booking);
    }

    public void deleteBooking(Integer bookingId) {
        userBookingRepository.deleteById(bookingId);
    }
}
