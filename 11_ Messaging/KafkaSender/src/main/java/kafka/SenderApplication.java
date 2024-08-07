package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.time.LocalDate;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting to send a message");
        for(int i=1; i < 10; i++){
            sender.send("topicA", "Hello World " + i);
            sender.send("topicA2", "GoodBy world " + i);
        }
        System.out.println("Message has been sent");
    }
}
