package com.openbbs.kafka;

import java.util.Properties;

public class UserKafkaProducerConfig {
	private static Properties properties = new Properties();

	public UserKafkaProducerConfig() {
		properties.put("bootstrap.servers", "115.28.170.236:9092");
		properties.put("acks", "all");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("linger.ms", 1);
		properties.put("buffer.memory", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	}

	public Properties getProperties() {
		return properties;
	}

}
