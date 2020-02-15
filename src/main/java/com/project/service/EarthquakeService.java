package com.project.service;

import com.project.model.Earthquake;
import com.project.model.Property;
import com.project.repository.EarthquakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EarthquakeService {

    @Autowired
    EarthquakeRepository repository;
    private static final String ADDRESS_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
    private RestTemplate restTemplate = new RestTemplate();


    public Earthquake save() {
        Earthquake earthquake = getAllEarthquake();
        return repository.save(earthquake);

    }

    public List<Earthquake> getAll() {

        return repository.findAll();
    }

    public Earthquake getAllEarthquake() {

        ResponseEntity<Earthquake> responseEntity = restTemplate.exchange(ADDRESS_URL, HttpMethod.GET, null, Earthquake.class);
        Earthquake allEarthquake = responseEntity.getBody();

        return allEarthquake;
    }


    public List<Property> getPropertiesByCode(String code) {
        return repository.findAll().stream()
                .flatMap(x->x.getFeatures().stream())
                .map(x->x.getProperties())
                        .filter(y->y.getCode().equals(code))
                .collect(Collectors.toList());
    }
}
