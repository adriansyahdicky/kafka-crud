package com.project.kafka.kafka_crud.consumer;

import com.project.kafka.kafka_crud.common.KafkaTopics;
import com.project.kafka.kafka_crud.dto.EmployeeDTO;
import com.project.kafka.kafka_crud.services.EmployeeServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class EmployeeListener {
    private final EmployeeServices service;

    @KafkaListener(topics = KafkaTopics.EMPLOYEE_TOPIC)
    public void listen(
            @Payload EmployeeDTO employee,
            @Header("CONSUMER_OPERATION") String operation,
            Acknowledgment ack) {
        try {
            switch (operation) {
                case "insert":
                    service.insert(employee);
                    break;
                case "update":
                    service.update(employee);
                    break;
                case "delete":
                    service.delete(employee);
                    break;
                default:
                    log.warn("EmployeeListener.listen has an invalid CONSUMER_OPERATION header {}", operation);
                    break;
            }
            ack.acknowledge();
        } catch (Exception e) {
            log.error("Error processing message: {}", employee, e);
        }
    }
}
