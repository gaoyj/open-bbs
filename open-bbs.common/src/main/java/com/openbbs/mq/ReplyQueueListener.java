package com.openbbs.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author gaoyj
 * @date 2016年8月12日
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:activemq.xml" })
public class ReplyQueueListener implements MessageListener {
	
	private static final Logger LOG = Logger.getLogger(ReplyQueueListener.class);


	@Test
	public void onMessage(Message message) {
		try {
			TextMessage msg = (TextMessage) message;
			LOG.info("Consumed message: " + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
