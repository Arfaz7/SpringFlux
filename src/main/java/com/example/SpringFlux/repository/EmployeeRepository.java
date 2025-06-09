package com.example.SpringFlux.repository;

import com.example.SpringFlux.domain.model.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends R2dbcRepository<Employee, Long> {

    Flux<Employee> findByName(final String name);
}

