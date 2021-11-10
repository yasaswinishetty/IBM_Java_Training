package ex9;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestExchange {
	
	@Test
	public void testConfig() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ExchangeConfig.class);
		
		ExchangeService es = (ExchangeService) ctx.getBean("ex");
		es.convert();
	}

}
