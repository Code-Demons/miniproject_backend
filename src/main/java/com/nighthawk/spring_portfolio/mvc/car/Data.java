package com.nighthawk.spring_portfolio.mvc.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.HashSet;

@Configuration
public class Data {
    
    @Bean
    CommandLineRunner initDatabase(CarModelJpaRepository carModelRepo, BrandJpaRepository brandRepo, EngineTypeJpaRepository engineTypeRepo) {
        return args -> {
            // Creating some brands
            Brand brandMercedes = new Brand();
            brandMercedes.setName("Mercedes");
            Brand brandBMW = new Brand();
            brandBMW.setName("BMW");
            Brand brandToyota = new Brand();
            brandToyota.setName("Toyota");
            // Save brands
            brandRepo.save(brandMercedes);
            brandRepo.save(brandBMW);
            brandRepo.save(brandToyota);

            // Creating some engine types
            EngineType engineTypeDiesel = new EngineType();
            engineTypeDiesel.setName("Diesel");
            EngineType engineTypePetrol = new EngineType();
            engineTypePetrol.setName("Petrol");
            EngineType engineTypeElectric = new EngineType();
            engineTypeElectric.setName("Electric");
            // Save engine types
            engineTypeRepo.save(engineTypeDiesel);
            engineTypeRepo.save(engineTypePetrol);
            engineTypeRepo.save(engineTypeElectric);

            // Creating some car models
            CarModel carModel1 = new CarModel();
            carModel1.setTitle("Mercedes-Benz C-Class");
            carModel1.setDate("2021");
            carModel1.setCarFeatures(new HashMap<>() {{
                put("0-60mph", 5.7);
                put("horsepower", 255);
            }});
            carModel1.getBrands().add(brandMercedes);
            carModel1.getEngineTypes().add(engineTypePetrol);

            CarModel carModel2 = new CarModel();
            carModel2.setTitle("BMW 3 Series");
            carModel2.setDate("2022");
            carModel2.setCarFeatures(new HashMap<>() {{
                put("0-60mph", 5.3);
                put("horsepower", 255);
            }});
            carModel2.getBrands().add(brandBMW);
            carModel2.getEngineTypes().add(engineTypeDiesel);

            CarModel carModel3 = new CarModel();
            carModel3.setTitle("Toyota Prius");
            carModel3.setDate("2020");
            carModel3.setCarFeatures(new HashMap<>() {{
                put("0-60mph", 10.5);
                put("horsepower", 121);
            }});
            carModel3.getBrands().add(brandToyota);
            carModel3.getEngineTypes().add(engineTypeElectric);

            // Save car models
            carModelRepo.save(carModel1);
            carModelRepo.save(carModel2);
            carModelRepo.save(carModel3);
        };
    }
}