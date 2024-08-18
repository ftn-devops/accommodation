package ftn.devops.accommodation.config.messaging;

import ftn.devops.accommodation.util.constants.UserMessagingConstants;
import ftn.devops.accommodation.util.constants.UserMessagingConstants.Exchange;
import ftn.devops.accommodation.util.constants.UserMessagingConstants.RoutingKey;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserMessagingConfig {

    @Bean
    TopicExchange userExchange() {
        return new TopicExchange(Exchange.USER);
    }

    @Bean
    public Queue userCreateQueue() {
        return new Queue(UserMessagingConstants.Queue.USER_CREATE);
    }

    @Bean
    public Queue userUpdateQueue() {
        return new Queue(UserMessagingConstants.Queue.USER_UPDATE);
    }

    @Bean
    Binding userCreateBinding() {
        return BindingBuilder.bind(userCreateQueue())
            .to(userExchange())
            .with(RoutingKey.USER_CREATE);
    }

    @Bean
    Binding userUpdateBinding() {
        return BindingBuilder.bind(userUpdateQueue())
            .to(userExchange())
            .with(RoutingKey.USER_UPDATE);
    }
}
