package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("emailSender")
public class EmailSender implements IEmailSender {

	@Value("${outgoingMailServer}")
	String outgoingMailServer;

	private ILogger logger;

	@Autowired
	public void setLogger(ILogger logger){
		this.logger = logger;
	}

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+ message+" to "+email + " OutgoingMailserver: " + this.getOutgoingMailServer());
		logger.log("Email is sent: message= "+ message +" , emailaddress ="+ email  );
	}
}
