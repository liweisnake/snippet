package org.levi.reusable.demo.springbatch;

import org.springframework.batch.item.ItemProcessor;

public class MessageItemProcessor implements ItemProcessor<User, Message> {
    public Message process(User item) throws Exception {
        Message message = null;
        if (item.getAge() > 16) {
            message = new Message();
            message.setContent(item.getName() + ",Please come to police station!");
        }
        return message;
    }
}
