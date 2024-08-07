package kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver2 {
    @KafkaListener(topics = {"topicA"}, groupId = "gid2")
    public void receive(@Payload String message) {
        System.out.println("Receiver-2 received message= "+ message);
    }

    @KafkaListener(topics = {"topicA2"}, groupId = "gid2")
    public void receive2(@Payload String message) {
        System.out.println("Receiver-2 received message= "+ message);
    }
}
