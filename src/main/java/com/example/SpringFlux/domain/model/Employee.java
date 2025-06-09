package com.example.SpringFlux.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
public class Employee {

    @Id
    private Long id;
    private String name;
    private long salary;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
