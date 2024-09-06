package ftn.devops.accommodation.messaging.listener.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import ftn.devops.accommodation.messaging.listener.IMessageListener;
import ftn.devops.accommodation.messaging.messages.UserCreatedMessage;
import ftn.devops.accommodation.service.UserService;
import ftn.devops.accommodation.util.constants.UserMessagingConstants.Queue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCreatedMessageListener implements IMessageListener<UserCreatedMessage> {

    private final UserService userService;

    @Override
    @RabbitListener(queues = Queue.USER_CREATE)
    public void receiveMessage(UserCreatedMessage message) {
        log.info("Received user create message {}", message);
        userService.createUser(message);
    }
}
