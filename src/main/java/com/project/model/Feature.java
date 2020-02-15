package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    private Property properties;
    @OneToOne(cascade=CascadeType.ALL)
    private Geometry geometry;

    public Feature() {
    }

    public Feature(Property properties, Geometry geometry) {
        this.properties = properties;
        this.geometry = geometry;
    }

    public Property getProperties() {
        return properties;
    }

    public void setProperties(Property properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "properties=" + properties +
                ", geometry=" + geometry +
                '}';
    }
}
