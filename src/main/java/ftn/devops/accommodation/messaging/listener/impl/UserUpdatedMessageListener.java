package ftn.devops.accommodation.messaging.listener.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import ftn.devops.accommodation.messaging.listener.IMessageListener;
import ftn.devops.accommodation.messaging.messages.UserUpdatedMessage;
import ftn.devops.accommodation.service.UserService;
import ftn.devops.accommodation.util.constants.UserMessagingConstants.Queue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserUpdatedMessageListener implements IMessageListener<UserUpdatedMessage> {

    private final UserService userService;

    @Override
    @RabbitListener(queues = Queue.USER_UPDATE)
    public void receiveMessage(UserUpdatedMessage message) {
       userService.updateUser(message);
    }
}
