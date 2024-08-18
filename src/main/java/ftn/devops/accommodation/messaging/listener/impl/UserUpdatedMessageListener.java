package ftn.devops.accommodation.messaging.listener.impl;

import ftn.devops.accommodation.messaging.listener.IMessageListener;
import ftn.devops.accommodation.messaging.messages.UserUpdatedMessage;
import ftn.devops.accommodation.util.constants.UserMessagingConstants.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserUpdatedMessageListener implements IMessageListener<UserUpdatedMessage> {

    @Override
    @RabbitListener(queues = Queue.USER_UPDATE)
    public void receiveMessage(UserUpdatedMessage message) {
        log.info("Received user update message {}", message);
    }
}
