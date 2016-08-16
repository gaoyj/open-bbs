package com.openbbs.mq;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/application.xml" })
public class ReplyQueueProducer {

	private static final Logger LOG = Logger.getLogger(ReplyQueueProducer.class);

	@Autowired
	protected JmsTemplate jmsTemplate;

	protected int numberOfMessages = 100;

	StringBuilder payload = null;
	int i = 0;

	@Test
	public void sendMessages() throws JMSException {

		for (; i < numberOfMessages; ++i) {

			payload = new StringBuilder();

			payload.append("Message [").append(i).append("] sent at: ").append(new Date());

			jmsTemplate.send(new MessageCreator() {

				public Message createMessage(Session session) throws JMSException {

					TextMessage message = session.createTextMessage(payload.toString());

					message.setIntProperty("messageCount", i);

					LOG.info("Sending message number [" + i + "]");

					return message;

				}

			});

		}

	}

}
