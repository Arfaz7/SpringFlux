package com.example.SpringFlux.domain.service;

import com.example.SpringFlux.domain.model.Employee;
import com.example.SpringFlux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Mono<Employee> create(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Mono<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Flux<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> update(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return employeeRepository.deleteById(id);
    }
}
