package ftn.devops.accommodation.messaging.messages;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AccommodationRatedMessage extends BaseMessage {

    String recipientEmail;

    Float rating;

    String accommodationName;
}
