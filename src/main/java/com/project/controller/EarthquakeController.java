package com.project.controller;

import com.project.model.Earthquake;
import com.project.model.Property;
import com.project.service.EarthquakeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EarthquakeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    EarthquakeService service;


    @PostMapping("/save")
    public Earthquake save() {
        log.info("Saving earthquake details in the database.");

        return service.save();
    }


    @GetMapping("/earthquake")
    List<Earthquake> all() {

        return service.getAll();
    }

    @GetMapping("/earthquake/{code}")
    List<Property> getPropertiesByCode(@PathVariable String code) {

        return service.getPropertiesByCode(code);
    }
}
