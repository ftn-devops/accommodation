package ftn.devops.accommodation.messaging.listener.impl;

import ftn.devops.accommodation.messaging.listener.IMessageListener;
import ftn.devops.accommodation.messaging.messages.UserCreatedMessage;
import ftn.devops.accommodation.util.constants.UserMessagingConstants.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCreatedMessageListener implements IMessageListener<UserCreatedMessage> {

    @Override
    @RabbitListener(queues = Queue.USER_CREATE)
    public void receiveMessage(UserCreatedMessage message) {
        log.info("Received user create message {}", message);
    }
}
