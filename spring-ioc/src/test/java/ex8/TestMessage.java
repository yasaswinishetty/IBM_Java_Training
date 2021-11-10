package ex8;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessage {
	
	@Test
	public void testSend() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		
		MessageProcessor mp = (MessageProcessor) ctx.getBean("mp");
		
		mp.process("sms", "473348895", "Hello! How are you?");
		mp.process("email", "yashu@gmail.com", "Good Morning");
	}

}
