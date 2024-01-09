package com.nighthawk.spring_portfolio.mvc.car;

import jakarta.persistence.*;
import java.util.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
public class CarModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title; // Name of the car model
    private String date; // Release year of the car model

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "car_model_brand",
        joinColumns = @JoinColumn(name = "car_model_id"),
        inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private Set<Brand> brands = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "car_model_engine_type",
        joinColumns = @JoinColumn(name = "car_model_id"),
        inverseJoinColumns = @JoinColumn(name = "engine_type_id")
    )
    private Set<EngineType> engineTypes = new HashSet<>();

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> carFeatures; // Features like 0-60mph time, horsepower, etc.

    public CarModel() {
        this.brands = new HashSet<>();
        this.engineTypes = new HashSet<>();
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    public Set<EngineType> getEngineTypes() {
        return engineTypes;
    }

    public void setEngineTypes(Set<EngineType> engineTypes) {
        this.engineTypes = engineTypes;
    }

    public Map<String, Object> getCarFeatures() {
        return carFeatures;
    }

    public void setCarFeatures(Map<String, Object> carFeatures) {
        this.carFeatures = carFeatures;
    }

    // Add or remove a brand
    public void addBrand(Brand brand) {
        brands.add(brand);
        brand.getCarModels().add(this);
    }

    public void removeBrand(Brand brand) {
        brands.remove(brand);
        brand.getCarModels().remove(this);
    }

    // Add or remove an engine type
    public void addEngineType(EngineType engineType) {
        engineTypes.add(engineType);
        engineType.getCarModels().add(this);
    }

    public void removeEngineType(EngineType engineType) {
        engineTypes.remove(engineType);
        engineType.getCarModels().remove(this);
    }
}