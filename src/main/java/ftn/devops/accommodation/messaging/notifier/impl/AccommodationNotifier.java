package ftn.devops.accommodation.messaging.notifier.impl;

import ftn.devops.accommodation.messaging.messages.AccommodationRatedMessage;
import ftn.devops.accommodation.messaging.messages.ReservationStatusUpdateMessage;
import ftn.devops.accommodation.messaging.notifier.BaseNotifier;
import ftn.devops.accommodation.messaging.notifier.IAccommodationNotifier;
import ftn.devops.accommodation.util.constants.AccommodationMessagingConstants.Exchange;
import ftn.devops.accommodation.util.constants.AccommodationMessagingConstants.RoutingKey;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccommodationNotifier extends BaseNotifier implements IAccommodationNotifier {

    public AccommodationNotifier(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }

    @Override
    public void fireAccommodationRatedNotification(AccommodationRatedMessage message) {
        super.sendMessage(Exchange.ACCOMMODATION, RoutingKey.ACCOMMODATION_RATED, message);
    }

    @Override
    public void fireReservationStatusUpdateNotification(ReservationStatusUpdateMessage message) {
        super.sendMessage(Exchange.ACCOMMODATION, RoutingKey.RESERVATION_STATUS_UPDATE, message);
    }
}
