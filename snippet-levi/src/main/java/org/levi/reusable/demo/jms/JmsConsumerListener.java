package org.levi.reusable.demo.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class JmsConsumerListener implements MessageListener{

	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;
		try {
			System.out.println(mapMessage.getString("email"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
