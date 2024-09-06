package ftn.devops.accommodation.messaging.messages;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ReservationStatusUpdateMessage extends BaseMessage {

    String recipientEmail;

    String accommodationName;

    String reservationStatus;
}
