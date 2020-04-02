package com.project.model;


import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


@Entity
public class Earthquake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Feature> features;

    public Earthquake(String type, List<Feature> features) {
        this.type = type;
        this.features=features;
    }
    public Earthquake() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "type='" + type + '\'' +
               ", features=" + features +
                '}';
    }

}