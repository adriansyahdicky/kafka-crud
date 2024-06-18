package com.project.kafka.kafka_crud.producer;

import com.project.kafka.kafka_crud.common.KafkaTopics;
import com.project.kafka.kafka_crud.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
@AllArgsConstructor
public class EmployeeProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void insert(EmployeeDTO employee) {
        Message<EmployeeDTO> message = MessageBuilder
                .withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopics.EMPLOYEE_TOPIC)
                .setHeader("CONSUMER_OPERATION", "insert")
                .build();
        CompletableFuture<SendResult<String, Object>> kafkaResultFuture =
                kafkaTemplate.send(message);
        addCallback(employee, kafkaResultFuture);
        log.info("request insert employee --> {}", employee);
    }

    public void update(String employeeId, EmployeeDTO employee) {
        employee.setEmployeeId(employeeId);
        Message<EmployeeDTO> message = MessageBuilder
                .withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopics.EMPLOYEE_TOPIC)
                .setHeader("CONSUMER_OPERATION", "update")
                .build();
        CompletableFuture<SendResult<String, Object>> kafkaResultFuture =
                kafkaTemplate.send(message);
        addCallback(employee, kafkaResultFuture);
        log.info("request update employee --> {}", employee);
    }

    public void delete(String employeeId) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmployeeId(employeeId);
        Message<EmployeeDTO> message = MessageBuilder
                .withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopics.EMPLOYEE_TOPIC)
                .setHeader("CONSUMER_OPERATION", "delete")
                .build();
        CompletableFuture<SendResult<String, Object>> kafkaResultFuture =
                kafkaTemplate.send(message);
        addCallback(employee, kafkaResultFuture);
        log.info("request delete employee --> {}", employeeId);
    }

    private void addCallback(Object message, CompletableFuture<SendResult<String, Object>> kafkaResultFuture) {
        kafkaResultFuture.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Error while sending message {} to topic {}", message,
                        KafkaTopics.EMPLOYEE_TOPIC, ex);
            } else {
                log.info("Success Send {} ", result);
            }
        });
    }
}
