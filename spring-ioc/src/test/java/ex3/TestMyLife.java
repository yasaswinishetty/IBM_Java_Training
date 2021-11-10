package ex3;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyLife {
	
	@Test
	public void testLife() {
//		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ex3cxt.xml");
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("ex3cxt.xml");
		appCtx.getBean(MyLife.class);
		
		appCtx.close();
	}

}
