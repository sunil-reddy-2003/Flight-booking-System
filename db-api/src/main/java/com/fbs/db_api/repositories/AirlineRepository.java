package com.fbs.db_api.repositories;

import com.fbs.db_api.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, UUID> {

    @Query(nativeQuery = true, value ="SELECT * FROM airlines WHERE admin_id=:adminId" )
    public Airline getAirlineByAdminId(UUID adminId);

}
