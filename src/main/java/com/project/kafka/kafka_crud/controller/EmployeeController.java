package com.project.kafka.kafka_crud.controller;

import com.project.kafka.kafka_crud.dto.EmployeeDTO;
import com.project.kafka.kafka_crud.producer.EmployeeProducer;
import com.project.kafka.kafka_crud.services.EmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeProducer employeeProducer;

    private final EmployeeServices employeeServices;

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO employee) {
        employeeProducer.insert(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable("id") String id,
                                              @RequestBody EmployeeDTO employee) {
        employeeProducer.update(id,employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        employeeProducer.delete(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll(){
        return ResponseEntity.ok(employeeServices.getAllEmployee());
    }

}
