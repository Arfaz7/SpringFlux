package com.example.SpringFlux.controller;

import com.example.SpringFlux.domain.model.Employee;
import com.example.SpringFlux.domain.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_NDJSON_VALUE;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping(value = { "/create", "/" })
    public Mono<Employee> create(@RequestBody Employee e) {
        log.info("Creating Employee {}", e.getName());
        return employeeService.create(e);
    }

    @GetMapping(value = "/{id}")
    public Mono<Employee> findById(@PathVariable("id") Long id) {
        return employeeService.findById(id).log();
    }

    @GetMapping(value = "/name/{name}")
    public Flux<Employee> findByName(@PathVariable("name") String name) {
        return employeeService.findByName(name);
    }

    @GetMapping(produces = APPLICATION_NDJSON_VALUE)
    public Flux<Employee> findAll() {
        Flux<Employee> emps = employeeService.findAll().delayElements(Duration.ofSeconds(1)).log();
        return emps;
    }

    @PutMapping(value = "/update")
    @ResponseStatus(OK)
    public Mono<Employee> update(@RequestBody Employee e) {
        return employeeService.update(e);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable("id") Long id) {
        employeeService.delete(id).subscribe();
    }

}