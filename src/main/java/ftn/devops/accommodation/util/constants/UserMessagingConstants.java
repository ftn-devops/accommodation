package ftn.devops.accommodation.util.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMessagingConstants {

    @UtilityClass
    public class Exchange {

        public static final String USER = "user";
    }

    @UtilityClass
    public class Queue {

        public static final String USER_CREATE =
            Exchange.USER + "." + MessagingConstants.SERVICE_NAME + "-" + RoutingKey.USER_CREATE;

        public static final String USER_UPDATE =
            Exchange.USER + "." + MessagingConstants.SERVICE_NAME + "-" + RoutingKey.USER_UPDATE;
    }

    @UtilityClass
    public class RoutingKey {

        public static final String USER_CREATE = "create";

        public static final String USER_UPDATE = "update";
    }
}

