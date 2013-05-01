package org.levi.reusable.demo.jms;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination notifyQueue;

	public void consume() {
		Object obj = jmsTemplate.receiveAndConvert(notifyQueue);
		System.out.println(obj);
	}

}
