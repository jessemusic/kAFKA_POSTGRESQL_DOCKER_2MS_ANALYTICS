package constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JesseAPIsConstants {

    public static final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";

    public static final String POSTS_STORE_SERVICE_URI_CARS = "http://localhost:8080/sale/cars";

    public static final String POSTS_STORE_SERVICE_URI_CAR = "http://localhost:8080/sale/car";

    public static final String KAFKA_TOPIC = "car-post-topic-jesse";

    public static final String KAFKA_GROUP_ID_STORE = "store-post-group-jesse";

    public static final String KAFKA_GROUP_ID_ANALYTICS = "analytics-post-group-jesse";
}
