package com.nighthawk.spring_portfolio.mvc.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<Brand, Long> {
}