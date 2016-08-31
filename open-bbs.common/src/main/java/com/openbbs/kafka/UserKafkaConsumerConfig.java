package com.openbbs.kafka;
import java.util.Properties;

public class UserKafkaConsumerConfig {

	private static Properties properties = new Properties();

	public UserKafkaConsumerConfig(String groupId) {
		properties.put("bootstrap.servers", "115.28.170.236:9092");
		properties.put("group.id", groupId);
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("session.timeout.ms", "30000");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	}
	
	public Properties getProperties() {
		return properties;
	}

}
