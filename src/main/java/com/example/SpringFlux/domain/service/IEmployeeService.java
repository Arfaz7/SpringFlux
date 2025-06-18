package com.example.SpringFlux.domain.service;

import com.example.SpringFlux.domain.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
    Mono<Employee> create(Employee e);

    Mono<Employee> findById(Long id);

    Flux<Employee> findByName(String name);

    Flux<Employee> findAll();

    Mono<Employee> update(Employee e);

    Mono<Void> delete(Long id);
}
