package org.levi.reusable.demo.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	

	public void produce(Destination d){
		final String userName = "levi";
		final String email = "liwei_snake@yahoo.com.cn";
		jmsTemplate.send(d, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {

				MapMessage message = session.createMapMessage();
				message.setString("userName", userName);
				message.setString("email", email);

				message.setStringProperty("objectType", "user");

				return message;
			}
		});
	}
	
}
