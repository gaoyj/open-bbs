package com.openbbs.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openbbs.common.CommonConstants;

public class UserKafkaConsumerRunnable<T> implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(UserKafkaConsumerRunnable.class);

	private UserKafkaMessageHandler messageHandler;

	private KafkaConsumer<String, T> kafkaConsumer;

	private boolean stopConsumer = false;

	private boolean isShutdown = false;

	public UserKafkaConsumerRunnable(UserKafkaMessageHandler messageHandler,
			UserKafkaConsumerConfig kafkaConsumerConfig, List<String> topicList) {
		this.messageHandler = messageHandler;
		kafkaConsumer = new KafkaConsumer<>(kafkaConsumerConfig.getProperties());
		kafkaConsumer.subscribe(topicList);
	}

	@Override
	public void run() {
		while (true) {
			if (this.stopConsumer) {
				break;
			}
			ConsumerRecords<String, T> records = kafkaConsumer.poll(CommonConstants.DEFAULT_RECORDS_COUNT);
			for (ConsumerRecord<String, T> record : records) {
				messageHandler.handleMessage(record);
			}
		}
		shutdown();
	}

	public void stopConsumer() {
		this.stopConsumer = true;
		Thread stopThread = new Thread() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					UserKafkaConsumerRunnable.this.shutdown();
				} catch (InterruptedException e) {
					UserKafkaConsumerRunnable.log.error("kafka consumer thread shutdown error." + e);
				}
			}
		};
		stopThread.start();
	}

	private void shutdown() {
		if (!this.isShutdown) {
			this.kafkaConsumer.unsubscribe();
			this.isShutdown = true;
		}
	}

}
