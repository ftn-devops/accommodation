package ftn.devops.accommodation.messaging.listener;

import ftn.devops.accommodation.messaging.messages.BaseMessage;

public interface IMessageListener<T extends BaseMessage> {

    void receiveMessage(T message);
}
