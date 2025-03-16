package com.kafkalectures.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkalectures.constants.AppConstants;
import com.kafkalectures.entity.Order;

@Service
public class OrderService {
	private final KafkaTemplate<String, Order> kafkaTemplate;

    OrderService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	public String addMsg(Order order) {

		// sends msg to kafka topic
		kafkaTemplate.send(AppConstants.TOPIC,order.getId(), order);

		return "Msg Published To Kafka Topic";
	}

}
