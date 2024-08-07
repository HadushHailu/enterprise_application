package jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaxMDB {

    @JmsListener(destination = "large-transfer")
    public void receive(final String messageAsString) {
        System.out.println("JMS receiver received message:" + messageAsString);
     }
}

