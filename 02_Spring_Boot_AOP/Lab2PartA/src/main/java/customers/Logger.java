package customers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component("logger")
public class Logger implements ILogger{

	public void log(String logstring) {
		System.out.println("Logging "+LocalDateTime.now()+" "+logstring);		
	}

}
