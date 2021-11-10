package ex8;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("email")
@Lazy
public class EmailMessage implements Message {
	
	public EmailMessage() {
		System.out.println("Email Message Constructor");
	}

	@Override
	public void send(String to, String msg) {
		System.out.println("Email sent to " + to + " as " + msg);
	}

}
