package ex8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("mp")
public class MessageProcessor {
	@Autowired
	private ApplicationContext ctx;
	
	public MessageProcessor() {
		System.out.println("Message process constructor");
	}
	
	public void process(String type, String to, String msg) {
		Message m = (Message) ctx.getBean(type);
		m.send(to, msg);
		
	}

}
