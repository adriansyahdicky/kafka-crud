package com.project.kafka.kafka_crud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @JsonIgnore
    private String employeeId;
    private String name;
    private String mobilePhone;
    private String address;
}
