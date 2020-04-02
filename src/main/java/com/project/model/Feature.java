package com.project.model;

import javax.persistence.*;

@Entity
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Property properties;
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Geometry geometry;

    public Feature(Property properties, Geometry geometry) {
        this.properties = properties;
        this.geometry = geometry;
    }

    public Feature() {
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
