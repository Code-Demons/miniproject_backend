package com.nighthawk.spring_portfolio.mvc.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelJpaRepository extends JpaRepository<CarModel, Long> {
}