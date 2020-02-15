package com.project.repository;

import com.project.model.Earthquake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EarthquakeRepository extends JpaRepository<Earthquake, Long> {
    Earthquake findById(String id);


}