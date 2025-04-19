package com.projects.airBnb.AirBnb.repositories;

import com.projects.airBnb.AirBnb.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
