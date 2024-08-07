package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        CreateAccountMessage createAccountMessage = new CreateAccountMessage(1263862, "Frank Brown");
        TransferMessage transferMessage1 = new TransferMessage(1263862, 15450);
        TransferMessage transferMessage2 = new TransferMessage(1263862, 12450);

        ObjectMapper objectMapper = new ObjectMapper();
        String createAccountString = objectMapper.writeValueAsString(createAccountMessage);
        String transferMessage1String = objectMapper.writeValueAsString(transferMessage1);
        String transferMessage2String = objectMapper.writeValueAsString(transferMessage2);

//        sender.send("bank-create-account", createAccountString);
        Thread.sleep(1000);
        sender.send("bank-withdraw", transferMessage2String);
        sender.send("bank-deposit", transferMessage1String);

        System.out.println("Message has been sent");
    }
}
