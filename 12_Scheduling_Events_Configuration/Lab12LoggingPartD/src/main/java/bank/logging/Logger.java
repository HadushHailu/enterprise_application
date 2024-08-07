package bank.logging;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Logger implements ILogger{

	org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
	public void log(String logstring) {
//		java.util.logging.Logger.getLogger("BankLogger").info(logstring);
		logger.info( "[[[*]]] " + logstring);
	}

}
