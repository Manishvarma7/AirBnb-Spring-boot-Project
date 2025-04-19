package com.projects.airBnb.AirBnb.repositories;

import com.projects.airBnb.AirBnb.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
