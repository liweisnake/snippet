package org.levi.reusable.demo.jms;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jms/applicationContext-jms-simple.xml"})
public class JmsTest {
	
	@Autowired
	private JmsConsumer consumer;
	
	@Autowired
	private JmsProducer producer;
	
	@Autowired
	private Destination notifyQueue;
	
	@Test
	public void test() {
		producer.produce(notifyQueue);
		consumer.consume();
		
	}

}
