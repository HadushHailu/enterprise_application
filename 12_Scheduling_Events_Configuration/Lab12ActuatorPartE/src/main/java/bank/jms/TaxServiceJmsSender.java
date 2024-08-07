package bank.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaxServiceJmsSender implements IJMSSender{
    @Autowired
    JmsTemplate jmsTemplate;
    public void sendJMSMessage (String text){
        jmsTemplate.convertAndSend("large-transfer",text);
    }
}
