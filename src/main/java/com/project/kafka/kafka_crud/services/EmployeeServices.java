package com.project.kafka.kafka_crud.services;

import com.project.kafka.kafka_crud.dto.EmployeeDTO;
import com.project.kafka.kafka_crud.model.Employee;
import com.project.kafka.kafka_crud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;

    public void insert(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setMobilePhone(employeeDTO.getMobilePhone());
        employee.setAddress(employeeDTO.getAddress());
        employeeRepository.save(employee);
        log.info("EmployeeService.insert {} was inserted!", employeeDTO);
    }

    public void update(EmployeeDTO employeeDTO){
        this.employeeRepository.findById(employeeDTO.getEmployeeId())
                .ifPresent(employee -> {
                    employee.setName(employeeDTO.getName());
                    employee.setMobilePhone(employeeDTO.getMobilePhone());
                    employee.setAddress(employeeDTO.getAddress());
                    employeeRepository.save(employee);
                });
        log.info("EmployeeService.update {} was updated!", employeeDTO);
    }

    public void delete(EmployeeDTO employeeDTO){
        this.employeeRepository.findById(employeeDTO.getEmployeeId())
                .ifPresent(employeeRepository::delete);
        log.info("EmployeeService.delete {} was deleted!", employeeDTO.getEmployeeId());
    }

    public List<EmployeeDTO> getAllEmployee(){
        return employeeRepository.findAll()
                .stream().map(employee -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setEmployeeId(employee.getId());
                    employeeDTO.setName(employee.getName());
                    employeeDTO.setAddress(employee.getAddress());
                    return employeeDTO;
                }).toList();
    }
}
