package ftn.devops.accommodation.util.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccommodationMessagingConstants {

    @UtilityClass
    public class Exchange {

        public static final String ACCOMMODATION = "accommodation";
    }

    @UtilityClass
    public class RoutingKey {

        public static final String RESERVATION_STATUS_UPDATE = "reservation-status-update";

        public static final String ACCOMMODATION_RATED = "accommodation-rated";
    }
}
