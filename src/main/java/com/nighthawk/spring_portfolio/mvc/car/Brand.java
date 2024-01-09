package com.nighthawk.spring_portfolio.mvc.car;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "brands", fetch = FetchType.EAGER)
    private Set<CarModel> carModels = new HashSet<>();

    public Brand() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(Set<CarModel> carModels) {
        this.carModels = carModels;
    }
}