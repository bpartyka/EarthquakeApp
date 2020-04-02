package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Geometry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    public Geometry(String type) {
        this.type = type;
    }
    public Geometry() {

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}