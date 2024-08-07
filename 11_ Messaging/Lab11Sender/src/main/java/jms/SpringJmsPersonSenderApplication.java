package jms;

import jakarta.jms.ConnectionFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import jms.domain.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.Optional;


@SpringBootApplication
@EnableJms
public class SpringJmsPersonSenderApplication implements CommandLineRunner {
	@Autowired
	JmsTemplate jmsTemplate;


	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJmsPersonSenderApplication.class, args);
		context.close();
	}

	public String objectToJsonMapper(Expression expression) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(expression);
	}

	public void sendExpression(String operation, int value) throws Exception{
		Expression expression = new Expression(operation, value);
		String expressionAsString = this.objectToJsonMapper(expression);
		System.out.println("Sending a JMS message:" + expressionAsString);
		jmsTemplate.convertAndSend("calculation",expressionAsString);
	}

	@Override
	public void run(String... args) throws Exception {
		this.sendExpression("+", 10);
		this.sendExpression("*", 2);
		this.sendExpression("/", 4);
		this.sendExpression("-", 6);
	}

}
