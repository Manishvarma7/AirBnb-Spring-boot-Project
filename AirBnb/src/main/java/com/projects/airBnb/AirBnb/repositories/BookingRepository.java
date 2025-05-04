package com.projects.airBnb.AirBnb.repositories;

import com.projects.airBnb.AirBnb.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
