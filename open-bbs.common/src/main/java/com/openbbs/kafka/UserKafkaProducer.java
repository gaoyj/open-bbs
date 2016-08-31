package com.openbbs.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class UserKafkaProducer<T> {
	
	private Producer<String, T> producer;
	
	private ProducerRecord<String, T> producerRecord;
	
	public UserKafkaProducer(UserKafkaProducerConfig userKafkaProducerConfig) {
		producer = new KafkaProducer<>(userKafkaProducerConfig.getProperties());
	}
	
	public void send(String topic, String key, T message) {
		producerRecord = new ProducerRecord<String, T>(topic, key, message);
		producer.send(producerRecord, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				System.out.println("=================message successfully sent.");
			}
		});
		producer.flush();
	}

}
