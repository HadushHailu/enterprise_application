package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService(){
        return new CustomerService();
    }

    @Bean
    public CustomerDAO customerDAO(){
        return new CustomerDAO();
    }

    @Bean
    public EmailSender emailSender(){
        return new EmailSender();
    }

    @Bean
    public Logger logger(){
        return new Logger();
    }
}
