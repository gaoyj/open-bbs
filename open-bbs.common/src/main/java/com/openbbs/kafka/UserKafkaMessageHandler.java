package com.openbbs.kafka;

public interface UserKafkaMessageHandler {

	<T> void handleMessage(T message);
}
