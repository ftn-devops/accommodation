package ftn.devops.accommodation.messaging.notifier;

import ftn.devops.accommodation.messaging.messages.AccommodationRatedMessage;
import ftn.devops.accommodation.messaging.messages.ReservationStatusUpdateMessage;

public interface IAccommodationNotifier {

    void fireAccommodationRatedNotification(AccommodationRatedMessage message);

    void fireReservationStatusUpdateNotification(ReservationStatusUpdateMessage message);
}
