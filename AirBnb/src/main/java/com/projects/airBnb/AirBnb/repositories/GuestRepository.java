package com.projects.airBnb.AirBnb.repositories;


import com.projects.airBnb.AirBnb.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}